package com.tsinghuait.logistics.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Loadlistbarcode;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.service.HallarrivaIBarcodeService;
import com.tsinghuait.logistics.service.HallarrivallistService;
import com.tsinghuait.logistics.util.Biji;
import com.tsinghuait.logistics.util.CreateIdHelp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/hallarrivallist")
public class HallarrivallistController {
	@Resource
	private JedisPool jsd;// 得到缓存对象

	@Resource
	private HallarrivallistService hs;

	@Resource
	private HallarrivaIBarcodeService hb;

	@RequestMapping("/hello")
	public String goto_hallarrivallist() {
		return "hallarrivallist";
	}

	@Resource
	private CreateIdHelp ch;

	@RequestMapping("/hello1")
	@ResponseBody
	public Biji insert_employee(MultipartFile mfile, String radio, String tranId, String transNumber,
			String checkstate) throws IOException {
		Jedis jd = jsd.getResource();// redis

		Hallarrivallist h = new Hallarrivallist();// 新建接中中转接收对象
		/* CreateIdHelp create = new CreateIdHelp();// 新建生产id 对象 */
		String id = ch.getHallarrivllist_id("hid");// 从redis里得到中转接收单的主键
		h.setHid(id);
		h.setTimee(new Date());// 现在的时间

		// 本中转中心的编号和上一中转地以后在添加
		String cc = "";
		if (radio.equals("0")) {// 判断是中转中心的还是营业厅的
			cc = tranId;// 货运中转单号
		} else {
			cc = transNumber;// 装车单号
		}

		h.setTransferNumber(cc);// 中转接收单
		h.setCheckstate(checkstate);// 接收状态
		jd.set("hid", id);// 添加成功后Redis hid要同步
		

		// 表到入数据库
		String filename = mfile.getOriginalFilename();// 得到客户端上传文件的名字
		System.out.println("filename:" + filename);
		FileInputStream fis = (FileInputStream) mfile.getInputStream();// 文件输入流

		Workbook workbook = null;
		if (filename.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (filename.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}

		// 得到sheet的总数
		int numberOfSheets = workbook.getNumberOfSheets();

		List<String> dlist = new ArrayList<>();// 这个集合用于判断excel表中的包裹号是否又重复的
		List<HallarrivalBarcode> list = new ArrayList<>();// excel包中是完好的和损坏的包裹
		List<String> eList = new ArrayList<>();// 损坏的包裹
		List<String> flist = new ArrayList<>();// 丢失的包裹

		List<HallarrivalBarcode> jlist = new ArrayList<>();

		// 循环每一个sheet
		for (int i = 0; i < numberOfSheets; i++) {
			// 得到第i个sheet
			Sheet sheet = workbook.getSheetAt(i);

			// 得到行的迭代器
			Iterator<Row> rowIterator = sheet.iterator();
			// 循环每一列
			while (rowIterator.hasNext()) {

				// 得到一行对象
				Row row = rowIterator.next();

				// 如果是第一行，跳出本次循环
				if (row.getRowNum() == 0) {
					continue;
				}
				// 因为表中的是数字类型的这里要先转一下string类型
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);

				String ordernumber = row.getCell(0).getStringCellValue();
				String htype = row.getCell(1).getStringCellValue();
				if (dlist.contains(ordernumber)) {
					// 如果excel中的包裹好有重复的while本次循环里下面的程序不走，直接进行下一一循环
					continue;
				}

				dlist.add(ordernumber);// 如果没有重复的就添加进去
										// 这样方便下次比对

				HallarrivalBarcode d = new HallarrivalBarcode();// 生成中转接收清单对象

				// 给对象赋值

				d.setOrderNumber(ordernumber);
				
				d.sethType(htype);
				d.setHid(id);
				String hBId = ch.getHallarrivllist_id("hBId");
				d.sethBId(hBId);

				if (d.gethType().equals("1")) {// 判断给对象是否是损坏的物品
					eList.add(d.getOrderNumber());
				}
				list.add(d);// 从表中的数据进行生成的对象添加进集合
				jd.set("hBId", hBId);// 同步redis
				jlist.add(d);
				
			}
		}

		// 根据前台页面显示的装车单或转运单 查询清单并将帮号添加进集合
		List<String> slist = new ArrayList<>();
		if (radio.equals("0")) {
			List<Transshipmentlist_barcode> blist = hs.getTransshipmenglists(tranId);
			for (Transshipmentlist_barcode transshipmentlist : blist) {
				slist.add(transshipmentlist.getOrderNumber());
			}
		} else {
			List<Loadlistbarcode> clist = hs.getLoadlists(transNumber);
			for (Loadlistbarcode loadlistbarcode : clist) {
				slist.add(loadlistbarcode.getOrderNumber());
			}
		}

		// 把上面的中转接收清单对象转为string类型的集合， string是包裹单号
		List<String> hList = new ArrayList<>();
		for (HallarrivalBarcode string : list) {
			hList.add(string.getOrderNumber());
		}

		for (String string : slist) {// 从数据查询的清单和excel导入的清单进行对比，找到丢失的单
			if (!hList.contains(string)) {
				flist.add(string);
			}
		}
        
		
		
		for (String string : flist) {// 对比之后将丢失的包裹添加进数据库
			HallarrivalBarcode hal = new HallarrivalBarcode();
			String hBid = ch.getHallarrivllist_id("hBId");
			hal.sethBId(hBid);
			hal.setHid(id);
			hal.sethType("2");
			hal.setOrderNumber(string);
			jd.set("hBId", hBid);
			jlist.add(hal);
		}
		
		Biji bi=new Biji();
		
		//统计中转接收情况
		Integer yingshou=slist.size();
		Integer shishou=list.size();
		Integer shunshi=eList.size();
		Integer diushi=flist.size();
		
		try {// 执行批量添加
			hs.zhongzhuanjieshou(h, jlist);
			bi.setHa(h);
			bi.setBiaoji("ok");
			bi.setHsddd("本次应收包裹"+yingshou+"个，实收"+shishou+"个，丢失包裹"+diushi+"个,损坏"+shunshi+"个。");
			return bi;
		} catch (Exception e) {
			e.printStackTrace();
			// 发生异常时redis的主键也回滚，实现主键不断层
			String hid = ch.getHallarrllist_ids("hid", 1);
			System.out.println("hid:" + hid);
			String hbid = ch.getHallarrllist_ids("hBId", jlist.size());
			System.out.println("hbid:" + hbid);
			jd.set("hid", hid);
			jd.set("hBId", hbid);
		}
		
			
			bi.setBiaoji("error");
			bi.setHsddd("生成中转中心单有问题，请重新提交！");
		return bi;

	}

	@RequestMapping("/hello2")
	public void outExcle(String hid,HttpServletResponse response) throws Exception{
		Hallarrivallist hadl = hs.getHallarrivallist(hid);
		String[] excelHeader = { "hid", "timee", "transferNumber" };
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Campaign");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}

		row = sheet.createRow(1);

		row.createCell(0).setCellValue(hadl.getHid());
		row.createCell(1).setCellValue(hadl.getTimee());
		row.createCell(2).setCellValue(hadl.getTransferNumber());

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=student.xls");
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	    

	}

}

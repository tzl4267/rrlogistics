package com.tsinghuait.logistics.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.data.redis.connection.ReactiveHashCommands.HDelCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Loadlistbarcode;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.pojo.User;
import com.tsinghuait.logistics.service.HallarrivaIBarcodeService_w;
import com.tsinghuait.logistics.service.HallarrivallistService;
import com.tsinghuait.logistics.util.Biji;
import com.tsinghuait.logistics.util.CreateIdHelp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/hallarrivallist")
public class HallarrivallistController {// wangjing
	@Resource
	private JedisPool jsd;// 得到缓存对象

	@Resource
	private HallarrivallistService hs;

	@Resource
	private HallarrivaIBarcodeService_w hb;

	@RequestMapping("/hello")
	public String goto_hallarrivallist() {
		return "hallarrivallist";
	}

	@Resource
	private CreateIdHelp ch;

	/**
	 * poi 导入
	 */
	@RequestMapping("/hello1")
	@ResponseBody
	public Biji insert_employee(MultipartFile mfile, String radio, String tranId, String transNumber, String checkstate,HttpServletRequest request)
			throws IOException {
		// redis
		Jedis jd = jsd.getResource();
		// 新建中转接收对象
		Hallarrivallist h = new Hallarrivallist();	
		// 从redis里得到中转接收单的主键
		String id = ch.getHallarrivllist_id("hid");
		HttpSession see=request.getSession();
		h.setAgencyId((String)see.getAttribute("agencyId"));
		h.setHid(id);
		// 现在的时间
		h.setTimee(new Date());
		// 本中转中心的编号和上一中转地以后在添加
		String cc = "";
		// 判断是中转中心的还是营业厅的
		if (radio.equals("0")) {
			// 货运中转单号
			cc = tranId;
		} else {
			// 装车单号
			cc = transNumber;
		}
		
		// 中转接收单
		h.setTransferNumber(cc);
		// 接收状态
		h.setCheckstate(checkstate);
		// 添加成功后Redis hid要同步
		jd.set("hid", id);

		// 表到入数据库
		// 得到客户端上传文件的名字
		String filename = mfile.getOriginalFilename();
		// 文件输入流
		FileInputStream fis = (FileInputStream) mfile.getInputStream();

		Workbook workbook = null;
		// poi判断表格的后缀格式
		if (filename.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (filename.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}

		// 得到sheet的总数
		int numberOfSheets = workbook.getNumberOfSheets();
		// 这个集合用于判断excel表中的包裹号是否又重复的
		List<String> dlist = new ArrayList<>();
		// excel包中是完好的和损坏的包裹
		List<HallarrivalBarcode> list = new ArrayList<>();
		// 损坏的包裹
		List<String> eList = new ArrayList<>();
		// 丢失的包裹
		List<String> flist = new ArrayList<>();
		// 最后向数据库里添加清单的对象集合
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
					// 如果excel中的包裹好有重复的while本次循环里下面的程序不走，直接进行下一循环
					continue;
				}
				// 如果没有重复的就添加进去, 这样方便下次比对
				dlist.add(ordernumber);
										
				// 生成中转接收清单对象
				HallarrivalBarcode d = new HallarrivalBarcode();
				// 给对象赋值
				d.setOrderNumber(ordernumber);
				d.sethType(htype);
				d.setHid(id);
				
				String hBId = ch.getHallarrivllist_id("hBId");
				d.sethBId(hBId);
				// 判断给对象是否是损坏的物品
				if (d.gethType().equals("1")) {
					eList.add(d.getOrderNumber());
				}
				// 从表中的数据进行生成的对象添加进集合
				list.add(d);
				// 同步redis
				jd.set("hBId", hBId);
				jlist.add(d);

			}
		}

		// 根据前台页面显示的装车单或转运单从数据库里 查询清单并将帮号添加进集合
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
		
		// 从数据查询的清单和excel导入的清单进行对比，找到丢失的单
		for (String string : slist) {
			if (!hList.contains(string)) {
				flist.add(string);
			}
		}
		// 对比之后将丢失的包裹添加进数据库
		for (String string : flist) {
			HallarrivalBarcode hal = new HallarrivalBarcode();
			String hBid = ch.getHallarrivllist_id("hBId");
			hal.sethBId(hBid);
			hal.setHid(id);
			hal.sethType("2");
			hal.setOrderNumber(string);
			jd.set("hBId", hBid);
			jlist.add(hal);
		}

		Biji bi = new Biji();

		// 统计中转接收情况
		Integer yingshou = slist.size();
		Integer shishou = list.size();
		Integer shunshi = eList.size();
		Integer diushi = flist.size();

		try {// 执行批量添加
			hs.zhongzhuanjieshou(h, jlist);
			bi.setHa(h);
			bi.setBiaoji("ok");
			// 计算poi导入的情况并返回前台
			bi.setHsddd("本次应收包裹" + yingshou + "个，实收" + shishou + "个，丢失包裹" + diushi + "个,损坏" + shunshi + "个。");
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
	public void outExcle(String hid, HttpServletResponse response) throws Exception {// poi导出
		Hallarrivallist hadl = hs.getHallarrivallist(hid);// 根据编号查询中转中心单
		Agency ag = hs.getAgency(hadl.getAgencyId());// 查询本中转中心的名称
		String[] excelHeader = { "中转中心接收编号", "装车单/转运单号", "接收时间", "本中转中心名称" };
		String[] excelHeader1 = { "中转中心接收清单编号", "中转中心接收单号", "快递编号", "到达状态" };
		// 查询中转接收清单
		List<HallarrivalBarcode> hals = hb.selectallByHid(hid);

		int a = 0;// 损坏的包裹
		int b = 0;// 丢失的包裹
		
		// 计算损坏和丢失包裹的数量
		for (HallarrivalBarcode hallarrivalBarcode : hals) {
			if (hallarrivalBarcode.gethType().equals("1")) {
				a++;
			} else if (hallarrivalBarcode.gethType().equals("2")) {
				b++;
			}
		}
		
		// 实收的包裹
		String c = String.valueOf(hals.size() - b);

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("中转中心接收单");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		// 添加标题字段
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}
		// 时间data格式转string 格式
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf2.format(hadl.getTimee());

		row = sheet.createRow(1);

		row.createCell(0).setCellValue(hadl.getHid());
		row.createCell(1).setCellValue(hadl.getTransferNumber());
		row.createCell(2).setCellValue(dd);
		row.createCell(3).setCellValue(ag.getAgencyName());
		row = sheet.createRow(2);
		row.createCell(0).setCellValue("应收包裹");
		row.createCell(1).setCellValue("实收包裹");
		row.createCell(2).setCellValue("损坏包裹");
		row.createCell(3).setCellValue("丢失包裹");
		row = sheet.createRow(3);
		row.createCell(0).setCellValue(String.valueOf(hals.size()));
		row.createCell(1).setCellValue(c);
		row.createCell(2).setCellValue(String.valueOf(a));
		row.createCell(3).setCellValue(String.valueOf(b));

		HSSFSheet sheet1 = wb.createSheet("中转中心接收清单");
		HSSFRow row1 = sheet1.createRow((int) 0);
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		// 标题
		for (int i = 0; i < excelHeader1.length; i++) {
			HSSFCell cell = row1.createCell(i);
			cell.setCellValue(excelHeader1[i]);
			cell.setCellStyle(style1);
			sheet.autoSizeColumn(i);
		}

		for (int i = 1; i <= hals.size(); i++) {
			row = sheet1.createRow(i);

			row.createCell(0).setCellValue(hals.get(i - 1).gethBId());
			row.createCell(1).setCellValue(hals.get(i - 1).gethBId());

			row.createCell(2).setCellValue(hals.get(i - 1).getOrderNumber());
			String ac = hals.get(i - 1).gethType();
			// 三目运算嵌套
			row.createCell(3).setCellValue((ac.equals("0") ? "完好" : ac).equals("2") ? "丢失" : (ac.equals("0") ? "完好" : "损坏"));

		}
		// 设置发送流文件的格式
		response.setContentType("application/vnd.ms-excel");
		// 设置格式到前台浏览器说明该文件是一个下载文件
		response.setHeader("Content-disposition", "attachment;filename=student.xls");
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 根据时间和中转中心编号查询中转接收单
	 */
	@RequestMapping("/hello3")
	@ResponseBody
	public List<Hallarrivallist> chaxundingdan(Hallarrivallist ha, HttpServletRequest request) {
		HttpSession see=request.getSession();
		ha.setAgencyId((String)see.getAttribute("agencyId"));
		System.out.println(ha);
		List<Hallarrivallist> hal = hs.gethallarriva(ha);
		for (Hallarrivallist hallarrivallist : hal) {
			System.out.println(hallarrivallist);
		}

		return hal;
	}

	/**
	 * 装车单离开焦点事件
	 */
	@RequestMapping("/hello4")
	@ResponseBody
	public Biji blur(String transNumber) { 
		Loadlist lo = hs.getLoadlistByID(transNumber);
		Biji bi = new Biji();
		if (lo == null) {
			bi.setBiaoji("error");
		} else {
			bi.setBiaoji("ok");
		}
		return bi;
	}

	/**
	 * 中转单离开焦点事件
	 */
	@RequestMapping("/hello5")
	@ResponseBody
	public Biji blur1(String tranId) { 
		Transshipmentlist lo = hs.getTransshipmentlistById(tranId);
		Biji bi = new Biji();
		if (lo == null) {
			bi.setBiaoji("error");
		} else {
			bi.setBiaoji("ok");
		}
		return bi;
	}
}

package com.tsinghuait.logistics.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Moneyinlist;
import com.tsinghuait.logistics.pojo.PageBean;
import com.tsinghuait.logistics.service.HallarrivallistService;
import com.tsinghuait.logistics.service.MoneyinlistService;
import com.tsinghuait.logistics.util.MoneyHelp;

@Component
@RequestMapping("/moneyinlist")
public class MoneyinlistController {// wj
	@Resource
	private MoneyinlistService ml;

	@Resource
	private HallarrivallistService hs;

	@RequestMapping("/hello")
	public String go_moneyinlist() {
		return "moneyinlist";
	}

	/**
	 * 根据条件查询 收款明细清单
	 */
	@RequestMapping("/hello1")
	@ResponseBody // 根据条件查询内容 收款明细
	public MoneyHelp seach(String begin_time, String end_time, String nowPage, String agencyId,
			HttpServletRequest request) throws ParseException {
		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 * Date begin_time1 = dateFormat.parse(begin_time); Date end_time1 =
		 * dateFormat.parse(end_time); 这里不用转，数据库里是时间格式，写在查询语句时用字符串能识别，还能用函数
		 */
		if (begin_time.equals("")) {// 文本框和date里什么都不填
									// 前台传到是""而不是null，这里要处理一下不查询语句不好判断(查询语句里不能写!="")
			begin_time = null;
		}
		if (end_time.equals("")) {
			end_time = null;
		}
		if (agencyId.equals("")) {
			agencyId = null;
		}

		// 把查詢條件放入session中 方便poi导出来用
		HttpSession session = request.getSession();
		session.setAttribute("begin_time", begin_time);
		session.setAttribute("agencyId_1", agencyId);
		session.setAttribute("end_time", end_time);

		// 把条件放入map集合中，
		Map<String, Object> map = new HashMap<>();
		map.put("begin_time", begin_time);
		map.put("end_time", end_time);
		map.put("agencyId", agencyId);

		// 根据map的参数查询收款明细清单
		Map<String, Object> gd = ml.selectCount(map);

		// 由Long直接转的话会内存溢出，这里要先转为字符串在转为int类型
		Integer allCount = Integer.parseInt(String.valueOf(gd.get("countAll")));
		Double sumMoney = (Double) gd.get("sunMoney");
		//new 分页对象
		PageBean<Moneyinlist> pb = new PageBean<>();
		//判断是否查询出内容，
		if (allCount != 0) {
			pb.setAllCount(allCount);
			if (nowPage.equals("over")) {
				pb.setNowPage(pb.getAllPage());
			} else {
				//如果查询出内容，在这里同过逻辑判断来限制最小也不的低于1，最大不能超过最大页
				if (Integer.valueOf(nowPage) < 1) {
					pb.setNowPage(1);
				} else if (Integer.valueOf(nowPage) > pb.getAllPage()) {
					pb.setNowPage(pb.getAllPage());
				} else {
					//不满足上面的条件，当前页还是当前页
					pb.setNowPage(Integer.valueOf(nowPage));
				}
			}
			//计算出分页中offset（从第几行开始查起，mysql第一行是0）的值  （当前页-1）*一页显示多少行 后面的limit参数是一页显示几条
			map.put("p", (pb.getNowPage() - 1) * pb.getPageNumber());
			map.put("pb", pb);
			
			/*根据map参数查询出当页的收款清单对象 这里有个时间格式对象通过json发送到前台如果要显示yyyy-MM-dd HH:mm:ss
			 就要加这个注解@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")*/
			List<Moneyinlist> moneys = ml.selectMoneyinlists(map);

			pb.setLl(moneys);
		} else {
			pb.setAllCount(0);
			pb.setAllPage(0);
			pb.setNowPage(0);
		}
		
		//new 一个自定义帮助类的对象
		MoneyHelp moneyHelp = new MoneyHelp();
		moneyHelp.setPagebean(pb);
		//将总金额一起封装到对象里，返回台用
		moneyHelp.setSum_money(sumMoney);

		return moneyHelp;

	}

	/**
	 * @param request
	 * @param response
	 * @throws Exception
	 * poi导出清单，注意这里查询的参数是session 取得，并在前台页面做了判断，只有先查询出了收款明细才能poi导出
	 */
	@RequestMapping("/hello2")
	public void outExcle(HttpServletRequest request, HttpServletResponse response) throws Exception {// poi导出
		
		HttpSession session = request.getSession();
		//从sessio作用域中去参数
		String begin_time = (String) session.getAttribute("begin_time");
		String end_time = (String) session.getAttribute("end_time");
		String agencyId = (String) session.getAttribute("agencyId_1");
		Map<String, Object> map = new HashMap<>();
		Agency ag = null;
		//如果机构编号是空那么下面poi导出的机构就只是一个了
		if (agencyId != null || agencyId != "") {
			// 查询本机构的名称
			ag = hs.getAgency(agencyId);
		}

		map.put("begin_time", begin_time);
		map.put("end_time", end_time);
		map.put("agencyId", agencyId);
		//根据map中的参数查询出收款明细清单
		List<Moneyinlist> list = ml.selectMoneyinlists(map);
		String[] excelHeader = { "收款条形码", "收款日期", "收款金额", "包裹单号", "网点名称" };

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("结算清单表");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		for (int i = 0; i < excelHeader.length; i++) {// 添加标题字段
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}

		double a = 0;
		for (int i = 1; i <= list.size(); i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(list.get(i - 1).getMid());
			// 时间data格式转string	放入Excel中
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");														// 格式
			String dd = sdf2.format(list.get(i - 1).getmTimee());
			row.createCell(1).setCellValue(dd);
			row.createCell(2).setCellValue(list.get(i - 1).getMoneyTota());
			row.createCell(3).setCellValue(list.get(i - 1).getOrderNumber());
			//如果机构编号是空，这里查询的是整个流中心的收款明细清单，这里的机构就要循环一便查询一便了
			if (agencyId == null || agencyId == "") {
				ag = hs.getAgency(list.get(i - 1).getAgencyId());
			}
			row.createCell(4).setCellValue(ag.getAgencyName());
			//计算收款的总金额
			a = a + list.get(i - 1).getMoneyTota();

		}
		row = sheet.createRow(list.size() + 1);
		row.createCell(3).setCellValue("总金额：");
		row.createCell(4).setCellValue(a + "元");
		// 设置发送流文件的格式
		response.setContentType("application/vnd.ms-excel");
		// 设置格式到前台浏览器说明该文件是一个下载文件
		response.setHeader("Content-disposition", "attachment;filename=student.xls");
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

}

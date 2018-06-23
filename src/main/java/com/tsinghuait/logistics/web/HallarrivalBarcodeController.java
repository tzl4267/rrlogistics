package com.tsinghuait.logistics.web;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Repertoryin;
import com.tsinghuait.logistics.service.HallarrivalBarcodeService;
import com.tsinghuait.logistics.service.RepertoryinService;

@Controller
@RequestMapping("/hb")
public class HallarrivalBarcodeController {
	@Resource
	private HallarrivalBarcodeService hbs;
	@Resource
	private RepertoryinService rs;

	@RequestMapping("/selectHb")
	public String selectAll(HallarrivalBarcode hallarrivalBarcode,ModelMap map) {
		hallarrivalBarcode.sethType("0");
		map.put("hbList", hbs.selectAll(hallarrivalBarcode));
		return "insertRe";
	}
	
	@RequestMapping("/insertHb")
	public String selectAll(Repertoryin repertoryin) {
		Date date = new Date();
		repertoryin.setRiTimee(date);
		rs.insertRepertoryin(repertoryin);
		return "";
	}
}

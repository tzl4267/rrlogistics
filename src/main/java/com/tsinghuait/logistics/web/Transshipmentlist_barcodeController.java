package com.tsinghuait.logistics.web;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.service.TransshipmentlistService;
import com.tsinghuait.logistics.service.Transshipmentlist_barcodeService;
import com.tsinghuait.logistics.service.TruckService;

@Controller
@RequestMapping("/tb")
public class Transshipmentlist_barcodeController {
	@Resource
	private TransshipmentlistService ts;
	@Resource
	private Transshipmentlist_barcodeService tbs;
	@Resource
	private TruckService tService;

	@RequestMapping("/insert")
	public String insertTb(ModelMap map) {
		map.put("truckList", tService.selectTruck());
		return "insertTb";
	}

	@RequestMapping("/insertTp")
	public String insertTb(Transshipmentlist tp) {
		Date date = new Date();
		tp.setTranTime(date);
		ts.insertTransshipmentlist(tp);
		return "showTb";
	}
	
	@RequestMapping("/insertTb")
	public String insertTb(Transshipmentlist_barcode tb) {
		tbs.insertTransshipmentlist_barcode(tb);
		return "";
	}

}

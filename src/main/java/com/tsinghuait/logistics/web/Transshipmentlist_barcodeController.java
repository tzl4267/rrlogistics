package com.tsinghuait.logistics.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.service.TransshipmentlistService;
import com.tsinghuait.logistics.service.Transshipmentlist_barcodeService;
import com.tsinghuait.logistics.service.TruckService;
import com.tsinghuait.logistics.util.CreateIdHelp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/tb")
public class Transshipmentlist_barcodeController {
	@Resource
	private TransshipmentlistService ts;
	@Resource
	private Transshipmentlist_barcodeService tbs;
	@Resource
	private TruckService tService;
	@Resource
	private JedisPool jp;
	@Resource
	private CreateIdHelp ch;

	@RequestMapping("/insert")
	public String insertTb(ModelMap map) {
		map.put("truckList", tService.selectTruck());
		return "insertTb";
	}

	@RequestMapping("/insertTransshipmentlist")
	@ResponseBody
	public HashMap<String, String> insertTb(Transshipmentlist transshipmentlist) {
		Jedis jd = jp.getResource();
		String primaryKey_tranId = ch.getHallarrivllist_id("tranId");
		transshipmentlist.setTranId(primaryKey_tranId);
		jd.set("tranId", primaryKey_tranId);
		HashMap<String, String> map = new HashMap<>();
		Date date = new Date();
		transshipmentlist.setTranTime(date);
		int number = ts.insertTransshipmentlist(transshipmentlist);
		if (number > 0) {
			map.put("msg", "ok");
			map.put("primaryKey_tranId", primaryKey_tranId);
		} else {
			map.put("msg", "error");
		}
		return map;
	}

	@RequestMapping("/insertTransshipmentlist_barcode")
	@ResponseBody
	public HashMap<String, String> insertTb(Transshipmentlist_barcode transshipmentlist_barcode) {
		Jedis jd = jp.getResource();
		String primaryKey_primaryKey = ch.getHallarrivllist_id("primaryKey");
		transshipmentlist_barcode.setPrimarykey(primaryKey_primaryKey);
		jd.set("primaryKey", primaryKey_primaryKey);
		HashMap<String, String> map = new HashMap<>();
		List<String> orderNumberList = new ArrayList<>();
		String orderNumber = transshipmentlist_barcode.getOrderNumber();
		int number = 0;
		if (jd.exists("tb")) {
			String str = jd.get("tb");
			orderNumberList = JSON.parseArray(str, String.class);
			if (!orderNumberList.contains(orderNumber)) {
				number = tbs.insertTransshipmentlist_barcode(transshipmentlist_barcode);
			}
		} else {
			number = tbs.insertTransshipmentlist_barcode(transshipmentlist_barcode);
		}
		if (number > 0) {
			orderNumberList.add(orderNumber);
			jd.set("tb", JSON.toJSONString(orderNumberList));
			map.put("msg", "ok");
		} else {
			map.put("msg", "error");
		}
		return map;
	}

}

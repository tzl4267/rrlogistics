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
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.PageBean;
import com.tsinghuait.logistics.pojo.Repertory;
import com.tsinghuait.logistics.pojo.Repertoryin;
import com.tsinghuait.logistics.pojo.Repertoryout;
import com.tsinghuait.logistics.service.HallarrivalBarcodeService;
import com.tsinghuait.logistics.service.RepertoryService;
import com.tsinghuait.logistics.service.RepertoryinService;
import com.tsinghuait.logistics.service.RepertoryoutService;
import com.tsinghuait.logistics.util.CreateIdHelp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/hb")
public class HallarrivalBarcodeController {
	@Resource
	private HallarrivalBarcodeService hbs;
	@Resource
	private RepertoryinService rs;
	@Resource
	private RepertoryService rService;
	@Resource
	private RepertoryoutService roService;
	@Resource
	private JedisPool jp;
	@Resource
	private CreateIdHelp ch;

	@RequestMapping("/selectPageRepertory")
	public String selectAll1(PageBean<HallarrivalBarcode> page, HallarrivalBarcode hb, ModelMap map) {
		page = hbs.selectPage(hb, page);
		map.put("pageBean", page);
		return "insertRepertory";
	}

	@RequestMapping("/insertRepertoryin")
	@ResponseBody
	public HashMap<String, String> insertRepertoryin(Repertoryin repertoryin) {
		Jedis jd = jp.getResource();
		String primaryKey_riId = ch.getHallarrivllist_id("riId");
		repertoryin.setRiId(primaryKey_riId);
		jd.set("riId", primaryKey_riId);
		Date date = new Date();
		repertoryin.setRiTimee(date);
		HashMap<String, String> map = new HashMap<>();
		List<String> slist = new ArrayList<>();
		String orderNumber = repertoryin.getOrderNumber();
		int number = 0;
		if (jd.exists("re")) {
			String str = jd.get("re");
			slist = JSON.parseArray(str, String.class);
			if (!slist.contains(orderNumber)) {
				number = rs.insertRepertoryin(repertoryin);
			}
		} else {
			number = rs.insertRepertoryin(repertoryin);
		}
		if (number > 0) {
			slist.add(orderNumber);
			jd.set("re", JSON.toJSONString(slist));
			map.put("msg", "ok");
			map.put("primaryKey_riId", primaryKey_riId);
		} else {
			map.put("msg", "fail");
		}

		return map;

	}

	@RequestMapping("/insertRepertory")
	@ResponseBody
	public HashMap<String, String> insertRepertory(Repertory repertory) {
		Jedis jd = jp.getResource();
		String primaryKey_rid = ch.getHallarrivllist_id("rid");
		repertory.setRid(primaryKey_rid);
		jd.set("rid", primaryKey_rid);
		Date date = new Date();
		repertory.setrTimee(date);
		int number = rService.insertRepertory(repertory);
		HashMap<String, String> map = new HashMap<>();
		if (number > 0) {
			map.put("msg", "ok");
		} else {
			map.put("msg", "fail");
		}
		return map;
	}

	@RequestMapping("/selectPageRepertoryout")
	public String selectAll(PageBean<Repertory> page, Repertory re, ModelMap map) {
		page = rService.selectPage(re, page);
		map.put("pageBean", page);
		return "insertRepertoryout";
	}

	@RequestMapping("/insertRepertoryout")
	@ResponseBody
	public HashMap<String, String> insertRepertoryout(Repertoryout repertoryout) {
		Jedis jd = jp.getResource();
		String primaryKey_roId = ch.getHallarrivllist_id("roId");
		repertoryout.setRoId(primaryKey_roId);
		jd.set("roId", primaryKey_roId);
		Date date = new Date();
		repertoryout.setRoTime(date);
		HashMap<String, String> map = new HashMap<>();
		List<String> orderNumberList = new ArrayList<>();
		String orderNumber = repertoryout.getOrderNumber();
		int number = 0;
		if (jd.exists("out")) {
			String str = jd.get("out");
			orderNumberList = JSON.parseArray(str, String.class);
			if (!orderNumberList.contains(orderNumber)) {
				number = roService.insertRepertoryout(repertoryout);
			}
		} else {
			number = roService.insertRepertoryout(repertoryout);
		}

		if (number > 0) {
			orderNumberList.add(orderNumber);
			jd.set("out", JSON.toJSONString(orderNumberList));
			map.put("msg", "ok");
		} else {
			map.put("msg", "fail");
		}
		return map;
	}
}

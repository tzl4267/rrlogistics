package com.tsinghuait.logistics.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Truck;
import com.tsinghuait.logistics.service.AgencyService;
import com.tsinghuait.logistics.service.TruckService;


@Controller
@RequestMapping("/abc")
public class TruckController {
	@Resource
	private TruckService ts;
	@Resource
	private AgencyService as;
	
	//查询显示车辆信息
	@RequestMapping("/queryTruck")
	public String queryTruck(ModelMap map,Truck truck){
		List<Truck> tl = ts.selectTruckAll(truck);
		List<Agency> al = as.selectAgency();
		map.put("tl", tl);
		map.put("al", al);
		return "Truck";
	}
	//删除车辆
	@RequestMapping("/deleteTruck")
	public String deleteTruck(String vehiclecode){
		ts.deleteTruck(vehiclecode);
		return "redirect:queryTruck";
	}
	//ajax按id查询车辆
	@ResponseBody
	@RequestMapping("/updateSelectTruck")
	public Truck updateSelectTruck(String vehiclecode,ModelMap map){
		Truck truck = ts.updateSelectTruck(vehiclecode);
	//	List<Agency> al = as.selectAgency();
		map.put("truck", truck);
		//map.put("al", al);
		return truck;
	}
	//修改车辆
	@RequestMapping("/updateTruck")
	public String updateTruck(Truck truck){
		ts.updateTruck(truck);
		return "redirect:queryTruck";
	}
	//添加车辆
	@RequestMapping("/insertTruck")
	public String insertTruck(Truck truck){
		ts.insertTruck(truck);
		return "redirect:queryTruck";
	}
}

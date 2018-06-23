package com.tsinghuait.logistics.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Driver;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.pojo.Truck;
import com.tsinghuait.logistics.service.LoadlistService;

@Controller
@RequestMapping("/L")
public class LoadlistController {

	
	@Resource
	LoadlistService ls;
	
	//查询所有信息
	@RequestMapping("/Loadlist")
	public String fn(ModelMap map){
		//装车管理
		List<Loadlist> loa= ls.selectlo();
		//司机编号
		 List<Driver> dr = ls.selectdr();
		 //车辆代号
		 List<Truck> tc = ls.selecttu();
		 //网络编点
		 List<Orderlist> oList=ls.selectol();
		 //监管员
		 List<Staff> st = ls.selectst();
		 //本营业厅编号
		 List<Agency> ag = ls.selectag();
		map.put("Driver", dr);
		map.put("Loadlist", loa);
		map.put("Truck", tc);
		map.put("Orderlist", oList);
		map.put("Staff", st);
		map.put("Agency", ag);
		return "LoadthecarLoadlist";
		
	}
	//生成装车单
	@RequestMapping("/update")
	public String fn(ModelMap map,Loadlist loadlist){
		loadlist.setCheckstate("1");
		ls.update(loadlist);
		return "redirect:Loadlist1";
		
	}
	//自动生成装车单号
	@RequestMapping("/Loadlist1")
	public String fn2(ModelMap map,Loadlist loadlist){
		String a = getOrderIdByTime();
		loadlist.setCheckstate("0");
		loadlist.setTransNumber(a);
		ls.insertlo(loadlist);
		return "redirect:Loadlist";
		
	}
	 public static String getOrderIdByTime() {
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	        String newDate=sdf.format(new Date());
	        String result="";
	        Random random=new Random();
	        for(int i=0;i<3;i++){
	            result+=random.nextInt(10);
	        }
	        return newDate+result;
	    }
	
}

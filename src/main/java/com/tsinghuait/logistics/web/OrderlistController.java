package com.tsinghuait.logistics.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.service.OrderlistService;

@Controller
@RequestMapping("/O")
public class OrderlistController {

	@Resource
	private OrderlistService os;
	
	//根据id查询信息
	@RequestMapping("/Orderlist")
	public String fn(ModelMap map,String orderNumber) {
		Orderlist odl = os.selector(orderNumber);
		map.put("odl", odl);
		return "CollectionOrderlist" ;
	}
	//进入页面
	@RequestMapping("/Orderlist1")
	public String fn() {
		return "CollectionOrderlist" ;
	}
	//修改收件人姓名
	@RequestMapping("/Orderlist2")
	public String fn3(Orderlist orderlist) {
		
		os.updateor(orderlist);
		return "redirect:Orderlist1" ;
	}
	//修改状态
	@RequestMapping("/Orderlist3")
	public String fn4(Orderlist orderlist) {
		orderlist.setCheckstate("0");
		os.updateod(orderlist);
		return "redirect:Orderlist1" ;
	}
}

package com.tsinghuait.logistics.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsinghuait.logistics.pojo.Orderlist;
import com.tsinghuait.logistics.service.OrderlistService;



	
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;



import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Area;
import com.tsinghuait.logistics.pojo.City;
import com.tsinghuait.logistics.pojo.Moneyinlist;
import com.tsinghuait.logistics.pojo.Province;
import com.tsinghuait.logistics.pojo.Staff;
import com.tsinghuait.logistics.service.AgencyService;
import com.tsinghuait.logistics.service.AreaService;
import com.tsinghuait.logistics.service.CityService;
import com.tsinghuait.logistics.service.MoneyinlistService;
import com.tsinghuait.logistics.service.OrderlistService;
import com.tsinghuait.logistics.service.ProvinceService;
import com.tsinghuait.logistics.service.StaffService;

@Controller
@RequestMapping("/abc")
public class OrderlistController {
	@Resource
	private OrderlistService os;
	@Resource
	//营业网点
	private AgencyService as;
	@Resource
	//省份
	private ProvinceService ps;
	//市
	@Resource
	private CityService cs;
	//区
	@Resource
	private AreaService ass;
	//员工
	@Resource
	private StaffService ss;
	//收款明细表
	@Resource
	private MoneyinlistService ms;
	//查询空白订单  以及一些需要用到的属性   以下拉框的形式显示
	@RequestMapping("/queryOrderlist")
	public String queryOrderlist(ModelMap map){
		//查询状态=0的订单
		List<Orderlist> ol = os.selectOrderlists();
		//查询网点
		List<Agency> al = as.selectAgency();
		//查询省
		List<Province> pl = ps.selectProvinces();
		//查询市
		List<City> cl = cs.selectCity();
		//查询区
		List<Area> asl = ass.selectAreas();
		//查询员工
		List<Staff> sl = ss.selectStaffs();
		map.put("asl", asl);
		map.put("sl", sl);
		map.put("cl", cl);
		map.put("pl", pl);
		map.put("al", al);
		map.put("ol",ol);
		return "Orderlist";
	}
	//按订单id查询信息 
	@RequestMapping("/updateSelectOrderlist")
	public String updateSelectOrderlist(ModelMap map,String orderNumber){
		//根据id查询，返回一个对象
		Orderlist orderlist = os.updateSelectOrderlist(orderNumber);
		map.put("orderlist", orderlist);
		//查询网点
		List<Agency> al = as.selectAgency();
		//查询省
		List<Province> pl = ps.selectProvinces();
		//查询市
		List<City> cl = cs.selectCity();
		//查询区
		List<Area> asl = ass.selectAreas();
		//查询揽件员
		List<Staff> sl = ss.selectStaffs();
		map.put("asl", asl);
		map.put("sl", sl);
		map.put("cl", cl);
		map.put("pl", pl);
		map.put("al", al);
		return "Orderlist";
	}
	//通过修改把订单的信息补全
	@RequestMapping("/updateOrderlist")
	public String updateOrderlist(Orderlist orderlist,Moneyinlist moneyinlist){
			//补全订单信息 其实就是一个修改
			os.updateOrderlist(orderlist);
			//获取订单号，向收款明细表中添加收款记录
			String OrderNumbers=orderlist.getOrderNumber();
			System.out.println(OrderNumbers);
			moneyinlist.setMid("5");
			moneyinlist.setOrderNumber(OrderNumbers);
			moneyinlist.setMoneyTota(123.1);
			ms.insertMoneyinlists(moneyinlist);
			
		return "redirect:queryOrderlist";
	}
	//添加空白订单
	@RequestMapping("/insertOrderlist")
	public String insertOrderlist(Orderlist orderlist){
		//a=订单编号 自动生成
		String a  = getOrderIdByTime();
		orderlist.setOrderNumber(a);
		orderlist.setStus("0");
		os.insertOrderlist(orderlist);
		return "redirect:queryOrderlist";
	}
	//随机生成订单号 时间加随机三位数
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

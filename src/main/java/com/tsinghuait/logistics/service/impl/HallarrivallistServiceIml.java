package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.mapper.HallarrivalistDao;
import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Loadlistbarcode;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.service.HallarrivallistService;

@Service
@Transactional
public class HallarrivallistServiceIml implements HallarrivallistService {
	@Resource
	private HallarrivalistDao  hd;
	
	@Resource
	private HallarrivalBarcodeDao hb;
	
	@Override
	public void insert_Hallarrivalist(Hallarrivallist ha) {//添加中转接收单
		hd.insert_Hallarrivalist(ha);
		
	}

	@Override
	public List<Loadlistbarcode> getLoadlists(String transNumber) {//查询装车清单
		// TODO Auto-generated method stub
		return hd.getLoadlists(transNumber);
	}

	@Override
	public List<Transshipmentlist_barcode> getTransshipmenglists(String tranId) {//查询中转清单
		// TODO Auto-generated method stub
		return hd.getTransshipmenglists(tranId);
	}

	@Override
	public void zhongzhuanjieshou(Hallarrivallist hal, List<HallarrivalBarcode> list){//此方法的实现了事物回滚  //批量添加
		hd.insert_Hallarrivalist(hal);
		for (HallarrivalBarcode hallarrivalBarcode : list) {
			
			hb.insert_hallarrivlBarcode(hallarrivalBarcode);
		}
		
	}

	@Override
	public Hallarrivallist getHallarrivallist(String hid) {//根据编号查询中转中心接收单
		// TODO Auto-generated method stub
		return hd.getHallarrivallist(hid) ;
	}

	@Override
	public List<Hallarrivallist> gethallarriva(Hallarrivallist ha) {//根据机构边号和时间查询中转接收单
		// TODO Auto-generated method stub
		return hd.gethallarrliva(ha);
	}

	@Override
	public Agency getAgency(String agencyId) {//根据网点编号查询网点对象
		// TODO Auto-generated method stub
		return hd.getAgency(agencyId);
	}

	@Override
	public Loadlist getLoadlistByID(String transNumber) {//根据编号查询装车单
		// TODO Auto-generated method stub
		return hd.getLoadlistByID(transNumber);
	}

	@Override
	public Transshipmentlist getTransshipmentlistById(String tranId) {//根据编号查找转运表
		// TODO Auto-generated method stub
		return hd.getTransshipmentlistById(tranId);
	}
	
}

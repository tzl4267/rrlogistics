package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.mapper.HallarrivalistDao;
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
	public void insert_Hallarrivalist(Hallarrivallist ha) {
		hd.insert_Hallarrivalist(ha);
		
	}

	@Override
	public List<Loadlistbarcode> getLoadlists(String transNumber) {
		// TODO Auto-generated method stub
		return hd.getLoadlists(transNumber);
	}

	@Override
	public List<Transshipmentlist_barcode> getTransshipmenglists(String tranId) {
		// TODO Auto-generated method stub
		return hd.getTransshipmenglists(tranId);
	}

	@Override
	public void zhongzhuanjieshou(Hallarrivallist hal, List<HallarrivalBarcode> list){//次方法的实现了事物回滚
		hd.insert_Hallarrivalist(hal);
		for (HallarrivalBarcode hallarrivalBarcode : list) {
			
			hb.insert_hallarrivlBarcode(hallarrivalBarcode);
		}
		
	}

	@Override
	public Hallarrivallist getHallarrivallist(String hid) {
		// TODO Auto-generated method stub
		return hd.getHallarrivallist(hid) ;
	}
	
}

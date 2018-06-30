package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.service.HallarrivaIBarcodeService_w;

@Service
@Transactional
public class HallarrivaIBarcodeServiceIml_w implements HallarrivaIBarcodeService_w {
	@Resource
    private HallarrivalBarcodeDao hd;
	
    @Override
	public void insert_hallarrivlBarcode(HallarrivalBarcode hss) {
		hd.insert_hallarrivlBarcode(hss);
		
	}
    
    @Override
	public List<HallarrivalBarcode> selectallByHid(String hid) {
		// TODO Auto-generated method stub
		return hd.selectallByHid(hid);
	}

}

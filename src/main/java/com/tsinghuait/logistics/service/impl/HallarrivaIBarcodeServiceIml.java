package com.tsinghuait.logistics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.service.HallarrivaIBarcodeService;

@Service
public class HallarrivaIBarcodeServiceIml implements HallarrivaIBarcodeService {
	@Resource
    private HallarrivalBarcodeDao hd;
	
    @Override
	public void insert_hallarrivlBarcode(HallarrivalBarcode hss) {
		hd.insert_hallarrivlBarcode(hss);
		
	}

}

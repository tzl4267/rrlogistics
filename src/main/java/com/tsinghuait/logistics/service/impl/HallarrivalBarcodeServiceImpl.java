package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.service.HallarrivalBarcodeService;

@Service
@Transactional
public class HallarrivalBarcodeServiceImpl implements HallarrivalBarcodeService {
	@Resource
	private HallarrivalBarcodeDao hd;

	@Override
	public List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode) {
		return hd.selectAll(hallarrivalBarcode);
	}

}

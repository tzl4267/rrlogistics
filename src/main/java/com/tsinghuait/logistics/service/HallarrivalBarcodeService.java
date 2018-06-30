package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.PageBean;

public interface HallarrivalBarcodeService {
	List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode);
	

	PageBean<HallarrivalBarcode> selectPage(HallarrivalBarcode hallarrivalBarcode, PageBean<HallarrivalBarcode> page);
}

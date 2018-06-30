package com.tsinghuait.logistics.service;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.PageBean;

public interface HallarrivalBarcodeService {
	PageBean<HallarrivalBarcode> selectPage(HallarrivalBarcode hallarrivalBarcode, PageBean<HallarrivalBarcode> page);
}

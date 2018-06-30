package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;

public interface HallarrivaIBarcodeService_w {
	void insert_hallarrivlBarcode(HallarrivalBarcode hss);

	List<HallarrivalBarcode> selectallByHid(String hid);// 根据hid查询中转中心接收清单

}

package com.tsinghuait.logistics.mapper;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;

import java.util.List;

/*根据中专接受清单hid查询出hid下的所有快递单号*/
public interface HallarrivalBarcodeDao {
	
	 void insert_hallarrivlBarcode(HallarrivalBarcode  hss);
	/*根据中专接受清单hid查询出hid下的所有快递单号查询方法*/
	List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode);
}

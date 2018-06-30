package com.tsinghuait.logistics.mapper;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;

import java.util.List;
import java.util.Map;

/*根据中专接受清单hid查询出hid下的所有快递单号*/
public interface HallarrivalBarcodeDao {
	
	 void insert_hallarrivlBarcode(HallarrivalBarcode  hss);
	/*根据中专接受清单hid查询出hid下的所有快递单号查询方法*/
	 List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode);
	 List<HallarrivalBarcode> selectallByHid(String hid);//根据hid查询中转中心接收清单


	/* 根据中专接受清单hid查询出hid下的所有快递单号查询方法 */
	List<HallarrivalBarcode> selectAll(Map<String, Object> map);

	int getCountHallarrivalBarcode(HallarrivalBarcode hb);

}

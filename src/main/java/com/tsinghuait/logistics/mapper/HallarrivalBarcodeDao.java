package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
/*根据中专接受清单hid查询出hid下的所有快递单号*/
public interface HallarrivalBarcodeDao {
	/*根据中专接受清单hid查询出hid下的所有快递单号查询方法*/
	List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode);
}

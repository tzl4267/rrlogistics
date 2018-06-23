package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Loadlistbarcode;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;

public interface HallarrivallistService {
	void insert_Hallarrivalist(Hallarrivallist ha);//添加中转接收单
	
	List<Loadlistbarcode> getLoadlists(String transNumber);//查询装车清单
	List<Transshipmentlist_barcode> getTransshipmenglists(String tranId);//查询中转清单
	void zhongzhuanjieshou(Hallarrivallist hal,List<HallarrivalBarcode>  list);//批量添加
	Hallarrivallist getHallarrivallist(String hid);
}

package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;
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
	Hallarrivallist getHallarrivallist(String hid);//根据编号查询中转中心接收单
	List<Hallarrivallist> gethallarriva(Hallarrivallist ha);//根据机构边号和时间查询中转接收单
	Agency getAgency(String agencyId);//根据网点编号查询网点对象
	Loadlist getLoadlistByID(String  transNumber);//根据编号查询装车单
	Transshipmentlist getTransshipmentlistById(String tranId);//根据编号查找转运表
	
}

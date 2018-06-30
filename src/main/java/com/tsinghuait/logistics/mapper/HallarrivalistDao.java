package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Agency;
import com.tsinghuait.logistics.pojo.Hallarrivallist;
import com.tsinghuait.logistics.pojo.Loadlist;
import com.tsinghuait.logistics.pojo.Loadlistbarcode;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;

public interface HallarrivalistDao {
	Loadlist getLoadlistByID(String  transNumber);//根据编号查询装车单
	Transshipmentlist getTransshipmentlistById(String tranId);//根据编号查找转运表
	List<Agency> getAgencys_zhongzhuan();//查找所有的中转中心
	List<Agency> getAgencys_yinyeting();//查找所有的营业厅
	void insert_Hallarrivalist(Hallarrivallist ha);//添加中转接收单
	
	List<Loadlistbarcode> getLoadlists(String transNumber);//查询装车清单
	List<Transshipmentlist_barcode> getTransshipmenglists(String tranId);//查询中转清单
    
	Hallarrivallist getHallarrivallist(String hid);//根据中转中心接收编号查询对象
	List<Hallarrivallist> gethallarrliva(Hallarrivallist ha);//根据中转中心的时间和中转编号查询中转中心单
	Agency getAgency(String agencyId);//根据网点编号查询网点对象




}

package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Repertoryin;

/*添加入库*/
public interface RepertoryinDao {
	/* 添加入库方法 */
	int insertRepertoryin(Repertoryin repertoryin);

	List<Repertoryin> selectRepertoryin();
}

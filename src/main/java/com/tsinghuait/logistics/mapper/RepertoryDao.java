package com.tsinghuait.logistics.mapper;

import java.util.List;
import java.util.Map;

import com.tsinghuait.logistics.pojo.Repertory;

/*仓库*/
public interface RepertoryDao {
	/* 向仓库添加方法 */
	int insertRepertory(Repertory repertory);

	List<Repertory> selectRepertory(Map<String, Object> pagMap);

	int getCountRepertory(Repertory repertory);

}

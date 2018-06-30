package com.tsinghuait.logistics.mapper;

import java.util.List;

import com.tsinghuait.logistics.pojo.Repertoryout;

public interface RepertoryoutDao {
	int insertRepertoryout(Repertoryout repertoryout);

	List<Repertoryout> selectAllRepertoryout();
}

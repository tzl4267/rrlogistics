package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Repertoryout;

public interface RepertoryoutService {
	int insertRepertoryout(Repertoryout repertoryout);

	List<Repertoryout> selectAllRepertoryout();
}

package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.PageBean;
import com.tsinghuait.logistics.pojo.Repertory;

public interface RepertoryService {
	int insertRepertory(Repertory repertory);

	PageBean<Repertory> selectPage(Repertory repertory, PageBean<Repertory> page);
}

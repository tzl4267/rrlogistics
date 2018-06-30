package com.tsinghuait.logistics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.TransshipmentlistDao;
import com.tsinghuait.logistics.pojo.Transshipmentlist;
import com.tsinghuait.logistics.service.TransshipmentlistService;

@Service
@Transactional
public class TransshipmentlistServiceImpl implements TransshipmentlistService {
	@Resource
	private TransshipmentlistDao td;

	@Override
	public int insertTransshipmentlist(Transshipmentlist tp) {
		return td.insertTransshipmentlist(tp);
	}
}

package com.tsinghuait.logistics.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.RepertoryinDao;
import com.tsinghuait.logistics.pojo.Repertoryin;
import com.tsinghuait.logistics.service.RepertoryinService;

@Service
@Transactional
public class RepertoryinServiceImpl implements RepertoryinService {
	@Resource
	private RepertoryinDao rd;

	@Override
	public void insertRepertoryin(Repertoryin repertoryin) {
		rd.insertRepertoryin(repertoryin);
	}

}

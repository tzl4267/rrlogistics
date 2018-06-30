package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.RepertoryoutDao;
import com.tsinghuait.logistics.pojo.Repertoryout;
import com.tsinghuait.logistics.service.RepertoryoutService;

@Service
@Transactional
public class RepertoryoutServiceImpl implements RepertoryoutService {
	@Resource
	private RepertoryoutDao rd;

	@Override
	public int insertRepertoryout(Repertoryout repertoryout) {
		return rd.insertRepertoryout(repertoryout);
	}

	@Override
	public List<Repertoryout> selectAllRepertoryout() {

		return rd.selectAllRepertoryout();
	}

}

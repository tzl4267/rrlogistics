package com.tsinghuait.logistics.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.RepertoryDao;
import com.tsinghuait.logistics.pojo.PageBean;
import com.tsinghuait.logistics.pojo.Repertory;
import com.tsinghuait.logistics.service.RepertoryService;

@Service
@Transactional
public class RepertoryServiceImpl implements RepertoryService {
	@Resource
	private RepertoryDao rd;

	@Override
	public int insertRepertory(Repertory repertory) {
		return rd.insertRepertory(repertory);
	}

	@Override
	public PageBean<Repertory> selectPage(Repertory repertory, PageBean<Repertory> page) {
		Map<String, Object> map = new HashMap<>();
		repertory.setCheckstate("0");
		map.put("page", page);
		map.put("r", repertory);
		System.out.println(repertory.getCheckstate());
		map.put("p", (page.getNowPage() - 1) * page.getPageNumber());
		page.setAllCount(rd.getCountRepertory(repertory));
		List<Repertory> a = rd.selectRepertory(map);
		page.setLl(a);
		System.out.println(a);
		return page;
	}

}

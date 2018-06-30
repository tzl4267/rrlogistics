package com.tsinghuait.logistics.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.HallarrivalBarcodeDao;
import com.tsinghuait.logistics.pojo.HallarrivalBarcode;
import com.tsinghuait.logistics.pojo.PageBean;
import com.tsinghuait.logistics.service.HallarrivalBarcodeService;

@Service
@Transactional
public class HallarrivalBarcodeServiceImpl implements HallarrivalBarcodeService {
	@Resource
	private HallarrivalBarcodeDao hd;

	@Override
	public PageBean<HallarrivalBarcode> selectPage(HallarrivalBarcode hallarrivalBarcode,
			PageBean<HallarrivalBarcode> page) {
		Map<String, Object> map = new HashMap<>();
		hallarrivalBarcode.sethType("0");
		map.put("page", page);
		map.put("h", hallarrivalBarcode);
		map.put("p", (page.getNowPage() - 1) * page.getPageNumber());
		List<HallarrivalBarcode> a = hd.selectAll(map);
		page.setLl(a);
		page.setAllCount(hd.getCountHallarrivalBarcode(hallarrivalBarcode));
		return page;
	}

	@Override
	public List<HallarrivalBarcode> selectAll(HallarrivalBarcode hallarrivalBarcode) {
		// TODO Auto-generated method stub
		return null;
	}
 
}

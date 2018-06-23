package com.tsinghuait.logistics.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsinghuait.logistics.mapper.Transshipmentlist_barcodeDao;
import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;
import com.tsinghuait.logistics.service.Transshipmentlist_barcodeService;

@Service
@Transactional
public class Transshipmentlist_barcodeServiceImpl implements Transshipmentlist_barcodeService {
	@Resource
	private Transshipmentlist_barcodeDao tbd;

	@Override
	public void insertTransshipmentlist_barcode(Transshipmentlist_barcode tb) {
		tbd.insertTransshipmentlist_barcode(tb);
	}

	@Override
	public List<Transshipmentlist_barcode> selectTb() {
		// TODO Auto-generated method stub
		return null;
	}

}

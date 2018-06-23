package com.tsinghuait.logistics.service;

import java.util.List;

import com.tsinghuait.logistics.pojo.Transshipmentlist_barcode;

public interface Transshipmentlist_barcodeService {
	void insertTransshipmentlist_barcode(Transshipmentlist_barcode tb);

	List<Transshipmentlist_barcode> selectTb();
}

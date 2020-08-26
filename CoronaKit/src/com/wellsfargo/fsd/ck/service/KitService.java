package com.wellsfargo.fsd.ck.service;

import java.util.List;

import com.wellsfargo.fsd.ck.entity.KitDetail;
import com.wellsfargo.fsd.ck.exception.CkException;

public interface KitService {
	
	KitDetail validateAndAdd(KitDetail kd) throws CkException;     
	KitDetail validateAndSave(KitDetail kd) throws CkException;     
	boolean deleteItem(int id) throws CkException;     
	KitDetail getItemById(int id) throws CkException;     
	List<KitDetail> getAllItems() throws CkException;



}

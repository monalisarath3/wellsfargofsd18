package com.wellsfargo.fsd.ck.dao;

import java.util.List;

import com.wellsfargo.fsd.ck.entity.KitDetail;
import com.wellsfargo.fsd.ck.entity.ProductMaster;
import com.wellsfargo.fsd.ck.exception.CkException;

public interface KitDao {
	

	KitDetail add(KitDetail pm) throws CkException;
	KitDetail save(KitDetail pm) throws CkException;
	boolean deleteById(Integer id) throws CkException;  
	KitDetail getById(Integer id) throws CkException;
	List<KitDetail> getAll() throws CkException;



}

package com.wellsfargo.fsd.ck.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ck.dao.KitDao;
import com.wellsfargo.fsd.ck.dao.KitDaoImpl;
import com.wellsfargo.fsd.ck.entity.KitDetail;
import com.wellsfargo.fsd.ck.exception.CkException;

public class KitServiceImpl implements KitService{
	KitDao kdDao;
	
	private boolean isIdValid(Integer id) {
		return id>0;	
	}
	
	private boolean isPriceValid(double d) {
		return d >= 0;
	}
	
	private boolean isQuantityValid(Integer quantity) {
		return quantity != null && (quantity > 0 || quantity <= 5);
		
	}
	
	private boolean isValidItem(KitDetail kd) throws CkException {
		List<String> errMsg = new ArrayList<>();

		boolean isValid = true;

		if (!isIdValid(kd.getCoronaKitId())) {
			isValid = false;
			errMsg.add("ID can not be null or negative or zero");
		}

		if (!isPriceValid(kd.getAmount())) {
			isValid = false;
			errMsg.add("Price can not be blank");
		}

		if (!isQuantityValid(kd.getQuantity())) {
			isValid = false;
			errMsg.add("Quantity can not exceed 5");
		}

		
		if (!isValid) {
			throw new CkException(errMsg.toString());
		}

		return isValid;
	}

	public  KitServiceImpl() {
		kdDao=new KitDaoImpl();
	}
	
	

	@Override
	public KitDetail validateAndAdd(KitDetail kd) throws CkException {

		if(kd!=null) {            
			if(isValidItem(kd)) {                
				kdDao.add(kd);             
				}         
			}         
		return kd;
	
	}

	@Override
	public KitDetail validateAndSave(KitDetail kd) throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteItem(int id) throws CkException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KitDetail getItemById(int id) throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KitDetail> getAllItems() throws CkException {
		// TODO Auto-generated method stub
		return null;
	}

}

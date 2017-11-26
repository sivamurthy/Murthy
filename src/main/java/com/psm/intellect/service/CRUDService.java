package com.psm.intellect.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.psm.intellect.model.User;

public interface CRUDService<E> {

	E save(E entity);

	E getById(Serializable id);
	
	E getByPinCode(Serializable pinCode);

	List<E> getAll();
	
	void delete(Serializable id);
	
}

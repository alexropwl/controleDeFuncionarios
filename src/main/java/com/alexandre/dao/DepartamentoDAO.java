package com.alexandre.dao;

import java.util.List;

import com.alexandre.entity.DepartamentoEntity;

public interface DepartamentoDAO {

	void save( DepartamentoEntity departamento);
	
	void update(DepartamentoEntity departamento);
	
	void delete(Long id);
	
	DepartamentoEntity findById(Long id);
	
	List<DepartamentoEntity> findAll();
	
	
	
}

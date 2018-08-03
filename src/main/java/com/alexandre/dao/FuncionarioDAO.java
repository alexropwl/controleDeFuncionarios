package com.alexandre.dao;

import java.util.List;

import com.alexandre.entity.FuncionarioEntity;

public interface FuncionarioDAO {

	
	void save(FuncionarioEntity funcionario);
	 
	void update(FuncionarioEntity funcionario);
	
	void delete(Long id);
	
	FuncionarioEntity findById(Long id);
	
	List<FuncionarioEntity> findAll();
   
	 
	
	
	
	
	
}

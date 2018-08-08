package com.alexandre.dao;

import java.time.LocalDate;
import java.util.List;

import com.alexandre.entity.FuncionarioEntity;

public interface FuncionarioDAO {

	
	void save(FuncionarioEntity funcionario);
	 
	void update(FuncionarioEntity funcionario);
	
	void delete(Long id);
	
	FuncionarioEntity findById(Long id);
	
	List<FuncionarioEntity> findAll();
   
	 
	List<FuncionarioEntity>findByNome(String nome);

	List<FuncionarioEntity> findByCargo(Long id);

	List<FuncionarioEntity> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<FuncionarioEntity> findByDataEntrada(LocalDate entrada);

	List<FuncionarioEntity> findByDataSaida(LocalDate saida);
	
	
	
	
}

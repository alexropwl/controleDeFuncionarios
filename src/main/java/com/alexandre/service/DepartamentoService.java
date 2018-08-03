package com.alexandre.service;

import java.util.List;

import com.alexandre.entity.DepartamentoEntity;

public interface DepartamentoService {

	
void salvar(DepartamentoEntity departamento);

void editar(DepartamentoEntity departamento);

void excluir(Long id);

DepartamentoEntity buscaPorId(Long id);

List<DepartamentoEntity>buscaTodos();


	
	
	
}

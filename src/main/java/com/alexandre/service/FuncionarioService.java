package com.alexandre.service;

import java.util.List;

import com.alexandre.entity.FuncionarioEntity;

public interface FuncionarioService {

	
void salvar(FuncionarioEntity funcionario);	
	
void editar(FuncionarioEntity funcionario);

void deletar(Long id);

FuncionarioEntity buscaPorId(Long id);

List<FuncionarioEntity> buscaTodos();


	
}

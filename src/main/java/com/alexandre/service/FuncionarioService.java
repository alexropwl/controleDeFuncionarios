package com.alexandre.service;

import java.time.LocalDate;
import java.util.List;

import com.alexandre.entity.FuncionarioEntity;

public interface FuncionarioService {

	
void salvar(FuncionarioEntity funcionario);	
	
void editar(FuncionarioEntity funcionario);

void deletar(Long id);

FuncionarioEntity buscaPorId(Long id);

List<FuncionarioEntity> buscaTodos();

List<FuncionarioEntity>buscaPorNome(String nome);

List<FuncionarioEntity>buscarPorCargo(Long id);

List<FuncionarioEntity>buscarPorData(LocalDate entrada, LocalDate saida);

	
}

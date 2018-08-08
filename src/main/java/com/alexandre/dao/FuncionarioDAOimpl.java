package com.alexandre.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alexandre.entity.FuncionarioEntity;

@Repository
public class FuncionarioDAOimpl extends AbstractDAO<FuncionarioEntity, Long> implements FuncionarioDAO {

	@Override
	public List<FuncionarioEntity> findByNome(String nome) {

		return createQuery("select f from FuncionarioEntity f where f.nome like concat('%',?1,'%') ", nome);

	}

	@Override
	public List<FuncionarioEntity> findByCargo(Long id) {

		return createQuery("select f from FuncionarioEntity f where f.cargo.id =?1 ", id);

	}

	@Override
	public List<FuncionarioEntity> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from FuncionarioEntity f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ").append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<FuncionarioEntity> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from FuncionarioEntity f ").append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc").toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<FuncionarioEntity> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from FuncionarioEntity f ").append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc").toString();
		return createQuery(jpql, saida);
	}

}

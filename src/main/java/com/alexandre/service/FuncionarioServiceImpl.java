package com.alexandre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexandre.dao.FuncionarioDAO;
import com.alexandre.entity.FuncionarioEntity;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioDAO dao;

	@Override
	public void salvar(FuncionarioEntity funcionario) {

		dao.save(funcionario);

	}

	@Override
	public void editar(FuncionarioEntity funcionario) {

		dao.update(funcionario);

	}

	@Override
	public void deletar(Long id) {

		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public FuncionarioEntity buscaPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FuncionarioEntity> buscaTodos() {

		return dao.findAll();
	}

}

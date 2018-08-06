package com.alexandre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexandre.dao.DepartamentoDAO;
import com.alexandre.entity.DepartamentoEntity;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoDAO dao;

	@Override
	public void salvar(DepartamentoEntity departamento) {

		dao.save(departamento);

	}

	@Override
	public void editar(DepartamentoEntity departamento) {

		dao.update(departamento);

	}

	@Override
	public void excluir(Long id) {

		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public DepartamentoEntity buscaPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartamentoEntity> buscaTodos() {

		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if(buscaPorId(id).getCargos().isEmpty()) {
			
			return false;
			
		}
		return true;
	}

}

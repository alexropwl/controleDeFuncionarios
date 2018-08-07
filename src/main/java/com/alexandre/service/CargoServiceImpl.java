package com.alexandre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexandre.dao.CargoDAO;
import com.alexandre.entity.CargoEntity;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDAO dao;

	@Override
	public void salvar(CargoEntity cargo) {

		dao.save(cargo);

	}

	@Override
	public void editar(CargoEntity cargo) {

		dao.update(cargo);

	}

	@Override
	public void excluir(Long id) {

		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public CargoEntity buscarPorId(Long id) {

		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CargoEntity> buscarTodos() {

		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {

		if (buscarPorId(id).getFuncionario().isEmpty()) {

			return false;

		}
		return true;
	}

}

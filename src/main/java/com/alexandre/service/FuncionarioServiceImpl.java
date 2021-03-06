package com.alexandre.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	@Override
	@Transactional(readOnly = true)
	public List<FuncionarioEntity> buscaPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	@Transactional(readOnly=true)
	public List<FuncionarioEntity> buscarPorCargo(Long id) {
		
		return  dao.findByCargo(id);
	}

	@Override
	@Transactional(readOnly = true)
    public List<FuncionarioEntity> buscarPorData(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return dao.findByDataEntrada(entrada);
        } else if (saida != null) {        	
	        return dao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

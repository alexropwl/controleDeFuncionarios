package com.alexandre.dao;

import java.util.List;

import com.alexandre.entity.CargoEntity;

public interface CargoDAO {

void save(CargoEntity cargo);

void update(CargoEntity cargo);


void delete(Long id);


CargoEntity findById(Long id);	
	

List<CargoEntity> findAll();


}

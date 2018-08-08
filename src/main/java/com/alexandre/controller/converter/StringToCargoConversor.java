package com.alexandre.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alexandre.entity.CargoEntity;
import com.alexandre.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, CargoEntity> {

	@Autowired
	private CargoService cargoService;

	@Override
	public CargoEntity convert(String text) {
		if (text.isEmpty()) {

			return null;

		}

		Long id = Long.valueOf(text);

		return cargoService.buscarPorId(id);
	}

}

package com.alexandre.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alexandre.entity.DepartamentoEntity;
import com.alexandre.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, DepartamentoEntity> {

	@Autowired
	private DepartamentoService departamentoService;

	@Override
	public DepartamentoEntity convert(String text) {

		if (text.isEmpty()) {

			return null;

		}

		Long id = Long.valueOf(text);
		return departamentoService.buscaPorId(id);
	}

}

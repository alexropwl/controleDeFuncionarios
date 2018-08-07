package com.alexandre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexandre.entity.CargoEntity;
import com.alexandre.entity.DepartamentoEntity;
import com.alexandre.service.CargoService;
import com.alexandre.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;

	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(CargoEntity cargo) {

		return "/cargo/cadastro";

	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {

		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}

	@PostMapping("/salvar")
	public String salvar(CargoEntity cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);

		attr.addFlashAttribute("success", " Cargo salvo com sucesso");

		return "redirect:/cargos/cadastrar";

	}

	@ModelAttribute("departamentos")
	public List<DepartamentoEntity> listaDeDepartamentos() {

		return departamentoService.buscaTodos();

	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("cargoEntity", cargoService.buscarPorId(id));
		return "cargo/cadastro";

	}

	@PostMapping("/editar")
	public String editar(CargoEntity cargo, RedirectAttributes attr) {

		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "cargo editado com sucesso");

		return "redirect:/cargos/cadastrar";

	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {

		if (cargoService.cargoTemFuncionarios(id)) {
			attr.addFlashAttribute("fail", "Cargo não pode ser excluido pois tem funcionários vinculados.");

		} else {
			cargoService.excluir(id);
			attr.addFlashAttribute("success", "Cargo removido com sucesso.");

		}

		return "redirect:/cargos/listar";

	}

}

package com.alexandre.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexandre.entity.CargoEntity;
import com.alexandre.entity.FuncionarioEntity;
import com.alexandre.entity.UF;
import com.alexandre.service.CargoService;
import com.alexandre.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(FuncionarioEntity funcionario) {

		return "/funcionario/cadastro";

	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {

		model.addAttribute("funcionarios", funcionarioService.buscaTodos());
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(FuncionarioEntity funcionario, RedirectAttributes attr) {

		funcionarioService.salvar(funcionario);

		attr.addFlashAttribute("success", "Funcionário salvo com sucesso");
		return "redirect:/funcionarios/cadastrar";

	}

	@ModelAttribute("cargos")
	public List<CargoEntity> getCargos() {

		return cargoService.buscarTodos();

	}

	@ModelAttribute("ufs")
	public UF[] getUFs() {

		return UF.values();

	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("funcionarioEntity", funcionarioService.buscaPorId(id));

		return "funcionario/cadastro";

	}

	@PostMapping("/editar")
	public String editar(FuncionarioEntity funcionario, RedirectAttributes attr) {

		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso");

		return "redirect:/funcionarios/cadastrar";

	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {

		funcionarioService.deletar(id);
		attr.addFlashAttribute("success", "Funcionario removido com sucesso");

		return "redirect:/funcionarios/listar";

	}

	
	@GetMapping("/buscar/nome")
	public String getNome(@RequestParam("nome") String nome, ModelMap model) {
		
		model.addAttribute("funcionarios", funcionarioService.buscaPorNome(nome));
		
		return "/funcionario/lista";
		
	}
	
	
	
	
	@GetMapping("/buscar/cargo")
	public String getCargo(@RequestParam("id") Long id, ModelMap model) {
		
		model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
		
		return "/funcionario/lista";
		
	}
	
	
	@GetMapping("/buscar/data")
	public String getData(@RequestParam("entrada")@DateTimeFormat(iso=ISO.DATE) LocalDate entrada, @RequestParam("saida") @DateTimeFormat(iso= ISO.DATE) LocalDate saida, ModelMap model) {
		
		model.addAttribute("funcionarios", funcionarioService.buscarPorData(entrada, saida));
		
		return "/funcionario/lista";
		
	}
	
	
	
	
	
	
}

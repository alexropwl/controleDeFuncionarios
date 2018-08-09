package com.alexandre.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class CargoEntity extends AbstractEntity<Long> {

	@Size(min =3,  max=60, message="O nome não pode ter mais de 60 caracteres!")
	@NotBlank(message="Informe um nome!")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "cargo")
	private List<FuncionarioEntity>funcionario;
	
	
	public List<FuncionarioEntity> getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(List<FuncionarioEntity> funcionario) {
		this.funcionario = funcionario;
	}

    @NotNull(message="Selecione um departamento!") 
	@ManyToOne
	@JoinColumn(name ="id_departamento_fk")
	private DepartamentoEntity departamento;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public DepartamentoEntity getDepartamento() {
		return departamento;
	}


	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}

	
	
	
	
	
}

package com.alexandre.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTOS")
public class DepartamentoEntity extends AbstractEntity<Long> {

	
	@OneToMany(mappedBy="departamento")
	public List<CargoEntity> cargos;
	

	@NotBlank(message="Informe um nome")
	@Size(max=60, message="O nome poder ter no máximo 60 caractéres")
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CargoEntity> getCargos() {
		return cargos;
	}

	public void setCargos(List<CargoEntity> cargos) {
		this.cargos = cargos;
	}
	
	
	
}

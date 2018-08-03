package com.alexandre.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class FuncionarioEntity extends AbstractEntity<Long> {


@Column(nullable = false, unique = true)	
private String nome;

@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
private BigDecimal salario;

@Column(nullable = false, name="data_entrada", columnDefinition="DATE")
private LocalDate dataEntrada;

@Column(name="data_saida",nullable = true, columnDefinition = "DATE")
private LocalDate  dataSaida;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name ="endereco_id_fk")
private EnderecoEntity endereco;


@ManyToOne
@JoinColumn(name="cargo_id_fk")
private CargoEntity cargo;


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public BigDecimal getSalario() {
	return salario;
}


public void setSalario(BigDecimal salario) {
	this.salario = salario;
}


public LocalDate getDataEntrada() {
	return dataEntrada;
}


public void setDataEntrada(LocalDate dataEntrada) {
	this.dataEntrada = dataEntrada;
}


public LocalDate getDataSaida() {
	return dataSaida;
}


public void setDataSaida(LocalDate dataSaida) {
	this.dataSaida = dataSaida;
}


public EnderecoEntity getEndereco() {
	return endereco;
}


public void setEndereco(EnderecoEntity endereco) {
	this.endereco = endereco;
}


public CargoEntity getCargo() {
	return cargo;
}


public void setCargo(CargoEntity cargo) {
	this.cargo = cargo;
}























}
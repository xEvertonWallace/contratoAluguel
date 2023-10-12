package com.appcontratoalguel.entities;

public class Fiador {
	
	private String nome;
	private String cpf;
	private double rendaMensal;
	
	public Fiador(String nome, String cpf, double rendaMensal) {

		this.nome = nome;
		this.cpf = cpf;
		this.rendaMensal = rendaMensal;
	}
	
	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public boolean verificaRenda(double aluguel) {
		return rendaMensal >= 3*aluguel;
	}
	
}

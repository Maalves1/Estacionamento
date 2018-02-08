package br.com.impacta.curso.java.estacionamento.testes;

import br.com.impacta.curso.java.estacionamento.dominio.Tarifario;

public class TesteTarifario {
	
	public static void main(String[] args) {
	
		Tarifario.setValorHora(20);
		Tarifario.setValorIncremental(5);
		Tarifario.setIncrementoEmMinutos(15);
		
		Tarifario.mostraDados();
		
	}

}

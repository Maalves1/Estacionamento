package br.com.impacta.curso.java.estacionamento.testes;

import br.com.impacta.curso.java.estacionamento.dominio.Veiculo;

public class TesteVeiculo {
	
	public static void main(String[] args) {

		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("AAA-1111");
		veiculo.setMarca("Fiat");
		veiculo.setModelo("Siena");
		veiculo.setCor("Prata");
		
		veiculo.mostraDados();

	}

}

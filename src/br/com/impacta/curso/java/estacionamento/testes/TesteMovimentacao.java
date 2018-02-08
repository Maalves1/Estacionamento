package br.com.impacta.curso.java.estacionamento.testes;

import java.time.LocalDateTime;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Veiculo;

public class TesteMovimentacao {
	
	public static void main(String[] args) {
		Movimentacao mov1 = new Movimentacao();
		
		mov1.setVeiculo(new Veiculo());
		mov1.getVeiculo().setPlaca("AAA-1111");
		mov1.getVeiculo().setMarca("Fiat");
		mov1.getVeiculo().setModelo("Siena");
		mov1.getVeiculo().setCor("Prata");
		 
		mov1.setDataEntrada(LocalDateTime.now());
		mov1.setDataSaida(LocalDateTime.now());
		mov1.setValor(10.0);
		
		System.out.println("*** DADOS MOVIMENTACAO ***");
		mov1.mostraDados();

		//simulação de um NullPointerException
		Movimentacao mov2 = new Movimentacao();
		//mov2.veiculo.cor = "Branca"; //Ocorre um erro - Referencia nula a veiculo
		
		//Atribuindo uma variavel do tipo veiculo ao veiculo da movimentacao
		Veiculo v1 = new Veiculo();
		v1.setPlaca("BBB-2222");
		mov2.setVeiculo(v1); 

		mov2.getVeiculo().setCor("Branca");
		System.out.println("Cor do Veiculo da Movimentacao = " + mov2.getVeiculo().getCor());
		System.out.println("Cor do Veiculo v1 = " + v1.getCor());
		
		v1.setCor("Preta");
		System.out.println("Cor do Veiculo da Movimentacao = " + mov2.getVeiculo().getCor());
		System.out.println("Cor do Veiculo v1 = " + v1.getCor());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}

}

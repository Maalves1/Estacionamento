package br.com.impacta.curso.java.estacionamento.testes;

import br.com.impacta.curso.java.estacionamento.controladores.EstacionamentoController;
import br.com.impacta.curso.java.estacionamento.controladores.LotadoException;
import br.com.impacta.curso.java.estacionamento.controladores.VazioException;

public class TesteFluxoEstacionamento {

	public static void main(String[] args) throws LotadoException, VazioException {
		
		EstacionamentoController control = new EstacionamentoController();

		control.entrar("AAA-1111","Fiat","Strada","Prata");
		control.entrar("BBB-2222","Crevrolet","Agile","Marrom");
		control.entrar("CCC-3333","Honda","Fit","Vermelha");
		
		statusEstacionamento(control);
		control.sair("BBB-2222");
		statusEstacionamento(control);
		control.sair("AAA-1111");
		statusEstacionamento(control);
		
		
	}

	static void statusEstacionamento(EstacionamentoController control) {
		System.out.println("\n\n\n\n\n\n");
		System.out.println(" **** VEICULOS ESTACIONADOS **** ");
		control.mostrarEstacionamento();
		System.out.println(" **** ********************** **** ");
	}
}

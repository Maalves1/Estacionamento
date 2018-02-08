package br.com.impacta.curso.java.estacionamento.apresentacao;

import javax.swing.JOptionPane;

import br.com.impacta.curso.java.estacionamento.controladores.EstacionamentoController;
import br.com.impacta.curso.java.estacionamento.controladores.VazioException;

public class SaidaVeiculoFake {
	
	public static void main(String[] args) {
		
		String placa = JOptionPane.showInputDialog("Digite a placa:");
		
		EstacionamentoController controller = new EstacionamentoController();
		
		try {
			controller.sair(placa);
		} catch (VazioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

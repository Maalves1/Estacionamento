package br.com.impacta.curso.java.estacionamento.apresentacao;

import javax.swing.JOptionPane;

import br.com.impacta.curso.java.estacionamento.controladores.EstacionamentoController;
import br.com.impacta.curso.java.estacionamento.controladores.LotadoException;

public class EntradaVeiculoFake {
	
	public static void main(String[] args) {
		
		String placa = JOptionPane.showInputDialog("Informe a placa:");
		String marca = JOptionPane.showInputDialog("Informe a marca:");
		String modelo = JOptionPane.showInputDialog("Informe o modelo:");
		String cor = JOptionPane.showInputDialog("Informe a cor:");
		
		EstacionamentoController controller = new EstacionamentoController();
		
		try {
			controller.entrar(placa,marca,modelo,cor);
		} catch (LotadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

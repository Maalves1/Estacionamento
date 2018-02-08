package br.com.impacta.curso.java.estacionamento.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaPrincipal extends JFrame {
	
	JButton btnEntrar = new JButton();
	JButton btnSair = new JButton();
	
	public static void main(String[] args) {
		TelaPrincipal principal = new TelaPrincipal();
		principal.setVisible(true);
	}
	
	public TelaPrincipal() {
		
		this.setSize(1000,550);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de Estacionamento");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new GridLayout(1,2));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TelaDadosVeiculo telaVeiculo = new TelaDadosVeiculo(TelaPrincipal.this);
				telaVeiculo.setVisible(true);
			}
		});
		
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\maalves1\\Desktop\\Calculo Média\\Estacionamento\\img\\entrada.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TelaSaidaVeiculo telaSaida = new TelaSaidaVeiculo(TelaPrincipal.this);
				telaSaida.setVisible(true);
			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\maalves1\\Desktop\\Calculo Média\\Estacionamento\\img\\saída.png"));
		
		this.getContentPane().add(btnEntrar);
		this.getContentPane().add(btnSair);
		
	}

}

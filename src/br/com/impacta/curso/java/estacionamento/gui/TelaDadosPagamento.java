package br.com.impacta.curso.java.estacionamento.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDadosPagamento extends JFrame {

	private JPanel contentPane;
	private JFrame telaPrincipal;
	private Movimentacao movimentacao;

	/**
	 * Cria a tela de pagamento baseada nos dados completos da movimentação finalizada
	 * @param movimentacao Movimentação com todos os dados para pagamento
	 * @param telaPrincipal Tela de entrada e saida de veículo
	 */
	public TelaDadosPagamento(TelaPrincipal telaPrincipal, Movimentacao movimentacao) {
		this.telaPrincipal = telaPrincipal;
		this.movimentacao = movimentacao;
		
		setResizable(false);
		setTitle("Dados do Pagamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa :");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlaca.setBounds(60, 49, 127, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblDataEntrada = new JLabel("Entrada :");
		lblDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataEntrada.setBounds(60, 83, 127, 14);
		contentPane.add(lblDataEntrada);
		
		JLabel lblSaida = new JLabel("Sa\u00EDda :");
		lblSaida.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSaida.setBounds(60, 122, 127, 14);
		contentPane.add(lblSaida);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValor.setBounds(60, 161, 127, 14);
		contentPane.add(lblValor);
		
		JLabel lblValorPlaca = new JLabel(movimentacao.getVeiculo().getPlaca());
		lblValorPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorPlaca.setBounds(171, 51, 188, 14);
		contentPane.add(lblValorPlaca);
		
		JLabel lblValorEntrada = new JLabel(movimentacao.getDataEntrada().toString());
		lblValorEntrada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorEntrada.setBounds(171, 85, 188, 14);
		contentPane.add(lblValorEntrada);
		
		JLabel lblValorSaida = new JLabel(movimentacao.getDataSaida().toString());
		lblValorSaida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorSaida.setBounds(173, 124, 186, 14);
		contentPane.add(lblValorSaida);
		
		JLabel lblDadoValor = new JLabel("R$ " + movimentacao.getValor());
		lblDadoValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDadoValor.setBounds(173, 163, 186, 14);
		contentPane.add(lblDadoValor);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				telaPrincipal.setVisible(true);
			}
		});
		btnOk.setBounds(156, 227, 91, 23);
		contentPane.add(btnOk);
		
		this.setLocationRelativeTo(telaPrincipal);
	}

}

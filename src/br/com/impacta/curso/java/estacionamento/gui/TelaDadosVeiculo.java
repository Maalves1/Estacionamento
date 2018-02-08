package br.com.impacta.curso.java.estacionamento.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.impacta.curso.java.estacionamento.controladores.EstacionamentoController;
import br.com.impacta.curso.java.estacionamento.controladores.LotadoException;

public class TelaDadosVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JFrame telaPrincipal;

	public TelaDadosVeiculo(JFrame telaPrincipal) {
		
		this.telaPrincipal = telaPrincipal;
		
		setResizable(false);
		setTitle("Dados do Ve\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa :");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlaca.setBounds(57, 74, 87, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(57, 124, 87, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo :");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(57, 179, 87, 14);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor :");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCor.setBounds(57, 231, 87, 14);
		contentPane.add(lblCor);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(137, 73, 144, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(137, 123, 144, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(137, 178, 144, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(137, 230, 144, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstacionamentoController controller = new EstacionamentoController();
				String placa  = txtPlaca.getText();
				String marca  = txtMarca.getText();
				String modelo = txtModelo.getText();
				String cor    = txtCor.getText();
				
				try{
					controller.entrar(placa, marca, modelo, cor);
					JOptionPane.showMessageDialog(null, 
											"Veiculo de placa "  + placa + " estacionado",
											"Entrada de Veículo",
											JOptionPane.INFORMATION_MESSAGE);
				}catch(LotadoException e){
					JOptionPane.showMessageDialog(null,	e.getMessage(),
												  "Entrada de Veículo",
												  JOptionPane.ERROR_MESSAGE);
				}
				
				mostrarTelaPrincipal();
			}
		});
		btnOk.setBounds(53, 304, 91, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTelaPrincipal();
			}
		});
		btnCancelar.setBounds(173, 304, 91, 23);
		contentPane.add(btnCancelar);
		
		this.setLocationRelativeTo(telaPrincipal);
	}
	
	private void mostrarTelaPrincipal() {
		this.dispose(); //remove a tela dados de veiculo da memória
		telaPrincipal.setVisible(true);
	}

}

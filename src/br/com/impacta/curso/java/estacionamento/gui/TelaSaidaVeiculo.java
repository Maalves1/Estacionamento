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
import br.com.impacta.curso.java.estacionamento.controladores.VazioException;
import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;

public class TelaSaidaVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JFrame telaPrincipal;

	public TelaSaidaVeiculo(TelaPrincipal telaPrincipal) {
		
		this.telaPrincipal = telaPrincipal;
		
		setResizable(false);
		setTitle("Sa\u00EDda de Ve\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa :");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlaca.setBounds(46, 53, 60, 26);
		contentPane.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPlaca.setBounds(133, 45, 193, 37);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String placa = txtPlaca.getText();
				EstacionamentoController controller = new EstacionamentoController();
				
				try{
					Movimentacao movimentacao = controller.sair(placa);
					
					if(movimentacao != null){
						TelaDadosPagamento telaPagamento = new TelaDadosPagamento(telaPrincipal, movimentacao);
						telaPagamento.setVisible(true);		
					}else{
						JOptionPane.showMessageDialog(null, "Veiculo não Encontrado",
													  "Saida de Veiculo",JOptionPane.ERROR_MESSAGE);
						telaPrincipal.setVisible(true);
					}
					
				}catch(VazioException e){
					JOptionPane.showMessageDialog(null, e.getMessage(),
							  "Saida de Veiculo",JOptionPane.ERROR_MESSAGE);
					telaPrincipal.setVisible(true);
				}finally{
					dispose();
				}
			}
		});
		btnOK.setBounds(101, 129, 91, 23);
		contentPane.add(btnOK);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTelaPrincipal();
			}
		});
		btnCancelar.setBounds(232, 129, 91, 23);
		contentPane.add(btnCancelar);
		
		this.setLocationRelativeTo(telaPrincipal);
	}//fim do construtor
	
	private void mostrarTelaPrincipal(){
		this.dispose();
		telaPrincipal.setVisible(true);
	}

}

package br.com.impacta.curso.java.estacionamento.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.Date;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Veiculo;

public class DAOEstacionamentoInFile extends DAOEstacionamento {

	@Override
	public void gravar(Movimentacao movimentacao) {

		try (BufferedWriter out = new BufferedWriter(new FileWriter("mov.db",true))) {
			out.append(movimentacao.getVeiculo().getPlaca()).append("#"); 
			out.append(movimentacao.getVeiculo().getMarca()).append("#");
			out.append(movimentacao.getVeiculo().getModelo()).append("#");
			out.append(movimentacao.getVeiculo().getCor()).append("#");
			out.append(new Date().toString());
			out.newLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public Movimentacao buscarMovimentacaoAberta(String placa) {
		Movimentacao movimentacao = null;

		try (BufferedReader in = new BufferedReader(new FileReader("mov.db"))) {

			String linha = in.readLine();
			while (linha != null) {
				String campos[] = linha.split("#");
				String strPlaca = campos[0];
				if (strPlaca.equalsIgnoreCase(placa)) {
					String marca = campos[1];
					String modelo = campos[2];
					String cor = campos[3];
					String data = campos[4];
					Veiculo veiculo = new Veiculo(strPlaca, marca, modelo, cor);
					movimentacao = new Movimentacao(veiculo,
							LocalDateTime.now());
					movimentacao.setDataSaida(LocalDateTime.now());
					break;
				}
				linha = in.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return movimentacao;

	}

	@Override
	public void atualizar(Movimentacao movimentacao) {

		String placa = movimentacao.getVeiculo().getPlaca();
		RandomAccessFile file;
		try {
			file = new RandomAccessFile("mov.db", "rw");
			String valor = file.readLine();
			int posicao = 0;
			while (valor != null) {
				if (valor.contains(placa)) {
					file.seek(posicao);
					file.write('-');
					file.close();
					break;
				}
				posicao += (valor.length() + 1);
				System.out.println("posicao: " + posicao);
				valor = file.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listarVeiculosEstacionados() {
		// TODO Auto-generated method stub
	}

	@Override
	public int getVagasOcupadas() {
		return 1;
	}

}

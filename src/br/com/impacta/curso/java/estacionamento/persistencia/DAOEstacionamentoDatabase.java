package br.com.impacta.curso.java.estacionamento.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Veiculo;
import br.com.impacta.curso.java.estacionamento.util.DatabaseUtil;

public class DAOEstacionamentoDatabase extends DAOEstacionamento {

	@Override
	public void gravar(Movimentacao movimentacao) {

		String cmd = "INSERT INTO tb_movimentacoes (placa,marca,modelo,cor,data_entrada) "
				+ " VALUES (?,?,?,?,?)";

		Connection conexao = DatabaseUtil.getConnection();
		try {

			PreparedStatement stmt = conexao.prepareStatement(cmd);
			stmt.setString(1, movimentacao.getVeiculo().getPlaca());
			stmt.setString(2, movimentacao.getVeiculo().getMarca());
			stmt.setString(3, movimentacao.getVeiculo().getModelo());
			stmt.setString(4, movimentacao.getVeiculo().getCor());

			stmt.setString(
					5,
					movimentacao.getDataEntrada().format(
							DateTimeFormatter.ISO_DATE_TIME));

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnection(conexao);
		}

	}

	@Override
	public void listarVeiculosEstacionados() {
		// TODO Auto-generated method stub

	}

	@Override
	public Movimentacao buscarMovimentacaoAberta(String placa) {

		Movimentacao movimentacao = null;

		String cmd = " select placa,marca,modelo,cor,data_entrada "
				+ " from tb_movimentacoes where data_saida is null "
				+ " and placa = ?";

		Connection conexao = DatabaseUtil.getConnection();

		try {

			PreparedStatement stmt = conexao.prepareStatement(cmd);
			stmt.setString(1, placa);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				String splaca = result.getString("placa");
				String marca = result.getString("marca");
				String modelo = result.getString("modelo");
				String cor = result.getString("cor");
				String sdata = result.getString("data_entrada");

				Veiculo veiculo = new Veiculo(splaca, marca, modelo, cor);
				LocalDateTime data = LocalDateTime.parse(sdata,
						DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));

				movimentacao = new Movimentacao(veiculo, data);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnection(conexao);
		}

		return movimentacao;
	}

	@Override
	public void atualizar(Movimentacao movimentacao) {
		String cmd = " update tb_movimentacoes set data_saida = ?, "
				+ " valor = ? where placa = ? and data_saida is null ";

		Connection conexao = DatabaseUtil.getConnection();

		try {
			PreparedStatement stmt = conexao.prepareStatement(cmd);
			stmt.setString(
					1,
					movimentacao.getDataSaida().format(
							DateTimeFormatter.ISO_DATE_TIME));
			stmt.setDouble(2, movimentacao.getValor());
			stmt.setString(3, movimentacao.getVeiculo().getPlaca());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnection(conexao);
		}

	}

	@Override
	public int getVagasOcupadas() {
		String cmd = " select count(*) from tb_movimentacoes "
				+ " where data_saida is null";

		Connection conexao = DatabaseUtil.getConnection();
		int ocupadas = 0;

		try {
			PreparedStatement stmt = conexao.prepareStatement(cmd);

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				ocupadas = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeConnection(conexao);
		}

		return ocupadas;

	}

}

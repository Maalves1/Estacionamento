package br.com.impacta.curso.java.estacionamento.persistencia;

import java.util.Properties;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.util.EstacionamentoUtil;

public abstract class DAOEstacionamento {

	public abstract void gravar(Movimentacao movimentacao);

	public abstract void listarVeiculosEstacionados();

	public abstract Movimentacao buscarMovimentacaoAberta(String placa);

	public abstract void atualizar(Movimentacao movimentacao);

	public abstract int getVagasOcupadas();

	/**
	 * Ler de um arquivo de configura??es o tipo de camada de persist?ncia
	 * 
	 * @return Implementacao da camada de persistencia definida pelo usu?rio
	 */
	public static DAOEstacionamento getEstacionamentoDAO() {

		Properties config = EstacionamentoUtil.getConfig();
		String tipoPersistencia = (String) config.get("persistencia");

		switch (tipoPersistencia) {
		case "FILE":
			return new DAOEstacionamentoInFile();
		case "MEMORY":
			return new DAOEstacionamentoInMemory();
		case "DATABASE":
			return new DAOEstacionamentoDatabase();
		default:
			throw new IllegalArgumentException("Persistencia indefinida");
		}
	}

}

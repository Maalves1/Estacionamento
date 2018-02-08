package br.com.impacta.curso.java.estacionamento.controladores;

import java.time.LocalDateTime;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Vaga;
import br.com.impacta.curso.java.estacionamento.dominio.Veiculo;
import br.com.impacta.curso.java.estacionamento.persistencia.DAOEstacionamento;
import br.com.impacta.curso.java.estacionamento.util.EstacionamentoUtil;

public class EstacionamentoController {
	
	public EstacionamentoController() {
		inicializar();
	}
	
	private void inicializar() {
		DAOEstacionamento dao = DAOEstacionamento.getEstacionamentoDAO();
		int ocupadas = dao.getVagasOcupadas();
		Vaga.setOcupadas(ocupadas);
	}

	/**
	 * Metodo que realiza a entrada de um veiculo no estacionamento. Cria uma
	 * instância de movimentação associando o veiculo. Determinar a hora de
	 * entrada como a data/hora corrente.
	 * 
	 * @param placa
	 *            Representa a placa do Veiculo
	 * @param marca
	 *            Representa a marca do Veiculo
	 * @param modelo
	 *            Representa o modelo do Veiculo
	 * @param cor
	 *            Representa a cor do Veiculo
	 * @throws LotadoException  Quando entra um veiculo com estacionamento lotado.
	 */
	public void entrar(String placa, String marca, String modelo, String cor) throws LotadoException  {

		if (Vaga.temVaga()) {
			Veiculo veiculo = new Veiculo(placa, marca, modelo, cor);
			Movimentacao movimentacao = new Movimentacao(veiculo,LocalDateTime.now());
			DAOEstacionamento dao = DAOEstacionamento.getEstacionamentoDAO();
			dao.gravar(movimentacao);
			Vaga.entrouVeiculo(); // atualiza numero de vagas ocupadas
		} else {
			throw new LotadoException("Lotação Esgotada: " + Vaga.TOTAL_VAGAS + " ocupadas");
		}

	}

	/**
	 * Implementa a lógica de saída de um veiculo do estacionamento. Recupera a
	 * movimentação aberta associada à placa informada e atualiza os dados de
	 * data de saida e calcula o valor a ser pago.
	 * 
	 * @param placa A Placa do Veiculo estacionado.
	 * @return Movimentacao com os valores atualizados - Data de Saida e valor
	 *         ou null se o veículo não for encontrado
	 */
	public Movimentacao sair(String placa) throws VazioException {
		Movimentacao movimentacao = null;

		if (!Vaga.estaVazio()) {
			DAOEstacionamento dao = DAOEstacionamento.getEstacionamentoDAO();
			movimentacao = dao.buscarMovimentacaoAberta(placa);
			
			if(movimentacao != null){
				movimentacao.setDataSaida(LocalDateTime.now());
				double valor = EstacionamentoUtil.calcularPreco(movimentacao);
				movimentacao.setValor(valor);
				dao.atualizar(movimentacao);
				Vaga.saiuVeiculo();
			}

		} else {
			throw new VazioException("Estacionamento Vazio!");
		}
		
		return movimentacao;

	}

	public void mostrarEstacionamento() {
		DAOEstacionamento dao = DAOEstacionamento.getEstacionamentoDAO();
		dao.listarVeiculosEstacionados();
	}

}

package br.com.impacta.curso.java.estacionamento.persistencia;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Vaga;

public class DAOEstacionamentoInMemory extends DAOEstacionamento{
	
	/**
	 * Simula uma base de dados rudimentar em memória para as movimentações
	 */
	private static Movimentacao[] movimentacoes = new Movimentacao[Vaga.TOTAL_VAGAS];

	/**
	 * Grava as informações da movimentação base de dados.
	 * 
	 * @param movimentacao Instância da movimentação gerada pelo veiculo
	 */
	public void gravar(Movimentacao movimentacao) {
		System.out.println("Gravando dados da movimentação ...");
		movimentacao.mostraDados();
		
		for(int i=0; i< movimentacoes.length; i++){
			if(movimentacoes[i] == null){
				movimentacoes[i] = movimentacao; //se posição vazia, insere movimentacao
				break; //já que encontrou, pode encerrar o loop
			}
		}
		
		System.out.println("Movimentação gerada com sucesso!");
		
	}

	/**
	 * Busca, dentre os veículos estacionados, a movimentação cujo veículo
	 * tenha a placa igual à informada no parâmetro. 
	 * 
	 * @param placa A placa do veiculo estacionado
	 * 
	 * @return A instância da movimentação se existir ou null se não encontrar
	 */
	public Movimentacao buscarMovimentacaoAberta(String placa) {
		System.out.println("Recuperando a movimentação aberta do veiculo placa " + placa);
		Movimentacao movimentacao = null;
		
		for(int i=0; i<movimentacoes.length; i++){
			if(movimentacoes[i] != null){
		//verifica se o veiculo da movimentacao gravada tem a placa igual parametro
				if (movimentacoes[i].getVeiculo().getPlaca().equalsIgnoreCase(placa)){
					movimentacao = movimentacoes[i];
					break; //encontrou, sai do loop
				}
			}
		}
		
		return movimentacao;
	}

	public void atualizar(Movimentacao movimentacao) {
		System.out.println("Atualizando os dados da movimentação fechada... ");
		movimentacao.mostraDados();
		
		for(int i=0; i<movimentacoes.length; i++){
			if (movimentacoes[i].getVeiculo().getPlaca()
					.equalsIgnoreCase(movimentacao.getVeiculo().getPlaca())){

				movimentacoes[i] = null; //libera a "vaga"
				break;
			}
		}
	}

	public void listarVeiculosEstacionados() {
		
		for(Movimentacao movimentacao : movimentacoes){
			if(movimentacao != null){
				movimentacao.getVeiculo().mostraDados();
				System.out.println("-------------------");
			}
		}
		
	}

	@Override
	public int getVagasOcupadas() {
		//TODO zera a cada inicializacao 
		return 1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

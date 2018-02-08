package br.com.impacta.curso.java.estacionamento.persistencia;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Vaga;

public class DAOEstacionamentoInMemory extends DAOEstacionamento{
	
	/**
	 * Simula uma base de dados rudimentar em mem�ria para as movimenta��es
	 */
	private static Movimentacao[] movimentacoes = new Movimentacao[Vaga.TOTAL_VAGAS];

	/**
	 * Grava as informa��es da movimenta��o base de dados.
	 * 
	 * @param movimentacao Inst�ncia da movimenta��o gerada pelo veiculo
	 */
	public void gravar(Movimentacao movimentacao) {
		System.out.println("Gravando dados da movimenta��o ...");
		movimentacao.mostraDados();
		
		for(int i=0; i< movimentacoes.length; i++){
			if(movimentacoes[i] == null){
				movimentacoes[i] = movimentacao; //se posi��o vazia, insere movimentacao
				break; //j� que encontrou, pode encerrar o loop
			}
		}
		
		System.out.println("Movimenta��o gerada com sucesso!");
		
	}

	/**
	 * Busca, dentre os ve�culos estacionados, a movimenta��o cujo ve�culo
	 * tenha a placa igual � informada no par�metro. 
	 * 
	 * @param placa A placa do veiculo estacionado
	 * 
	 * @return A inst�ncia da movimenta��o se existir ou null se n�o encontrar
	 */
	public Movimentacao buscarMovimentacaoAberta(String placa) {
		System.out.println("Recuperando a movimenta��o aberta do veiculo placa " + placa);
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
		System.out.println("Atualizando os dados da movimenta��o fechada... ");
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

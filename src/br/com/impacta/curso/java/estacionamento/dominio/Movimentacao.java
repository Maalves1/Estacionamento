package br.com.impacta.curso.java.estacionamento.dominio;
import java.time.LocalDateTime;

public class Movimentacao {
	
	private Veiculo veiculo;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private double valor;
	
	public Movimentacao(){}
	
	/**
	 * Construtor que recebe o veiculo relacionado à movimentação e a data/hora
	 * de entrada do veículo no estacionamento
	 * 
	 * @param veiculo Veiculo que gera a movimentacao
	 * @param dataEntrada Data/hora de entrada 
	 */
	public Movimentacao(Veiculo veiculo, LocalDateTime dataEntrada){
		this.setVeiculo(veiculo);
		this.setDataEntrada(dataEntrada);
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if(valor > 0){
			this.valor = valor;
		}
	}

	public void mostraDados(){
		System.out.println("----- Dados do Veiculo -----");
		veiculo.mostraDados();
		System.out.println("----- - -----");
		System.out.println("Entrada em: " + dataEntrada);
		System.out.println("Saida em: " + dataSaida);
		System.out.println("Valor: " + valor);
		
	}

	@Override
	public String toString() {
		return "Movimentacao [veiculo=" + veiculo + ", dataEntrada="
				+ dataEntrada + ", dataSaida=" + dataSaida + ", valor=" + valor
				+ "]";
	}

}

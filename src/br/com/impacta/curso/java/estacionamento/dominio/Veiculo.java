package br.com.impacta.curso.java.estacionamento.dominio;

public class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	
	public Veiculo(){}

	/**
	 * Construtor que recebe somente a placa do veículo. 
	 * Considerando que estacionado num determinado momento só exista
	 * um veículo com determinada placa.
	 * 
	 * @param placa A Placa do veículo no formato LLL-NNNN (L=Letra e N=Numero)
	 */
	public Veiculo(String placa){
		this.setPlaca(placa);
	}
	
	/**
	 * Construtor que recebe valores para todos os atributos do veiculo
	 * @param placa A Placa do veículo no formato LLL-NNNN (L=Letra e N=Numero)
	 * @param marca A Marca do veiculo (ex: Fiat )
	 * @param modelo O Modelo do veículo (ex: Strada )
	 * @param cor A cor do veiculo (ex: branco )
	 */
	public Veiculo(String placa, String marca, String modelo, String cor){
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setCor(cor);
	}
	
	public void mostraDados(){
		System.out.println("Placa:" + placa);
		System.out.println("Marca:" + marca);
		System.out.println("Modelo:" + modelo);
		System.out.println("Cor:" + cor);

	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + ", modelo="
				+ modelo + ", cor=" + cor + "]";
	}
		

	
}

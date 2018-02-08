package br.com.impacta.curso.java.estacionamento.dominio;

public class Tarifario {
	
	private static double valorHora = 10 ;
	private static double valorIncremental = 2;
	private static int incrementoEmMinutos = 15;
	
	private Tarifario(){} //não há como se criar instâncias desta classe fora dela
	
	public static void mostraDados(){
		System.out.println("Valor da Hora " + valorHora);
		System.out.println("Valor Incremental " + valorIncremental);
		System.out.println("Parcial de " + incrementoEmMinutos + " minutos");
	}

	public static double getValorHora() {
		return valorHora;
	}

	public static void setValorHora(double valorHora) {
		if(valorHora > 0){
			Tarifario.valorHora = valorHora;
		}
	}

	public static double getValorIncremental() {
		return valorIncremental;
	}

	public static void setValorIncremental(double valorIncremental) {
		if(valorIncremental > 0){
			Tarifario.valorIncremental = valorIncremental;
		}
	}

	public static int getIncrementoEmMinutos() {
		return incrementoEmMinutos;
	}

	public static void setIncrementoEmMinutos(int incrementoEmMinutos) {
		if(incrementoEmMinutos > 0){
			Tarifario.incrementoEmMinutos = incrementoEmMinutos;
		}
	}
	
	

}

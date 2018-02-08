package br.com.impacta.curso.java.estacionamento.dominio;

public class Vaga {
	
	public final static int TOTAL_VAGAS = 100; //total de vagas do estacionamento
	private static int ocupadas;
	
	private Vaga(){} //não crio instâncias a partir de outra classe
	
	public static void mostraDados() {
		System.out.println("Total de Vagas = " + TOTAL_VAGAS);
		System.out.println("Vagas Ocupadas = " + ocupadas);
	}

	public static int getOcupadas() {
		return ocupadas;
	}

	public static void setOcupadas(int ocupadas) {
		if(ocupadas >= 0){
			Vaga.ocupadas = ocupadas;
		}
	}

	public static boolean temVaga() {
		return (ocupadas < TOTAL_VAGAS);
	}

	public static void entrouVeiculo() {
		ocupadas++;
	}

	public static boolean estaVazio() {
		return (ocupadas == 0);
	}

	public static void saiuVeiculo() {
		ocupadas--;
	}

}

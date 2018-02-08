package br.com.impacta.curso.java.estacionamento.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

import br.com.impacta.curso.java.estacionamento.dominio.Movimentacao;
import br.com.impacta.curso.java.estacionamento.dominio.Tarifario;

public class EstacionamentoUtil {

	public static double calcularPreco(Movimentacao movimentacao) {
		 
		 double precoFinal = 0.0;
         LocalDateTime entrada = movimentacao.getDataEntrada();
         LocalDateTime saida = movimentacao.getDataSaida();

         Duration estada = Duration.between(entrada, saida);

         long diffHoras = estada.toHours();
         saida = saida.minus(diffHoras,ChronoUnit.HOURS);
         estada = Duration.between(entrada, saida);
         long diffMinutos = estada.toMinutes();

         if(diffHoras < 1){
                precoFinal = Tarifario.getValorHora();
         }else{
                precoFinal = (Tarifario.getValorHora() * diffHoras) +
                                    Tarifario.getValorIncremental() * 
                                    (diffMinutos / Tarifario.getIncrementoEmMinutos()); 	
               }
         return precoFinal;
	}

	public static Properties getConfig() {
		Properties propriedades = new Properties();
		try {
			propriedades.load(new FileInputStream("config.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propriedades;

	}

}

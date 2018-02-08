package br.com.impacta.curso.java.estacionamento.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
	
	public static Connection getConnection(){
		
		Properties config = EstacionamentoUtil.getConfig();
		String url = config.getProperty("jdbc:mysql://localhost/Calculo Média/Estacionamento");
		String usuario = config.getProperty("root");
		String senha = config.getProperty("Imp@ct@");
		
		try{
			Connection conexao = DriverManager.getConnection(url,usuario,senha);
			return conexao;
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null; //se não conseguiu estabelecer a conexao
	}
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}

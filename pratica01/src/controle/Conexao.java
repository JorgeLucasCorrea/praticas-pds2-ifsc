package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conexao;
	private static Conexao instancia;
	private static final String DATABASE = "jorge";
	private static final String USER = "root";
	private static final String PSW = "aluno";
	
	private Conexao() {
		
	}
	
	public static Conexao getInstancia() {
		if(instancia == null ) {
			instancia = new Conexao();
		}
		
		return instancia;
	}
	
	public  Connection conectar() {
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER, PSW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public  boolean fecharConexao() {
		
		
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return false;
		
		
	}
	
}

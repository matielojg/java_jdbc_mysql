package classes_de_teste;

import java.sql.SQLException;

import loja_virtual_jdbc_java.ConnectionFactory;

public class TestaPoolConexoes {

	/**
	 * Classe que testa a abertura de conexões setada na connectionFactory com setMaxPoolSize
	 * é possivel verificar no banco com o comando : show processlist;
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}
	}
}

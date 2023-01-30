package loja_virtual_jdbc_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (? , ?)",
				Statement.RETURN_GENERATED_KEYS);
//		String sql = "UPDATE PRODUTO  SET nome = '"+ nome + "', descricao = '"+ descricao + "' WHERE ID = 3";

		adicionaVariavel("SmartTV", "45 pol ", stm);
		adicionaVariavel("Radio", "Radio de pilha", stm);
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);

		}
		rst.close();
	}
}
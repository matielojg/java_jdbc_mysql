package classes_de_teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import loja_virtual_jdbc_java.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {
			
			connection.setAutoCommit(false);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionaVariavel("SmartTV", "45 pol ", stm);
				adicionaVariavel("Radio", "Radio de pilha", stm);

				connection.commit();
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionaVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

//		if (nome.equals("Radio")) {
//			throw new RuntimeException("Não foi possivel adicionar o produto");
//		}

		stm.execute();
		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
				// try with resources, nao precisa explicitar o fechamento da conexao, pois
				// extende o autocloseable()
			}
		}
	}
}
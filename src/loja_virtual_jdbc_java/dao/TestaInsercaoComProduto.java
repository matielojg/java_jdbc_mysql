package loja_virtual_jdbc_java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import loja_virtual_jdbc_java.ConnectionFactory;
import loja_virtual_jdbc_java.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda", "Comoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			String sql = "INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (? , ? )";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, comoda.getNome());
				pstm.setString(2, comoda.getDescricao());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						comoda.setId(rst.getInt(1));
					}
				}
			}
		}
		System.out.println(comoda);
	}
}
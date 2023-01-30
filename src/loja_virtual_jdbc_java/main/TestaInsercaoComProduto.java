package loja_virtual_jdbc_java.main;

import java.sql.Connection;
import java.sql.SQLException;

import loja_virtual_jdbc_java.ConnectionFactory;
import loja_virtual_jdbc_java.dao.ProdutoDAO;
import loja_virtual_jdbc_java.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda1", "Comoda Vertical 1");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);

		}
	}
}

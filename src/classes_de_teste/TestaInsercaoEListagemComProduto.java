package classes_de_teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import loja_virtual_jdbc_java.ConnectionFactory;
import loja_virtual_jdbc_java.dao.ProdutoDAO;
import loja_virtual_jdbc_java.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("Comoda1", "Comoda Vertical 1");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}

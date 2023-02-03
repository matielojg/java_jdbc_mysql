package classes_de_teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import loja_virtual_jdbc_java.ConnectionFactory;
import loja_virtual_jdbc_java.dao.CategoriaDAO;
import loja_virtual_jdbc_java.dao.ProdutoDAO;
import loja_virtual_jdbc_java.modelo.Categoria;
import loja_virtual_jdbc_java.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});

		}
	}
}
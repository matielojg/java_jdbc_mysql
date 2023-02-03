package loja_virtual_jdbc_java.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import loja_virtual_jdbc_java.ConnectionFactory;
import loja_virtual_jdbc_java.dao.CategoriaDAO;
import loja_virtual_jdbc_java.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
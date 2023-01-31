package loja_virtual_jdbc_java.modelo;

public class Categoria {
	private Integer id;
	private String nome;

	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}

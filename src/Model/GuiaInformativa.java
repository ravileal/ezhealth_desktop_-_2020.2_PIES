package Model;

public class GuiaInformativa {

	private String titulo;
	private String descricao;
	private String categoria;

	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return this.categoria;
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
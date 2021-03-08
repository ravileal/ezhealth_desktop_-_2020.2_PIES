package Model;

public class Usuario {

	private String nome;
	private String idade;
	private String altura;
	private String peso;
	private String sexo;
	private String usuario;
	private String senha;
	private String objetivo;
	private String caloriasMeta;

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return this.idade;
	}

	/**
	 * 
	 * @param idade
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getAltura() {
		return this.altura;
	}

	/**
	 * 
	 * @param altura
	 */
	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPeso() {
		return this.peso;
	}

	/**
	 * 
	 * @param peso
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return this.sexo;
	}

	/**
	 * 
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	/**
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	/**
	 * 
	 * @param objetivo
	 */
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getCaloriasMeta() {
		return this.caloriasMeta;
	}

	/**
	 * 
	 * @param caloriasMeta
	 */
	public void setCaloriasMeta(String caloriasMeta) {
		this.caloriasMeta = caloriasMeta;
	}

	public float calculoIMC() {
		// TODO - implement Usuario.calculoIMC
		throw new UnsupportedOperationException();
	}

}
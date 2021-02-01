package Model;

public class Usuario {

	private String nome;
	private int idade;
	private float altura;
	private float peso;
	private String sexo;
	private String usuario;
	private String senha;
	private String objetivo;
	private int caloriasMeta;

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

	public int getIdade() {
		return this.idade;
	}

	/**
	 * 
	 * @param idade
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getAltura() {
		return this.altura;
	}

	/**
	 * 
	 * @param altura
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return this.peso;
	}

	/**
	 * 
	 * @param peso
	 */
	public void setPeso(float peso) {
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

	public int getCaloriasMeta() {
		return this.caloriasMeta;
	}

	/**
	 * 
	 * @param caloriasMeta
	 */
	public void setCaloriasMeta(int caloriasMeta) {
		this.caloriasMeta = caloriasMeta;
	}

	public float calculoIMC() {
		// TODO - implement Usuario.calculoIMC
		throw new UnsupportedOperationException();
	}

}
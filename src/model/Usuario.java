package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.DatasFormatadas;

public class Usuario extends Model{

	private String dataNascimento;
	private String altura;
	private String peso;
	private String sexo;
	private String usuario;
	private String senha;
	private String confirmaSenha;
	private String objetivo;
	private int caloriasGastas;
	private int caloriasConsumidas;
	private int caloriasMeta;
	private int caloriasMetaOriginal;
	private boolean lactose;
	private boolean gluten;
	private boolean diabetes;
	private boolean colesterolAlto;
	
	private List<Refeicao> listRefeicao;
	private List<Exercicio> listExercicio;
	
	
	public Usuario() {
		this.listRefeicao = new ArrayList<Refeicao>();
		this.listExercicio = new ArrayList<Exercicio>();
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
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


	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public boolean isLactose() {
		return lactose;
	}

	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean glute) {
		this.gluten = glute;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isColesterolAlto() {
		return colesterolAlto;
	}

	public void setColesterolAlto(boolean colesterolAlto) {
		this.colesterolAlto = colesterolAlto;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
 
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getCaloriasMetaOriginal() {
		return caloriasMetaOriginal;
	}

	public void setCaloriasMetaOriginal(int caloriasMetaOriginal) {
		this.caloriasMetaOriginal = caloriasMetaOriginal;
	}
	
	// GASTAS
	public void setCaloriasGastas(int caloriasGastas) {
		this.caloriasGastas = caloriasGastas;
	}
	
	public int getCaloriasGastas() {
		return this.caloriasGastas;
	}
	
	public void addCaloriasGastas(int calorias) {
		this.caloriasGastas += calorias;
		this.addCaloriasMeta(calorias);
	}

	public void decCaloriasGastas(int calorias) {
		this.caloriasGastas -= calorias;
		this.decCaloriasMeta(calorias);
	}
	
	public List<Refeicao> getListRefeicao() {
		return listRefeicao;
	}

	public void setListRefeicao(List<Refeicao> listRefeicao) {
		this.listRefeicao = listRefeicao;
	}

	public List<Exercicio> getListExercicio() {
		return listExercicio;
	}

	public void setListExercicio(List<Exercicio> listExercicio) {
		this.listExercicio = listExercicio;
	}

	// CONSUMIDAS
	public void setCaloriasConsumidas(int caloriasConsumidas) {
		this.caloriasConsumidas = caloriasConsumidas;
	}
	
	public int getCaloriasConsumidas() {
		return this.caloriasConsumidas;
	}
	
	public void addCaloriasConsumidas(int calorias) {
		this.caloriasConsumidas += calorias;
		this.decCaloriasMeta(calorias);
	}

	public void decCaloriasConsumidas(int calorias) {
		this.caloriasConsumidas -= calorias;
		this.addCaloriasMeta(calorias);
	}

	// META CONSUMIR POR DIA
	public void setCaloriasMeta(int caloriasMeta) {
		this.caloriasMeta = caloriasMeta;
	}
	
	public int getCaloriasMeta() {
		return this.caloriasMeta;
	}

	public void addCaloriasMeta(int calorias) {
		this.caloriasMeta += calorias;
	}

	public void decCaloriasMeta(int calorias) {
		this.caloriasMeta -= calorias;
	}
	
	//
	public void calularMetaCaloria() {
		int idade = getIdade();
		
		float coeficientePeso   = (float) ((this.sexo.equals("Feminino"))? 9.56: 13.75);
		float coeficientealtura = (float) ((this.sexo.equals("Feminino"))? 1.85: 5    );
		float coeficienteIdade  = (float) ((this.sexo.equals("Feminino"))? 4.68: 6.76 );
		float temp = (float) (coeficientePeso*Float.parseFloat(peso)) + (coeficientealtura * Float.parseFloat(altura)) - (coeficienteIdade * idade) + 665;
		int kcal = 500;
		
		switch (this.objetivo) {
		case "Perder Peso":
			temp -= kcal;				
			break;
		case "Ganhar Peso":
			temp += kcal;
			break;
		case "Manter Peso":
			break;
		default:
			temp = 0;
			break;
		}
		this.setCaloriasMetaOriginal(Math.round(temp));
		this.caloriasMeta = Math.round(temp);
	}
	
	private int getIdade() {
		String[] datNascimento = this.dataNascimento.toString().split("/");
		
		int anoNascimento = Integer.parseInt(datNascimento[2]);
		int anoAtual = Integer.parseInt(new DatasFormatadas(new Date()).getAno());
		int idade = anoAtual - anoNascimento;
		
		int mesNascimento = Integer.parseInt(datNascimento[1]);
		int mesAtual = new DatasFormatadas(new Date()).getMesNumber();
		
		int diaNascimento = Integer.parseInt(datNascimento[0]);
		int diaAtual = new DatasFormatadas(new Date()).getDiaMesNumber();
		
		if(mesAtual < mesNascimento)
			idade--;
		else if(mesAtual == mesNascimento) {
			if(diaAtual < diaNascimento)
				idade--;
		}
			
		return idade;
	}



}
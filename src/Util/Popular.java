package Util;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import Model.Alimento;
import Model.Exercicio;
import Model.Refeicao;
import Model.Usuario;
import Repository.RepositorioAlimento;
import Repository.RepositorioExercicio;
import Repository.RepositorioExercicioRealizado;
import Repository.RepositorioRefeicao;
import Repository.RepositorioRefeicaoRealizada;
import Repository.RepositorioUsuario;

public class Popular {
	
	private RepositorioAlimento repositorioAlimento;
	private RepositorioExercicio repositorioExercicio;
	private RepositorioExercicioRealizado repositorioExercicioRealizado;
	private RepositorioRefeicao repositorioRefeicao;
	private RepositorioRefeicaoRealizada repositorioRefeicaoRealizada;
	private RepositorioUsuario repositorioUsuario;
	
	private static Popular instance = null; 
	
	public static Popular getInstance() {
		if(instance == null) 
			instance = new Popular();
		return instance;
	}
	 
	private Popular() {
		this.repositorioAlimento = new RepositorioAlimento();
		this.repositorioExercicio = new RepositorioExercicio();
		this.repositorioExercicioRealizado = new RepositorioExercicioRealizado();
		this.repositorioRefeicao = new RepositorioRefeicao();
		this.repositorioRefeicaoRealizada = new RepositorioRefeicaoRealizada();
		this.repositorioUsuario = new RepositorioUsuario();

		popuparAlimentos();
		popuparExercicio();
		popuparExercicioRealizado();
		popuparRefeicao();
		popuparRefeicaoRealizada();
		popuparUsuario();
	}
	
	private void popuparAlimentos() {
		Alimento alimento;
		
		alimento = new Alimento();
		alimento.setNome("Laranja");
		alimento.setCalorias(100);
		repositorioAlimento.adicionar(alimento);
		
		for (int i=0; i<10;i++) {
			alimento = new Alimento();
			alimento.setNome("Manga");
			alimento.setCalorias(50);
			repositorioAlimento.adicionar(alimento);
		}
	}
	
	private void popuparExercicio() {
		Exercicio exercicio = new Exercicio();
		exercicio.setData(new Date());
		exercicio.setNome("Correr");
		
		repositorioExercicio.adicionar(exercicio);
	}
	
	private void popuparExercicioRealizado() {
		Exercicio exercicio = new Exercicio();
		exercicio.setData(new Date());
		exercicio.setNome("Muscula��o");
		
		repositorioExercicioRealizado.adicionar(exercicio);
	}
	
	private void popuparRefeicao() {
		Refeicao refeicao = new Refeicao();
		refeicao.setData(new Date());
		refeicao.setNome("Cafe da manha");
		
		repositorioRefeicao.adicionar(refeicao);
	}
	
	private void popuparRefeicaoRealizada() {
		Refeicao refeicao = new Refeicao();
		refeicao.setData(new Date());
		refeicao.setNome("Cafe da manha");
		
		repositorioRefeicaoRealizada.adicionar(refeicao);
	}
	
	private void popuparUsuario() {
		Usuario u = new Usuario();
		u.setUsuario("Admin");
		u.setSenha("Admin");
		u.setColesterolAlto(true);
		u.setNome("Administrador");
		u.setSexo("Masculino");
		u.setDataNascimento(LocalDate.of(2021, Month.MARCH, 13));
		u.setObjetivo("Manter Peso");
		u.setPeso("02.52");
		u.setAltura("5.00");
		
		repositorioUsuario.adicionar(u);
	}

}

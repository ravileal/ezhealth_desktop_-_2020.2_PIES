package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerExercicioPronto;
import controller.ControllerUsuario;
import model.Alimento;
import model.Exercicio;
import model.ExercicioPronto;
import model.Model;
import model.Usuario;
import util.DatasFormatadas;
import util.ScrollList;
import util.ScrollList.MouseAdapterNome;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaExercicios extends LayoutMain {

	private Usuario user = ControllerUsuario.getUsuarioLogado();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaExercicios window = new TelaExercicios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaExercicios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Exercicios - EzHealth");
		configureContent();
	}
		
	private void configureContent() {	
		DatasFormatadas dataFormatada = new DatasFormatadas(new Date()); 
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		JLabel labelNomeRefeicao = new JLabel("Exerc\u00EDcios");
		labelNomeRefeicao.setBounds(20, 11, 113, 30);
		labelNomeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelNomeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(labelNomeRefeicao);
		
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setBounds(20, 32, 163, 30);
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 902, 2);
		panel.add(separator);
		
		JTextField txtPesquisarExercicios = new JTextField();
		txtPesquisarExercicios.setEnabled(false);
		txtPesquisarExercicios.setText("Pesquise exerc\u00EDcios");
		txtPesquisarExercicios.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPesquisarExercicios.getText().equals("Pesquise exercícios")) {
					txtPesquisarExercicios.setText("");
					txtPesquisarExercicios.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtPesquisarExercicios.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPesquisarExercicios.getText().equals("Pesquise exercícios")) {
					txtPesquisarExercicios.setText("");
					txtPesquisarExercicios.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtPesquisarExercicios.setToolTipText("Pesquisar");
		txtPesquisarExercicios.setForeground(SystemColor.scrollbar);
		txtPesquisarExercicios.setColumns(10);
		txtPesquisarExercicios.setBounds(534, 117, 335, 35);
		panel.add(txtPesquisarExercicios);
		
		JLabel lblBuscarExerccios = new JLabel("Lista de Exerc\u00EDcios");
		lblBuscarExerccios.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarExerccios.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarExerccios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarExerccios.setBounds(534, 87, 157, 30);
		panel.add(lblBuscarExerccios);
		
		JLabel lblListaDeExerccios = new JLabel("Lista de Exerc\u00EDcios Realizados");
		lblListaDeExerccios.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeExerccios.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeExerccios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeExerccios.setBounds(20, 87, 212, 30);
		panel.add(lblListaDeExerccios);
		

		configureListExercicios(panel);
		configureListExerciciosRealizados(panel);
		
		frame.getContentPane().add(panel);
	}
	
	private void configureListExerciciosRealizados(JPanel panel){
		MouseAdapterNome btnEditar = (Model objModel) -> {
			try {
				PopupEditarExercicios.main((Exercicio) objModel);
				ControllerUsuario.editar();
				JOptionPane.showMessageDialog(null, "Exercicio atualizado");
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível encontrar o exercicio");
				e.printStackTrace();
			} catch (DadosVaziosException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar editar, exercicio com nome vazio");
				e1.printStackTrace();
			} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar editar");
				e1.printStackTrace();
			} catch (SenhaInvalidaException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar editar, senha de usuario inválida");
				e.printStackTrace();
			}
		};
		
		MouseAdapterNome btnExcluir = (Model objModel) -> {
			try {
				Exercicio exer = (Exercicio) objModel;
				user.decCaloriasGastas(exer.getCalorias());
				user.getListExercicio().remove(exer);
				
				ControllerUsuario.setUsuarioLogado(user);
				ControllerUsuario.editar();
				resetScreen(panel);
			} catch (DadosVaziosException e1) {
				JOptionPane.showMessageDialog(null, "Exercicio com nome vazio");
				e1.printStackTrace();
			} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover");
				e1.printStackTrace();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, exercicio não encontrado");
				e.printStackTrace();
			} catch (SenhaInvalidaException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, senha de usuario inválida");
				e.printStackTrace();
			}
		};
		
		
		ScrollList<Exercicio> listExerciciosRealizados = new ScrollList<Exercicio>();
		listExerciciosRealizados.setAdapterEditar(btnEditar);
		listExerciciosRealizados.setAdapterExcluir(btnExcluir);
		listExerciciosRealizados.getVerticalScrollBar().setUnitIncrement(4);
		listExerciciosRealizados.setBorder(BorderFactory.createEmptyBorder());
		listExerciciosRealizados.setBounds(20, 117, 466, 358);
		listExerciciosRealizados.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			List<Exercicio> list = ControllerUsuario.getUsuarioLogado().getListExercicio();
			System.out.println("eeeeeeeeeeeeeeeeee "+list.size());
			for(Exercicio e: list)
				if(e == null)
					System.out.println(" e is null");
				else
					System.out.println("aaaaaaaaaaaaaaaaaa "+e.getNome());
			
			listExerciciosRealizados.configureList(panel, list);
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} 
		
		panel.add(listExerciciosRealizados);
	}
	
	private void configureListExercicios(JPanel panel){
		MouseAdapterNome btnAdicionar = (Model objModel) -> {
			try {
				Exercicio exer = ((Exercicio) objModel).clone();
				
				exer.setId(null);
				exer.setData(new Date());
				if(user.getListExercicio()==null)
					user.setListExercicio(new ArrayList<>());
				user.getListExercicio().add(exer);
				
				user.addCaloriasGastas(exer.getCalorias());
				
				ControllerUsuario.setUsuarioLogado(user);
				ControllerUsuario.editar();
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Exercicio não encontrado");
				e.printStackTrace();
			} catch (DadosVaziosException e) {
				JOptionPane.showMessageDialog(null, "Exercicio com nome inválido");
				e.printStackTrace();
			} catch (OperacaoNaoConcluidaRepositorioExeception e) {
				JOptionPane.showMessageDialog(null, "Não foi possível adicionar exercicio a lista de realizados");
				e.printStackTrace();
			} catch (SenhaInvalidaException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível adicionar exercicio, senha de usuário inválida");
				e.printStackTrace();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		
		ScrollList<ExercicioPronto> listExercicios = new ScrollList<ExercicioPronto>();
		listExercicios.setAdapterAdicionar(btnAdicionar);
		listExercicios.getVerticalScrollBar().setUnitIncrement(4);
		listExercicios.setBorder(BorderFactory.createEmptyBorder());
		listExercicios.setBounds(534, 168, 336, 307);
		listExercicios.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			listExercicios.configureList(panel, ControllerExercicioPronto.buscarTodos());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} 
		panel.add(listExercicios);
	}
	
	private void resetScreen(JPanel panel) {
		for (Component compo : panel.getComponents()) 
			if(compo instanceof JScrollPane)
				panel.remove(compo);
		
		configureListExercicios(panel);
		configureListExerciciosRealizados(panel);
		
		frame.revalidate();
		frame.repaint();
	}
}

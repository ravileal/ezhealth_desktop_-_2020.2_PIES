package View;

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
import Controller.ControllerExercicios;
import Model.Exercicio;
import Util.DatasFormatadas;
import Util.ScrollList;
import Util.ScrollList.MouseAdapterNome;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaExercicios extends LayoutMain {

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
		MouseAdapterNome btnEditar = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				PopupEditarExercicios.main(null);
			}
		};
		
		MouseAdapterNome btnExcluir = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				try {
					new ControllerExercicios(true).remover(nome);
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Exercicio com nome vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar remover");
					e1.printStackTrace();
				}
				
				for (Component compo : panel.getComponents()) 
					if(compo instanceof JScrollPane)
						panel.remove(compo);
				
				configureListExercicios(panel);
				configureListExerciciosRealizados(panel);
				
				frame.revalidate();
				frame.repaint();
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
			listExerciciosRealizados.configureList(panel, new ControllerExercicios(true).buscar(null));
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Exercicio não encontrado");
			e1.printStackTrace();
		} catch (DadosVaziosException e1) {
			JOptionPane.showMessageDialog(null, "Exercicio com nome inválido");
			e1.printStackTrace();
		}
		panel.add(listExerciciosRealizados);
	}
	
	private void configureListExercicios(JPanel panel){
		MouseAdapterNome btnAdicionar = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				try {
					Exercicio obj = new ControllerExercicios(false).buscar(nome).get(0);
					
					new ControllerExercicios(true).adicionar(obj);
					
					for (Component compo : panel.getComponents()) {
						if(compo instanceof JScrollPane)
							panel.remove(compo);
					}
					configureListExercicios(panel);
					configureListExerciciosRealizados(panel);
					
					frame.revalidate();
					frame.repaint();
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Exercicio não encontrado");
					e.printStackTrace();
				} catch (DadosVaziosException e) {
					JOptionPane.showMessageDialog(null, "Exercicio com nome inválido");
					e.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e) {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar exercicio a lista de realizados");
					e.printStackTrace();
				}
			}
		};
		
		
		ScrollList<Exercicio> listExercicios = new ScrollList<Exercicio>();
		listExercicios.setAdapterAdicionar(btnAdicionar);
		listExercicios.getVerticalScrollBar().setUnitIncrement(4);
		listExercicios.setBorder(BorderFactory.createEmptyBorder());
		listExercicios.setBounds(534, 168, 336, 307);
		listExercicios.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			listExercicios.configureList(panel, new ControllerExercicios(false).buscar(null));
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Exercicio não encontrado");
			e1.printStackTrace();
		} catch (DadosVaziosException e1) {
			JOptionPane.showMessageDialog(null, "Exercicio com nome inválido");
			e1.printStackTrace();
		}
		panel.add(listExercicios);
	}
}

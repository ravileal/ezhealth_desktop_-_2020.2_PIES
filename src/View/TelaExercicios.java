package View;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Controller.ControllerAlimento;
import Controller.ControllerExercicios;
import Controller.ControllerRefeicao;
import Model.Alimento;
import Model.Exercicio;
import Model.Refeicao;
import Util.ViewUtils;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Window.Type;
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
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setBounds(20, 32, 92, 30);
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 902, 2);
		panel.add(separator);
		
		JTextField txtPesquisarExercicios = new JTextField();
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
		
		JLabel lblBuscarExerccios = new JLabel("Buscar Exerc\u00EDcios");
		lblBuscarExerccios.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarExerccios.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarExerccios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarExerccios.setBounds(534, 87, 157, 30);
		panel.add(lblBuscarExerccios);
		
		JLabel lblListaDeExerccios = new JLabel("Lista de Exerc\u00EDcios");
		lblListaDeExerccios.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeExerccios.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeExerccios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeExerccios.setBounds(20, 87, 157, 30);
		panel.add(lblListaDeExerccios);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		buttonSalvar.setBackground(Color.decode("#2F3542"));
		buttonSalvar.setForeground(new Color(255, 255, 255));
		buttonSalvar.setBounds(20, 448, 70, 22);
		panel.add(buttonSalvar);
		
		configureList(panel);
		frame.getContentPane().add(panel);
	}
	
	public void configureList(JPanel panel) {
		for (Component compo : panel.getComponents()) {
			if(compo instanceof JScrollPane)
				panel.remove(compo);
		}
		
		JPanel panel_refeicoes = new JPanel();
		panel_refeicoes.setLayout(new BoxLayout(panel_refeicoes, BoxLayout.Y_AXIS));
		panel_refeicoes.setBackground(Color.decode("#DFE4EA"));
		
		JScrollPane scrollPane = new JScrollPane(panel_refeicoes);
		scrollPane.getVerticalScrollBar().setUnitIncrement(4);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(20, 117, 453, 260);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_item = null;
		
		try {
			for (Exercicio a : new ControllerExercicios(false).buscar(null)) {
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 10));
				panel_item.setBackground(Color.decode("#DFE4EA"));
				panel_refeicoes.add(panel_item);
				
				panel_refeicoes.add(configureItemList(a.getNome(), panel));
				
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 10));
				panel_item.setBackground(Color.decode("#DFE4EA"));
				panel_refeicoes.add(panel_item);
				
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 1));
				panel_item.setBackground(Color.decode("#A4B0BE"));
				panel_refeicoes.add(panel_item);
			}
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Exercicio não encontrado");
			e.printStackTrace();
		} catch (DadosVaziosException e) {
			JOptionPane.showMessageDialog(null, "Exercicio com nome vazio");
			e.printStackTrace();
		}

		panel.add(scrollPane);
	}
	
	public Panel configureItemList(String nome, JPanel panel) {
		Panel panel_item = new Panel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.setPreferredSize(new Dimension(0, 50));
		panel_item.setBackground(Color.decode("#DFE4EA"));
		
	
		// configurações da label
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(new JLabel(nome));
		panel_item.add(Box.createVerticalStrut(10)); 
		
		// configurações dos botões
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		new ViewUtils().setImageInLabel("/Images/edit.png", botaoEditar(nome), panel_item);
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		new ViewUtils().setImageInLabel("/Images/remove.png", botaoExcluir(nome, panel), panel_item);
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		
		return panel_item;
	}

	
	public JLabel botaoEditar(String nome) {

		JLabel botaoEditar = new JLabel();
		botaoEditar.setSize(20, 20);
		botaoEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PopupEditarExercicios.main(null);
			}
		});
		return botaoEditar;
	}

	public JLabel botaoExcluir(String nome, JPanel panel) {

		JLabel botaoExcluir = new JLabel();
		botaoExcluir.setSize(20, 20);
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new ControllerExercicios(false).remover(nome);
					configureList(panel);
					frame.revalidate();
					frame.repaint();
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Algum campo está vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir exercicio");
					e1.printStackTrace();
				}
			}
		});
		return botaoExcluir;
	}
}

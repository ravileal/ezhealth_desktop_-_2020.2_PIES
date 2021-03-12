package View;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import Controller.ControllerAlimento;
import Model.Alimento;
import Util.DatasFormatadas;
import Util.ViewUtils;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaCriarRefeicoesPersonalizadas extends LayoutMain {

	private JScrollPane scrollPane = null;
	private JTextField txtNomeRefeicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaCriarRefeicoesPersonalizadas window = new TelaCriarRefeicoesPersonalizadas();
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
	public TelaCriarRefeicoesPersonalizadas() {
		initialize();
	}

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
		
		JLabel labelRefeicoesPersonalizadas = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		labelRefeicoesPersonalizadas.setBounds(20, 11, 272, 30);
		labelRefeicoesPersonalizadas.setVerticalAlignment(SwingConstants.TOP);
		labelRefeicoesPersonalizadas.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoesPersonalizadas.setFont(new Font("Quicksand", Font.PLAIN, 16));
		panel.add(labelRefeicoesPersonalizadas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 902, 2);
		panel.add(separator);
		
		JTextField txtPesquisarAlimentos = new JTextField();
		txtPesquisarAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtPesquisarAlimentos.setText("Adicione alimentos na refei\u00E7\u00E3o");
		txtPesquisarAlimentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPesquisarAlimentos.getText().equals("Adicione alimentos na refeição")) {
					txtPesquisarAlimentos.setText("");
					txtPesquisarAlimentos.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtPesquisarAlimentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPesquisarAlimentos.getText().equals("Adicione alimentos na refeição")) {
					txtPesquisarAlimentos.setText("");
					txtPesquisarAlimentos.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setForeground(Color.LIGHT_GRAY);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(534, 86, 335, 30);
		panel.add(txtPesquisarAlimentos);
		
		JLabel lblBuscarAlimentos = new JLabel("Buscar Alimentos");
		lblBuscarAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblBuscarAlimentos.setBounds(534, 63, 157, 30);
		panel.add(lblBuscarAlimentos);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(20, 133, 157, 30);
		panel.add(lblListaDeAlimentos);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(Color.decode("#2F3542"));
		buttonSalvar.setForeground(new Color(255, 255, 255));
		buttonSalvar.setBounds(20, 448, 70, 22);
		panel.add(buttonSalvar);
		
		configureList(panel);
		frame.getContentPane().add(panel);
		
		
		txtNomeRefeicao = new JTextField();
		txtNomeRefeicao.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtNomeRefeicao.setForeground(Color.LIGHT_GRAY);
		txtNomeRefeicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNomeRefeicao.getText().equals("Digite o nome da refeição")) {
					txtNomeRefeicao.setText("");
					txtNomeRefeicao.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtNomeRefeicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNomeRefeicao.getText().equals("Digite o nome da refeição")) {
					txtNomeRefeicao.setText("");
					txtNomeRefeicao.setForeground(new Color (153, 153, 153));
				}
			}
		});
		txtNomeRefeicao.setText("Digite o nome da refei\u00E7\u00E3o");
		txtNomeRefeicao.setBounds(20, 89, 453, 30);
		panel.add(txtNomeRefeicao);
		txtNomeRefeicao.setColumns(10);
		
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelData.setBounds(20, 33, 107, 30);
		panel.add(labelData);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBackground(Color.decode("#2F3542"));
		buttonVoltar.setForeground(new Color(255, 255, 255));
		buttonVoltar.setBounds(827, 19, 70, 22);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		panel.add(buttonVoltar);
		
		JLabel lblBuscarRefeio = new JLabel("Buscar refei\u00E7\u00E3o");
		lblBuscarRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarRefeio.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblBuscarRefeio.setBounds(20, 68, 157, 30);
		panel.add(lblBuscarRefeio);
	}
	
	public void configureList(JPanel panel) {
		for (Component compo : panel.getComponents()) {
			if(compo instanceof JScrollPane)
				panel.remove(compo);
		}
		
		JPanel panel_alimentos = new JPanel();
		panel_alimentos.setLayout(new BoxLayout(panel_alimentos, BoxLayout.Y_AXIS));
		panel_alimentos.setBackground(Color.decode("#DFE4EA"));
		
		JScrollPane scrollPane = new JScrollPane(panel_alimentos);
		scrollPane.getVerticalScrollBar().setUnitIncrement(4);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(20, 163, 453, 260);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_item = null;
		
		try {
			for (Alimento a : new ControllerAlimento().buscar(null)) {
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 10));
				panel_item.setBackground(Color.decode("#DFE4EA"));
				panel_alimentos.add(panel_item);
				
				panel_alimentos.add(configureItemList(a.getNome(), panel));
				
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 10));
				panel_item.setBackground(Color.decode("#DFE4EA"));
				panel_alimentos.add(panel_item);
				
				panel_item = new JPanel();
				panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
				panel_item.setMaximumSize(new Dimension(scrollPane.getWidth(), 1));
				panel_item.setBackground(Color.decode("#A4B0BE"));
				panel_alimentos.add(panel_item);
			}
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Alimento não encontrado");
			e.printStackTrace();
		} catch (DadosVaziosException e) {
			JOptionPane.showMessageDialog(null, "Alimento com nome vazio");
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
				PopupEditarAlimentos.main(null);
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
					new ControllerAlimento().remover(nome);
					configureList(panel);
					frame.revalidate();
					frame.repaint();
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Algum campo está vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir alimento");
					e1.printStackTrace();
				}
			}
		});
		return botaoExcluir;
	}
}

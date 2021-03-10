package View;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import Controller.ControllerAlimento;
import Model.Alimento;
import Util.ViewUtils;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;

public class TelaEditarRefeicaoPersonalizada extends LayoutMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaEditarRefeicaoPersonalizada window = new TelaEditarRefeicaoPersonalizada();
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
	public TelaEditarRefeicaoPersonalizada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Editar Refeição - EzHealth");
		configureContent();
	}

	private void configureContent() {
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		JLabel lblMinhaRefeio = new JLabel("Minha Refei\u00E7\u00E3o 1");
		lblMinhaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblMinhaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinhaRefeio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMinhaRefeio.setBounds(20, 11, 177, 30);
		panel.add(lblMinhaRefeio);

		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(21, 32, 92, 30);
		panel.add(labelData);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 902, 10);
		panel.add(separator);


		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(542, 73, 354, 30);
		panel.add(lblAdicionarAlimentosNa);

		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(829, 19, 70, 22);
		panel.add(buttonVoltar);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(20, 449, 70, 22);
		panel.add(buttonSalvar);

		JTextField textField = new JTextField();
		textField.setToolTipText("Pesquisar");
		textField.setText("Pesquisar Alimentos/Refei\u00E7\u00F5es");
		textField.setForeground(SystemColor.scrollbar);
		textField.setColumns(10);
		textField.setBounds(542, 125, 335, 35);
		panel.add(textField);

		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(21, 84, 141, 30);
		panel.add(lblListaDeAlimentos);
		
		configureListAlimentos(panel);
		
		frame.getContentPane().add(panel);
	}

	public void configureListAlimentos(JPanel panel) {
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
		scrollPane.setBounds(20, 125, 453, 260);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_item = null;
		
		try {
			for (Alimento a : new ControllerAlimento().buscar(null)) {
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
			JOptionPane.showMessageDialog(null, "Nenhum alimento na refeição");
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
				TelaEditarAlimentos.main(null);
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
					configureListAlimentos(panel);
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

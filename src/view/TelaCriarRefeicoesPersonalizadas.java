package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ControllerAlimentoPronto;
import controller.ControllerUsuario;
import model.Alimento;
import model.AlimentoPronto;
import model.Exercicio;
import model.Model;
import model.Refeicao;
import model.Usuario;
import util.CRUD;
import util.DatasFormatadas;
import util.ScrollList;
import util.ViewUtils;
import util.ScrollList.MouseAdapterNome;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;
import validation.UsuarioDuplicadoException;

import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaCriarRefeicoesPersonalizadas extends LayoutMain {

	private Refeicao refeicao;

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
		refeicao = new Refeicao();
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
		
		JTextField txtPesquisarAlimentos = new JTextField() {
			@Override
			protected void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				if(!(getText().isEmpty() && 
				   !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)))
					return;
					
				Graphics2D graphics2D = (Graphics2D)graphics.create();
				graphics2D.setFont(getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT));
		        graphics2D.setColor(Color.GRAY);
		        graphics2D.drawString("Digite o nome do alimento", 5, 20); 
		        graphics2D.dispose();
			}
		};
		txtPesquisarAlimentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				frame.revalidate();
				frame.repaint();
			}
		});        
        txtPesquisarAlimentos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtPesquisarAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setForeground(Color.black);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(534, 89, 335, 30);
		
		panel.add(txtPesquisarAlimentos);
		
		JLabel lblBuscarAlimentos = new JLabel("Buscar Alimentos");
		lblBuscarAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblBuscarAlimentos.setBounds(534, 63, 157, 30);
		panel.add(lblBuscarAlimentos);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos da Refei\u00E7\u00E3o");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(20, 133, 222, 30);
		panel.add(lblListaDeAlimentos);
		
		frame.getContentPane().add(panel);
		
		JTextField txtNomeRefeicao = new JTextField() {
			@Override
			protected void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				if(!(getText().isEmpty() && 
				   !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)))
					return;
				Graphics2D graphics2D = (Graphics2D)graphics.create();
				graphics2D.setFont(getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT));
				graphics2D.setColor(Color.GRAY);
				graphics2D.drawString("Digite o nome da refeição", 5, 20);
				graphics2D.dispose();
			}
		};
		txtNomeRefeicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				frame.revalidate();
				frame.repaint();
			}
		});
		txtNomeRefeicao.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtNomeRefeicao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNomeRefeicao.setForeground(Color.black);
		txtNomeRefeicao.setBounds(20, 89, 466, 30);
		txtNomeRefeicao.setColumns(10);		
		
		panel.add(txtNomeRefeicao);
		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Usuario user = ControllerUsuario.getUsuarioLogado();
					
					refeicao.setId(null);
					refeicao.setData(new Date());	
					refeicao.setNome(txtNomeRefeicao.getText());
					
					if(user.getListRefeicao() == null)
						user.setListRefeicao(new ArrayList<>());
					
					user.getListRefeicao().add(refeicao);
					user.addCaloriasConsumidas(refeicao.getCalorias());
					ControllerUsuario.editar();
					
					JOptionPane.showMessageDialog(null, "Refeição cadastrada");
					frame.dispose();
					TelaRefeicoesPersonalizadas.main(null);
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Refeicao não encontrada");
					e1.printStackTrace();
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Refeicao com nome vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possivel salvar a refeição");
					e1.printStackTrace();
				} catch (SenhaInvalidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonSalvar.setBorder(BorderFactory.createEmptyBorder());
		buttonSalvar.setBackground(Color.decode("#2F3542"));
		buttonSalvar.setForeground(new Color(255, 255, 255));
		buttonSalvar.setBounds(20, 453, 70, 22);
		panel.add(buttonSalvar);
		
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelData.setBounds(20, 33, 107, 30);
		panel.add(labelData);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		buttonVoltar.setBorder(BorderFactory.createEmptyBorder());
		buttonVoltar.setBackground(Color.decode("#2F3542"));
		buttonVoltar.setForeground(new Color(255, 255, 255));
		buttonVoltar.setBounds(827, 19, 70, 22);
		panel.add(buttonVoltar);
		
		JLabel lblBuscarRefeio = new JLabel("Digite o nome da refei\u00E7\u00E3o");
		lblBuscarRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarRefeio.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblBuscarRefeio.setBounds(20, 68, 204, 30);
		panel.add(lblBuscarRefeio);
		
		configureListAlimentos(panel);
		configureListAlimentosRefeicao(panel);
	}
	
	private void configureListAlimentos(JPanel panel){
		MouseAdapterNome btnAdicionar = (Model objModel) -> {
			try {					
				Alimento ali = ((Alimento) objModel).clone();				
				ali.setId(null);
				refeicao.setData(new Date());
				refeicao.addAlimento(ali);
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível adicionar refeicao. Refeicao null");
				e.printStackTrace();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		
		ScrollList<AlimentoPronto> list = new ScrollList<AlimentoPronto>();
		list.setAdapterAdicionar(btnAdicionar);
		list.getVerticalScrollBar().setUnitIncrement(4);
		list.setBorder(BorderFactory.createEmptyBorder());
		list.setBounds(534, 168, 336, 307);
		list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list.configureList(panel, ControllerAlimentoPronto.buscarTodos());
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Lista de alimentos vazia");
			e1.printStackTrace();
		} 
		panel.add(list);
	}
	
	private void configureListAlimentosRefeicao(JPanel panel){
		MouseAdapterNome btnEditar = (Model objModel) -> {
			try {
				PopupEditarAlimentos.main((Alimento) objModel);
				refeicao.setAlimento((Alimento) objModel);
				JOptionPane.showMessageDialog(null, "Alimento atualizado");
				resetScreen(panel);
			}  catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível editar refeicao. Refeicao null");
				e.printStackTrace();
			} catch (DadosVaziosException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível editar refeicao. Refeicao com nome inválido");
				e.printStackTrace();
			} 
		};
		
		MouseAdapterNome btnExcluir = (Model objModel) -> {
			try {
				refeicao.delAlimento((Alimento) objModel);
				resetScreen(panel);
			}  catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir refeicao. Refeicao null");
				e.printStackTrace();
			}
		};
		
		
		ScrollList<Alimento> list_2 = new ScrollList<Alimento>();
		list_2.setAdapterEditar(btnEditar);
		list_2.setAdapterExcluir(btnExcluir);
		list_2.getVerticalScrollBar().setUnitIncrement(4);
		list_2.setBorder(BorderFactory.createEmptyBorder());
		list_2.setBounds(20, 168, 466, 274);
		list_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list_2.configureList(panel, refeicao.getListAlimento());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} 
		panel.add(list_2);
	}
	
	private void resetScreen(JPanel panel) {
		for (Component compo : panel.getComponents()) 
			if(compo instanceof JScrollPane)
				panel.remove(compo);
		
		configureListAlimentos(panel);
		configureListAlimentosRefeicao(panel);
		
		frame.revalidate();
		frame.repaint();
	}
	
}

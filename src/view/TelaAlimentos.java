package view;

import java.awt.EventQueue;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;

import controller.ControllerAlimentoPronto;
import controller.ControllerUsuario;
import model.Alimento;
import model.AlimentoPronto;
import model.Model;
import model.Refeicao;
import model.Usuario;
import util.DatasFormatadas;
import util.ScrollList;
import util.ViewUtils;
import util.ScrollList.MouseAdapterNome;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaAlimentos extends LayoutMain {
	
	private Refeicao refeicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaAlimentos window = new TelaAlimentos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(Refeicao refeicao) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaAlimentos window = new TelaAlimentos(refeicao);
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
	public TelaAlimentos() {
		initialize();
	}

	private TelaAlimentos(Refeicao refeicao) {
		try {
			this.refeicao = refeicao;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Refeiçao nula");
			e.printStackTrace();
			frame.dispose();
		}
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Tela Alimentos - EzHealth");
		configureContent();
	}
		
	private void configureContent() {
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel lblMinhaRefeio = new JLabel(refeicao.getNome());
		lblMinhaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblMinhaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinhaRefeio.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblMinhaRefeio.setBounds(20, 11, 341, 30);
		panel.add(lblMinhaRefeio);

		DatasFormatadas dataFormatada = new DatasFormatadas(refeicao.getData());
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelData.setBounds(21, 32, 253, 30);
		panel.add(labelData);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 902, 10);
		panel.add(separator);


		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(535, 73, 412, 30);
		panel.add(lblAdicionarAlimentosNa);

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome.main(null);
				frame.dispose();
			}
		});
		buttonVoltar.setBackground(Color.decode("#2F3542"));
		buttonVoltar.setForeground(new Color(255, 255, 255));
		buttonVoltar.setBounds(829, 19, 70, 22);
		buttonVoltar.setBorder(BorderFactory.createEmptyBorder());
		panel.add(buttonVoltar);

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
		txtPesquisarAlimentos.setBounds(535, 96, 335, 30);
		panel.add(txtPesquisarAlimentos);

		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(20, 73, 141, 30);
		panel.add(lblListaDeAlimentos);
		
		configureListAlimentos(panel);
		configureListAlimentosRefeicao(panel);
	}

	private void configureListAlimentos(JPanel panel){
		MouseAdapterNome btnAdicionar = (Model objModel) -> {
			try {					
				refeicao.setData(new Date());
				refeicao.addAlimento((Alimento) objModel);
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível atualizar alimento. Alimento null");
				e.printStackTrace();
			} 
		};
		
		
		ScrollList<AlimentoPronto> list = new ScrollList<AlimentoPronto>();
		list.setAdapterAdicionar(btnAdicionar);
		list.getVerticalScrollBar().setUnitIncrement(4);
		list.setBorder(BorderFactory.createEmptyBorder());
		list.setBounds(534, 151, 336, 324);
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
		MouseAdapterNome btnEditar =  (Model objModel) -> {
			try {
				PopupEditarAlimentos.main((Alimento) objModel);
				JOptionPane.showMessageDialog(null, "Alimento atualizado");
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível atualizar alimento. Alimento null");
				e.printStackTrace();
			}
		};
		
		MouseAdapterNome btnExcluir = (Model objModel) -> {
			try {
				refeicao.delAlimento((Alimento) objModel);
				resetScreen(panel);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível excluir alimento. Alimento null");
				e.printStackTrace();
			} 
		};
		
		
		ScrollList<Alimento> list_2 = new ScrollList<Alimento>();
		list_2.setAdapterEditar(btnEditar);
		list_2.setAdapterExcluir(btnExcluir);
		list_2.getVerticalScrollBar().setUnitIncrement(4);
		list_2.setBorder(BorderFactory.createEmptyBorder());
		list_2.setBounds(20, 100, 466, 375);
		list_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list_2.configureList(panel, refeicao.getListAlimento());
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Lista de alimentos vazia");
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

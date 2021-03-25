package View;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.FocusManager;
import javax.swing.JButton;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import Controller.ControllerAlimento;
import Controller.ControllerRefeicao;
import Model.Alimento;
import Model.Refeicao;
import Util.DatasFormatadas;
import Util.ScrollList;
import Util.ViewUtils;
import Util.ScrollList.MouseAdapterNome;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarRefeicaoPersonalizada extends LayoutMain {

	private Refeicao refeicao;
	
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
	
	public static void main(String nome) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaEditarRefeicaoPersonalizada window = new TelaEditarRefeicaoPersonalizada(nome);
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

	private TelaEditarRefeicaoPersonalizada(String nome) {
		try {
			refeicao = new ControllerRefeicao(true).buscar(nome).get(0);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Refeição não encontrada");
			e.printStackTrace();
		} catch (DadosVaziosException e) {
			JOptionPane.showMessageDialog(null, "Nome da refeição está vazio");
			e.printStackTrace();
		} 
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
		
		frame.getContentPane().add(panel);
		
		JLabel lblMinhaRefeio = new JLabel("Minha Refei\u00E7\u00E3o 1");
		lblMinhaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblMinhaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinhaRefeio.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblMinhaRefeio.setBounds(20, 11, 177, 30);
		panel.add(lblMinhaRefeio);

		DatasFormatadas dataFormatada = new DatasFormatadas(new Date());
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelData.setBounds(21, 32, 92, 30);
		panel.add(labelData);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 902, 10);
		panel.add(separator);


		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(541, 73, 412, 30);
		panel.add(lblAdicionarAlimentosNa);

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaRefeicoesPersonalizadas.main(null);
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
		lblListaDeAlimentos.setBounds(20, 137, 141, 30);
		panel.add(lblListaDeAlimentos);
		
		
		
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
		txtNomeRefeicao.setText(refeicao.getNome());
		txtNomeRefeicao.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtNomeRefeicao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNomeRefeicao.setForeground(Color.black);
		txtNomeRefeicao.setBounds(20, 96, 412, 30);
		txtNomeRefeicao.setColumns(10);	
		panel.add(txtNomeRefeicao);
		
		JLabel lblAlterarNome = new JLabel("Alterar nome da refei\u00E7\u00E3o:");
		lblAlterarNome.setVerticalAlignment(SwingConstants.TOP);
		lblAlterarNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlterarNome.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAlterarNome.setBounds(20, 73, 197, 30);
		panel.add(lblAlterarNome);
		
		configureListAlimentos(panel);
		configureListAlimentosRefeicao(panel);
		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Refeicao obj = refeicao;
					obj.setNome(txtNomeRefeicao.getText());
					new ControllerRefeicao(true).editar(refeicao.getNome(), obj);
					JOptionPane.showMessageDialog(null, "Refeição atualizada");
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
				}
			}
		});
		buttonSalvar.setForeground(Color.WHITE);
		buttonSalvar.setBackground(new Color(47, 53, 66));
		buttonSalvar.setBounds(441, 96, 45, 30);
		buttonSalvar.setBorder(BorderFactory.createEmptyBorder());
		panel.add(buttonSalvar);
	}

	private void configureListAlimentos(JPanel panel){
		MouseAdapterNome btnAdicionar = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				try {
					Alimento obj = new ControllerAlimento().buscar(nome).get(0);
					refeicao.addAlimento(obj);
					
					for (Component compo : panel.getComponents()) {
						if(compo instanceof JScrollPane)
							panel.remove(compo);
					}
					configureListAlimentos(panel);
					configureListAlimentosRefeicao(panel); 
					
					frame.revalidate();
					frame.repaint();
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Alimento não encontrado");
					e.printStackTrace();
				} catch (DadosVaziosException e) {
					JOptionPane.showMessageDialog(null, "Alimento com nome inválido");
					e.printStackTrace();
				}
			}
		};
		
		
		ScrollList<Alimento> list = new ScrollList<Alimento>();
		list.setAdapterAdicionar(btnAdicionar);
		list.getVerticalScrollBar().setUnitIncrement(4);
		list.setBorder(BorderFactory.createEmptyBorder());
		list.setBounds(534, 168, 336, 307);
		list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list.configureList(panel, new ControllerAlimento().buscar(null));
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Alimento não encontrado");
			e1.printStackTrace();
		} catch (DadosVaziosException e1) {
			JOptionPane.showMessageDialog(null, "Alimento com nome inválido");
			e1.printStackTrace();
		}
		panel.add(list);
	
	}
	
	
	private void configureListAlimentosRefeicao(JPanel panel){
		MouseAdapterNome btnEditar = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				for(Alimento obj: refeicao.getListAlimento())
					if(obj.getNome().equals(nome))
						PopupEditarAlimentos.main(obj);
			}
		};
		
		MouseAdapterNome btnExcluir = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				for(Alimento obj: refeicao.getListAlimento())
					if(obj.getNome().equals(nome)) {
						refeicao.delAlimento(obj);
						break;
					}
				
				for (Component compo : panel.getComponents()) 
					if(compo instanceof JScrollPane)
						panel.remove(compo);
				
				configureListAlimentos(panel);
				configureListAlimentosRefeicao(panel);
				
				frame.revalidate();
				frame.repaint();
			}
		};
		
		
		ScrollList<Alimento> list_2 = new ScrollList<Alimento>();
		list_2.setAdapterEditar(btnEditar);
		list_2.setAdapterExcluir(btnExcluir);
		list_2.getVerticalScrollBar().setUnitIncrement(4);
		list_2.setBorder(BorderFactory.createEmptyBorder());
		list_2.setBounds(20, 168, 466, 307);
		list_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list_2.configureList(panel, refeicao.getListAlimento());
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Alimento não encontrado");
			e1.printStackTrace();
		} 
		panel.add(list_2);
	}
}

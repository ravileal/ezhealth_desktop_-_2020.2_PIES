package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.ControllerAlimento;
import Model.Alimento;
import Validation.DadosVaziosException;
import Validation.ImpossivelAdicionarRepositorioExeception;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.Scrollbar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class TelaAlimentos {

	private JFrame frame;
	private JTextField txtPesquise;
	private JPanel panel_alimentos = null;
	private JScrollPane scrollPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Create the application.
	 */
	public TelaAlimentos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 0, 1014, 73);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		frame.getContentPane().add(panel_1);
		
		Panel panel = new Panel();
		panel.setBounds(0, 73, 119, 474);
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHome.setBounds(10, 33, 63, 27);
		panel.add(labelHome);
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaHome().main(null);
			}
		});
		
		JLabel labelRefeicoes = new JLabel("Refei\u00E7\u00F5es ");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRefeicoes.setBounds(10, 59, 144, 35);
		panel.add(labelRefeicoes);
		labelRefeicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaCriarRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel labelPersonalizadas = new JLabel("Personalizadas");
		labelPersonalizadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPersonalizadas.setBounds(10, 80, 86, 27);
		panel.add(labelPersonalizadas);
		labelPersonalizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);
		
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelExercicios.setBounds(10, 106, 144, 35);
		panel.add(labelExercicios);
		labelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaExercicios().main(null);
			}
		});
		
		JLabel labelMeusDados = new JLabel("Meus Dados");
		labelMeusDados.setHorizontalAlignment(SwingConstants.LEFT);
		labelMeusDados.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelMeusDados.setBounds(10, 136, 144, 35);
		panel.add(labelMeusDados);
		
		JLabel labelSair = new JLabel("Sair");
		labelSair.setHorizontalAlignment(SwingConstants.LEFT);
		labelSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSair.setBounds(10, 170, 144, 35);
		panel.add(labelSair);
		labelSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JLabel labelNomeRefeicao = new JLabel("Caf\u00E9 da Manh\u00E3");
		labelNomeRefeicao.setBounds(136, 91, 113, 30);
		labelNomeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelNomeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelNomeRefeicao);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setBounds(136, 112, 92, 30);
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 153, 872, 2);
		frame.getContentPane().add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBounds(908, 101, 70, 22);
		buttonVoltar.setBackground(SystemColor.control);
		frame.getContentPane().add(buttonVoltar);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaHome().main(null);
			}
		});
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setBounds(136, 181, 141, 30);
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblListaDeAlimentos);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBounds(136, 503, 70, 22);
		buttonSalvar.setBackground(SystemColor.menu);
		frame.getContentPane().add(buttonSalvar);
		
		JLabel lblAdicionarAlimentos = new JLabel("Adicionar Alimentos ou Refei\u00E7\u00F5es Personalizadas");
		lblAdicionarAlimentos.setBounds(643, 181, 354, 30);
		lblAdicionarAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblAdicionarAlimentos);
		
		txtPesquise = new JTextField();
		txtPesquise.setBounds(643, 231, 335, 35);
		txtPesquise.setForeground(SystemColor.scrollbar);
		txtPesquise.setToolTipText("Pesquisar");
		txtPesquise.setText("Pesquisar Alimentos/Refei\u00E7\u00F5es");
		frame.getContentPane().add(txtPesquise);
		txtPesquise.setColumns(10);
		
		JLabel lblUltimasPesquisas = new JLabel("Ultimas pesquisas");
		lblUltimasPesquisas.setBounds(643, 308, 354, 30);
		lblUltimasPesquisas.setVerticalAlignment(SwingConstants.TOP);
		lblUltimasPesquisas.setHorizontalAlignment(SwingConstants.LEFT);
		lblUltimasPesquisas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblUltimasPesquisas);
		
		criarPainelAlimentos();
		
	}
	
	public void criarPainelAlimentos() {
		
		if(scrollPane != null) {
			frame.getContentPane().remove(scrollPane);
		}
		
		this.panel_alimentos = new JPanel();
		panel_alimentos.setLayout(new BoxLayout(panel_alimentos, BoxLayout.Y_AXIS));
		
//		for (Alimento a : new ControllerAlimento().buscar("")) {
		panel_alimentos.add(Box.createRigidArea(new Dimension(0, 10)));
		JPanel panel_item = new JPanel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.add(new JLabel("Laranja"));
		panel_item.add(botaoEditar("Laranja"));
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(botaoExcluir("Laranja"));
		panel_alimentos.add(panel_item);
//        }
		
		this.scrollPane = new JScrollPane(panel_alimentos);
		scrollPane.setBounds(136, 222, 461, 260);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.getContentPane().add(scrollPane);
		frame.revalidate();
		
	}
	
	public JButton botaoEditar(String nome) {
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new TelaExercicios().main(null);
				}
			}
		);
		return botaoEditar;
	}
	
	public JButton botaoExcluir(String nome) {
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						new ControllerAlimento().remover(nome);
					} catch (DadosVaziosException e1) {
						JOptionPane.showMessageDialog(null, e1);
						e1.printStackTrace();
					} catch (ImpossivelAdicionarRepositorioExeception e1) {
						JOptionPane.showMessageDialog(null, e1);
						e1.printStackTrace();
					}
					criarPainelAlimentos();
				}
			}
		);
		return botaoExcluir;
	}
	
	
}

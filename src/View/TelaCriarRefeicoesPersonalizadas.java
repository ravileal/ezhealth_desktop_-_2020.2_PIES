package View;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Controller.ControllerAlimento;
import Util.ViewUtils;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class TelaCriarRefeicoesPersonalizadas {

	private JFrame frame;
	private JTextField txtPesquisarAlimentos;
	private JTextField txtEditarNomeRefeio;
	private JPanel panel_refeicoes = null;
	private JScrollPane scrollPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1058, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setTitle("Home - EzHealth");
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		frame.setContentPane(panel_1);
		panel_1.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#2F3542"));
		panel.setBounds(0, 0, 1058, 87);
		frame.getContentPane().add(panel);
		panel.setLayout(null);	
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF");
		
		JLabel lblImgHospital = new JLabel(""); 
		lblImgHospital.setBounds(43, 24, 52, 51);
		
		new ViewUtils().setImageInLabel("/Images/hospital.png", lblImgHospital, panel);
		
		JLabel lblNewLabel_title = new JLabel("EZHEALTH");
		lblNewLabel_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_title.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_title.setBounds(112, 37, 96, 25);
		panel.add(lblNewLabel_title);
		
		JLabel lblImgMinhaConta = new JLabel(""); 
		lblImgMinhaConta.setBounds(930, 29, 39, 40);
		
		new ViewUtils().setImageInLabel("/Images/accountWhite.png", lblImgMinhaConta, panel);
		
		JLabel lblNewLabel_minhaConta = new JLabel("<html>Minha<br>Conta</html>");
		lblNewLabel_minhaConta.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		lblNewLabel_minhaConta.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_minhaConta.setBounds(978, 24, 70, 51);
		panel.add(lblNewLabel_minhaConta);
		
		Panel panel_menu = new Panel();
		panel_menu.setBackground(Color.decode("#A4B0BE"));
		panel_menu.setBounds(0, 82, 136, 521);
		frame.getContentPane().add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// código para atualizar a tela
			}
		});
		
		JLabel lblImgHome = new JLabel(""); 
		lblImgHome.setBounds(10, 70, 19, 18);
		new ViewUtils().setImageInLabel("/Images/restaurant.png", lblImgHome, panel_menu);
		
		labelHome.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelHome.setBounds(36, 33, 87, 27);
		panel_menu.add(labelHome);
		
		JLabel labelRefeicoes = new JLabel("<html>Refei\u00E7\u00F5es <br> Personalizadas</html>");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelRefeicoes.setBounds(36, 65, 98, 35);
		panel_menu.add(labelRefeicoes);
		labelRefeicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel lblImgRefeicao = new JLabel(""); 
		lblImgRefeicao.setBounds(10, 115, 19, 18);
		new ViewUtils().setImageInLabel("/Images/fitness.png", lblImgRefeicao, panel_menu);
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel_menu.add(lblNewLabel_7);
		
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelExercicios.setBounds(36, 106, 87, 35);
		panel_menu.add(labelExercicios);
		labelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaExercicios().main(null);
			}
		});
		
		
		JLabel lblImgExercicio = new JLabel(""); 
		lblImgExercicio.setBounds(10, 36, 19, 18);
		new ViewUtils().setImageInLabel("/Images/home.png", lblImgExercicio, panel_menu);
		
		
		JLabel lblNewLabel_7_1 = new JLabel("Mais op\u00E7\u00F5es");
		lblNewLabel_7_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7_1.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_7_1.setBounds(10, 151, 124, 30);
		panel_menu.add(lblNewLabel_7_1);
		
		
		JLabel labelMeusDados = new JLabel("Meus Dados");
		labelMeusDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaMeusDados().main(null);
			}
		});
		labelMeusDados.setHorizontalAlignment(SwingConstants.LEFT);
		labelMeusDados.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelMeusDados.setBounds(36, 177, 87, 35);
		panel_menu.add(labelMeusDados);
		
		JLabel lblImgMeusDados = new JLabel(""); 
		lblImgMeusDados.setBounds(10, 184, 19, 18);
		new ViewUtils().setImageInLabel("/Images/account.png", lblImgMeusDados, panel_menu);
		
		JLabel labelSair = new JLabel("Sair");
		labelSair.setHorizontalAlignment(SwingConstants.LEFT);
		labelSair.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelSair.setBounds(36, 211, 87, 35);
		labelSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_menu.add(labelSair);
		
		JLabel lblImgSair = new JLabel(""); 
		lblImgSair.setBounds(10, 218, 19, 18);
		new ViewUtils().setImageInLabel("/Images/exit.png", lblImgSair, panel_menu);
		
		JLabel lblCriarNovaRefeio = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		lblCriarNovaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblCriarNovaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriarNovaRefeio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCriarNovaRefeio.setBounds(173, 105, 253, 30);
		frame.getContentPane().add(lblCriarNovaRefeio);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(945, 115, 70, 22);
		frame.getContentPane().add(buttonVoltar);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas().main(null);
			}
		});
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(162, 167, 872, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(661, 192, 354, 30);
		frame.getContentPane().add(lblAdicionarAlimentosNa);
		
		txtPesquisarAlimentos = new JTextField();
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setText("Pesquisar Alimentos");
		txtPesquisarAlimentos.setForeground(SystemColor.scrollbar);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(680, 245, 335, 35);
		frame.getContentPane().add(txtPesquisarAlimentos);
	
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(162, 557, 70, 22);
		frame.getContentPane().add(buttonSalvar);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(162, 192, 141, 30);
		frame.getContentPane().add(lblListaDeAlimentos);
		
		
		txtEditarNomeRefeio = new JTextField();
		txtEditarNomeRefeio.setToolTipText("Pesquisar");
		txtEditarNomeRefeio.setText("Editar nome refei\u00E7\u00E3o");
		txtEditarNomeRefeio.setForeground(SystemColor.scrollbar);
		txtEditarNomeRefeio.setColumns(10);
		txtEditarNomeRefeio.setBounds(173, 134, 241, 22);
		frame.getContentPane().add(txtEditarNomeRefeio);
		
		criarPainelRefeicoes();
		
	}
	
	public void criarPainelRefeicoes() {
		
		if(scrollPane != null) {
			frame.getContentPane().remove(scrollPane);
		}
		
		this.panel_refeicoes = new JPanel();
		panel_refeicoes.setLayout(new BoxLayout(panel_refeicoes, BoxLayout.Y_AXIS));
		
//		for (Alimento a : new ControllerAlimento().buscar("")) {
		panel_refeicoes.add(Box.createRigidArea(new Dimension(0, 10)));
		JPanel panel_item = new JPanel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.add(new JLabel("Laranja"));
		panel_item.add(botaoEditar("Laranja"));
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(botaoExcluir("Laranja"));
		panel_refeicoes.add(panel_item);
//        }
		
		this.scrollPane = new JScrollPane(panel_refeicoes);
		scrollPane.setBounds(162, 247, 467, 260);
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
						JOptionPane.showMessageDialog(null, "Algum campo está vazio");
						e1.printStackTrace();
					} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao excluir refeição");
						e1.printStackTrace();
					}
					criarPainelRefeicoes();
				}
			}
		);
		return botaoExcluir;
	}
}

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import Util.ViewUtils;

import java.awt.Panel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

public class TelaHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaHome window = new TelaHome();
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
	public TelaHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1058, 603);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setTitle("Home - EzHealth");
		frame.setLayout(null);
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		
		frame.getContentPane().add(configurePanelHeader());
		frame.getContentPane().add(configurePanelMenuBar());
		frame.getContentPane().add(configurePanelContent());
	}
	
	private Panel configurePanelHeader() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#2F3542"));
		panel.setBounds(0, 0, 1058, 107);
		panel.setLayout(null);		
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF", false);
		
		
		JLabel lblImgHospital = new JLabel(""); 
		lblImgHospital.setBounds(43, 30, 52, 51);
		
		new ViewUtils().setImageInLabel("/Images/hospital.png", lblImgHospital, panel);
		
		JLabel lblNewLabel_title = new JLabel("EZHEALTH");
		lblNewLabel_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_title.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_title.setBounds(112, 41, 96, 25);
		panel.add(lblNewLabel_title);

		
		JLabel lblImgMinhaConta = new JLabel(""); 
		lblImgMinhaConta.setBounds(930, 43, 39, 40);
		
		new ViewUtils().setImageInLabel("/Images/accountWhite.png", lblImgMinhaConta, panel);
		
		JLabel lblNewLabel_minhaConta = new JLabel("<html>Minha<br>Conta</html>");
		lblNewLabel_minhaConta.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		lblNewLabel_minhaConta.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_minhaConta.setBounds(978, 39, 70, 51);
		panel.add(lblNewLabel_minhaConta);
		
		return panel;
	}
	
	
	private Panel configurePanelMenuBar() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#A4B0BE"));
		panel.setBounds(0, 106, 136, 497);
		panel.setLayout(null);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// código para atualizar a tela
			}
		});
		
		JLabel lblImgHome = new JLabel(""); 
		lblImgHome.setBounds(10, 70, 19, 18);
		new ViewUtils().setImageInLabel("/Images/restaurant.png", lblImgHome, panel);
		
		
		labelHome.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelHome.setBounds(36, 33, 87, 27);
		panel.add(labelHome);
		
		JLabel labelRefeicoes = new JLabel("<html>Refei\u00E7\u00F5es <br> Personalizadas</html>");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelRefeicoes.setBounds(36, 65, 98, 35);
		panel.add(labelRefeicoes);
		labelRefeicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new TelaRefeicoesPersonalizadas();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		
		JLabel lblImgRefeicao = new JLabel(""); 
		lblImgRefeicao.setBounds(10, 115, 19, 18);
		new ViewUtils().setImageInLabel("/Images/fitness.png", lblImgRefeicao, panel);
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);
		
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelExercicios.setBounds(36, 106, 87, 35);
		panel.add(labelExercicios);
		labelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new TelaExercicios();
				TelaExercicios.main(null);
			}
		});
		
		
		JLabel lblImgExercicio = new JLabel(""); 
		lblImgExercicio.setBounds(10, 36, 19, 18);
		new ViewUtils().setImageInLabel("/Images/home.png", lblImgExercicio, panel);
		
		
		JLabel lblNewLabel_7_1 = new JLabel("Mais op\u00E7\u00F5es");
		lblNewLabel_7_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7_1.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_7_1.setBounds(10, 151, 124, 30);
		panel.add(lblNewLabel_7_1);
		
		
		JLabel labelMeusDados = new JLabel("Meus Dados");
		labelMeusDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new TelaMeusDados();
				TelaMeusDados.main(null);
			}
		});
		labelMeusDados.setHorizontalAlignment(SwingConstants.LEFT);
		labelMeusDados.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelMeusDados.setBounds(36, 177, 87, 35);
		panel.add(labelMeusDados);
		
		JLabel lblImgMeusDados = new JLabel(""); 
		lblImgMeusDados.setBounds(10, 184, 19, 18);
		new ViewUtils().setImageInLabel("/Images/account.png", lblImgMeusDados, panel);
		
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
		panel.add(labelSair);
		
		JLabel lblImgSair = new JLabel(""); 
		lblImgSair.setBounds(10, 218, 19, 18);
		new ViewUtils().setImageInLabel("/Images/exit.png", lblImgSair, panel);
		
		return panel;
	}
	
	
	
	private JPanel configurePanelContent() {
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		JLabel labelMes = new JLabel("Fevereiro 2021");
		labelMes.setBounds(20, 11, 125, 45);
		panel.add(labelMes);
		labelMes.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		
		JLabel labelData = new JLabel("Segunda - 10/02");
		labelData.setBounds(20, 43, 125, 22);
		panel.add(labelData);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		
		JLabel lblNewLabel_4_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_4_1.setBounds(32, 291, 125, 33);
		panel.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
				
		panel.add(configurePanelCalorias());
		
		this.configureButtonsRefeicoes(panel);
		
		return panel;
	}
	
	private Panel configurePanelCalorias() {
		Panel panel = new Panel();
		panel.setBounds(296, 90, 334, 139);
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel.setBackground(Color.decode("#CED6E0"));
		panel.setLayout(null);
		
		JLabel lbl_calorias_title = new JLabel("Calorias");
		lbl_calorias_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lbl_calorias_title.setBounds(144, 11, 68, 34);
		panel.add(lbl_calorias_title);
		
		JLabel lbl_caloriasConsumir_title = new JLabel("Consumir");
		lbl_caloriasConsumir_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasConsumir_title.setBounds(144, 48, 68, 45);
		panel.add(lbl_caloriasConsumir_title);
		
		JLabel lbl_caloriasConsumir = new JLabel("0 kcal");
		lbl_caloriasConsumir.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasConsumir.setBounds(154, 72, 68, 45);
		panel.add(lbl_caloriasConsumir);
		
		JLabel lbl_caloriasConsumidas_title = new JLabel("Consumidas");
		lbl_caloriasConsumidas_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasConsumidas_title.setBounds(23, 42, 88, 45);
		panel.add(lbl_caloriasConsumidas_title);
		
		JLabel lbl_caloriasConsumidas = new JLabel("0 kcal");
		lbl_caloriasConsumidas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasConsumidas.setBounds(44, 87, 46, 14);
		panel.add(lbl_caloriasConsumidas);
		
		JLabel lbl_caloriasGastas_title = new JLabel("Gastas");
		lbl_caloriasGastas_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasGastas_title.setBounds(256, 42, 88, 45);
		panel.add(lbl_caloriasGastas_title);
		
		JLabel lbl_caloriasGastas = new JLabel("0 kcal");
		lbl_caloriasGastas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasGastas.setBounds(263, 87, 46, 14);
		panel.add(lbl_caloriasGastas);
		
		return panel;
	}
	
	public void configureButtonsRefeicoes(JPanel panel) {
		// Café da manhã
		JPanel panel_cafeManha = new JPanel();
		panel_cafeManha.setBounds(32, 342, 258, 53);
		panel.add(panel_cafeManha);
		panel_cafeManha.setBackground(Color.decode("#CED6E0"));
		panel_cafeManha.setLayout(null);
		
		JLabel labelCaloriasManha = new JLabel("0 kcal");
		labelCaloriasManha.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasManha.setBounds(103, 30, 46, 14);
		panel_cafeManha.add(labelCaloriasManha);
		
		JLabel labelCafedaManha = new JLabel("Caf\u00E9 da Manh\u00E3");
		labelCafedaManha.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelCafedaManha.setBounds(65, 0, 125, 33);
		panel_cafeManha.add(labelCafedaManha);
		
		
		JLabel labelAdicionarCafe = new JLabel("+");
		labelAdicionarCafe.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarCafe.setBounds(217, 11, 20, 25);
		panel_cafeManha.add(labelAdicionarCafe);
		labelAdicionarCafe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da manhã
		JPanel panel_lancheManha = new JPanel();
		panel_lancheManha.setBounds(332, 342, 258, 53);
		panel.add(panel_lancheManha);
		panel_lancheManha.setLayout(null);
		panel_lancheManha.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasLancheManha = new JLabel("0 kcal");
		labelCaloriasLancheManha.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheManha.setBounds(103, 30, 46, 14);
		panel_lancheManha.add(labelCaloriasLancheManha);
		
		JLabel labelLancheManha = new JLabel("Lanche da manh\u00E3");
		labelLancheManha.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelLancheManha.setBounds(65, 0, 149, 33);
		panel_lancheManha.add(labelLancheManha);
		
		JLabel labelAdicionarLancheManha = new JLabel("+");
		labelAdicionarLancheManha.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheManha.setBounds(217, 11, 20, 25);
		panel_lancheManha.add(labelAdicionarLancheManha);
		labelAdicionarLancheManha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Almoço
		JPanel panel_almoco = new JPanel();
		panel_almoco.setBounds(634, 342, 258, 53);
		panel.add(panel_almoco);
		panel_almoco.setLayout(null);
		panel_almoco.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasAlmoco = new JLabel("0 kcal");
		labelCaloriasAlmoco.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasAlmoco.setBounds(103, 30, 46, 14);
		panel_almoco.add(labelCaloriasAlmoco);
		
		JLabel labelAlmoco = new JLabel("Almo\u00E7o");
		labelAlmoco.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelAlmoco.setBounds(91, 0, 125, 33);
		panel_almoco.add(labelAlmoco);
		
		JLabel labelAdicionarAlmoco = new JLabel("+");
		labelAdicionarAlmoco.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarAlmoco.setBounds(217, 11, 20, 25);
		panel_almoco.add(labelAdicionarAlmoco);
		labelAdicionarAlmoco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da tarde
		JPanel panel_lancheTarde = new JPanel();
		panel_lancheTarde.setBackground(Color.decode("#CED6E0"));
		panel_lancheTarde.setBounds(32, 422, 258, 53);
		panel_lancheTarde.setLayout(null);
		panel.add(panel_lancheTarde);
		
		JLabel labelCaloriasLancheTarde = new JLabel("0 kcal");
		labelCaloriasLancheTarde.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheTarde.setBounds(103, 30, 46, 14);
		panel_lancheTarde.add(labelCaloriasLancheTarde);
		
		JLabel labelLancheTarde = new JLabel("Lanche da tarde");
		labelLancheTarde.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelLancheTarde.setBounds(56, 0, 125, 33);
		panel_lancheTarde.add(labelLancheTarde);
		
		JLabel labelAdicionarLancheTarde = new JLabel("+");
		labelAdicionarLancheTarde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		labelAdicionarLancheTarde.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheTarde.setBounds(217, 11, 20, 25);
		panel_lancheTarde.add(labelAdicionarLancheTarde);
		
		
		// Janta
		JPanel panel_janta = new JPanel();
		panel_janta.setBounds(332, 422, 258, 53);
		panel.add(panel_janta);
		panel_janta.setLayout(null);
		panel_janta.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasJanta = new JLabel("0 kcal");
		labelCaloriasJanta.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasJanta.setBounds(103, 30, 46, 14);
		panel_janta.add(labelCaloriasJanta);
		
		JLabel labelJanta = new JLabel("Janta");
		labelJanta.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelJanta.setBounds(98, 0, 51, 33);
		panel_janta.add(labelJanta);
		
		JLabel labelAdicionarJanta = new JLabel("+");
		labelAdicionarJanta.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarJanta.setBounds(217, 11, 20, 25);
		panel_janta.add(labelAdicionarJanta);
		labelAdicionarJanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da noite
		JPanel panel_lancheNoite = new JPanel();
		panel_lancheNoite.setBounds(634, 422, 258, 53);
		panel.add(panel_lancheNoite);
		panel_lancheNoite.setLayout(null);
		panel_lancheNoite.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasLancheNoite = new JLabel("0 kcal");
		labelCaloriasLancheNoite.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheNoite.setBounds(103, 30, 46, 14);
		panel_lancheNoite.add(labelCaloriasLancheNoite);
		
		JLabel LancheNoite = new JLabel("Lanche da noite");
		LancheNoite.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		LancheNoite.setBounds(50, 0, 125, 33);
		panel_lancheNoite.add(LancheNoite);
		
		JLabel labelAdicionarLancheNoite = new JLabel("+");
		labelAdicionarLancheNoite.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheNoite.setBounds(217, 11, 20, 25);
		panel_lancheNoite.add(labelAdicionarLancheNoite);
		labelAdicionarLancheNoite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});

	}

}

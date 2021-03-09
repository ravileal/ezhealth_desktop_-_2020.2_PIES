package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


import Controller.ControllerUsuario;
import Model.Usuario;
import Util.ViewUtils;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JToggleButton;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class TelaHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setTitle("Home - EzHealth");
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		
		JPanel panel_content = new JPanel();
		panel_content.setBounds(0, 0, 10, 10);
		frame.setContentPane(panel_content);
		panel_content.setLayout(null);
		
		Panel panel_header = new Panel();
		panel_header.setBackground(Color.decode("#2F3542"));
		panel_header.setBounds(0, 0, 1058, 107);
		frame.getContentPane().add(panel_header);
		panel_header.setLayout(null);		
		
		
		new ViewUtils().configureTitleBarAlternative(frame, panel_header, "#2F3542", "#FFFFFF");
		
		
		JLabel lblImgHospital = new JLabel(""); 
		lblImgHospital.setBounds(43, 30, 52, 51);
		
		new ViewUtils().setImageInLabel("/Images/hospital.png", lblImgHospital, panel_header);
		
		JLabel lblNewLabel_title = new JLabel("EZHEALTH");
		lblNewLabel_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_title.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_title.setBounds(112, 41, 96, 25);
		panel_header.add(lblNewLabel_title);

		
		JLabel lblImgMinhaConta = new JLabel(""); 
		lblImgMinhaConta.setBounds(930, 43, 39, 40);
		
		new ViewUtils().setImageInLabel("/Images/accountWhite.png", lblImgMinhaConta, panel_header);
		
		JLabel lblNewLabel_minhaConta = new JLabel("<html>Minha<br>Conta</html>");
		lblNewLabel_minhaConta.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		lblNewLabel_minhaConta.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_minhaConta.setBounds(978, 39, 70, 51);
		panel_header.add(lblNewLabel_minhaConta);
		

		
		Panel panel_menu = new Panel();
		panel_menu.setBackground(Color.decode("#A4B0BE"));
		panel_menu.setBounds(0, 106, 136, 497);
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
		
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		
		JPanel panel_lancheTarde = new JPanel();
		panel_lancheTarde.setBounds(32, 422, 258, 53);
		panel.add(panel_lancheTarde);
		panel_lancheTarde.setLayout(null);
		panel_lancheTarde.setBackground(Color.decode("#CED6E0"));
		
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
				new TelaAlimentos().main(null);
			}
		});
		labelAdicionarLancheTarde.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheTarde.setBounds(217, 11, 20, 25);
		panel_lancheTarde.add(labelAdicionarLancheTarde);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(296, 90, 334, 139);
		panel.add(panel_2);
		panel_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_2.setBackground(Color.decode("#CED6E0"));
		panel_2.setLayout(null);
		
				
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Calorias");
		lblNewLabel_4_1_1_2.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2.setBounds(144, 11, 68, 34);
		panel_2.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Consumidas");
		lblNewLabel_4_1_1_2_1.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1.setBounds(23, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1_1 = new JLabel("Gastas");
		lblNewLabel_4_1_1_2_1_1.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1_1.setBounds(256, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1_1);
		
		JLabel labelCaloriasConsumidas = new JLabel("0 kcal");
		labelCaloriasConsumidas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		labelCaloriasConsumidas.setBounds(44, 87, 46, 14);
		panel_2.add(labelCaloriasConsumidas);
		
		JLabel labelCaloriasPerdidas = new JLabel("0 kcal");
		labelCaloriasPerdidas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		labelCaloriasPerdidas.setBounds(263, 87, 46, 14);
		panel_2.add(labelCaloriasPerdidas);
		
		JLabel lblNewLabel_4_1_1_2_2 = new JLabel("Consumir");
		lblNewLabel_4_1_1_2_2.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_2.setBounds(144, 48, 68, 45);
		panel_2.add(lblNewLabel_4_1_1_2_2);
		
		JLabel labelCaloriasConsumir = new JLabel("0 kcal");
		labelCaloriasConsumir.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		labelCaloriasConsumir.setBounds(154, 72, 68, 45);
		panel_2.add(labelCaloriasConsumir);
		
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
		
						
		labelAdicionarCafe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaAlimentos().main(null);
			}
		});
		labelAdicionarLancheManha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaAlimentos().main(null);
			}
		});
		labelAdicionarJanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaAlimentos().main(null);
			}
		});
		labelAdicionarLancheNoite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaAlimentos().main(null);
			}
		});
		labelAdicionarAlmoco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaAlimentos().main(null);
			}
		});
		
		
	}
}

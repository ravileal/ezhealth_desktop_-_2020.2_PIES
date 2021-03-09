package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Util.ViewUtils;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaMeusDados {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaMeusDados window = new TelaMeusDados();
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
	public TelaMeusDados() {
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
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF", false);
		
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
				new TelaRefeicoesPersonalizadas();
				TelaRefeicoesPersonalizadas.main(null);
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
				new TelaExercicios();
				TelaExercicios.main(null);
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
				new TelaMeusDados();
				TelaMeusDados.main(null);
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
		
		JLabel lblMeusDadosPessoais = new JLabel("Meus dados Pessoais");
		lblMeusDadosPessoais.setVerticalAlignment(SwingConstants.TOP);
		lblMeusDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeusDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMeusDadosPessoais.setBounds(168, 125, 193, 30);
		frame.getContentPane().add(lblMeusDadosPessoais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(159, 154, 862, 10);
		frame.getContentPane().add(separator);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(164, 194, 52, 30);
		frame.getContentPane().add(lblNome);
		
		JLabel lblNomeCompletoDa = new JLabel("Nome completo da pessoa");
		lblNomeCompletoDa.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompletoDa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompletoDa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompletoDa.setBounds(226, 194, 200, 30);
		frame.getContentPane().add(lblNomeCompletoDa);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(164, 224, 160, 30);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblNascimento = new JLabel("dd/mm/aaaa");
		lblNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNascimento.setBounds(314, 224, 200, 30);
		frame.getContentPane().add(lblNascimento);
		
		JLabel lblPe = new JLabel("Peso:");
		lblPe.setVerticalAlignment(SwingConstants.TOP);
		lblPe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPe.setBounds(164, 254, 52, 30);
		frame.getContentPane().add(lblPe);
		
		JLabel lblPesoKg = new JLabel("45 kg");
		lblPesoKg.setVerticalAlignment(SwingConstants.TOP);
		lblPesoKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesoKg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoKg.setBounds(211, 254, 200, 30);
		frame.getContentPane().add(lblPesoKg);
		
		JLabel lblAltu = new JLabel("Altura:");
		lblAltu.setVerticalAlignment(SwingConstants.TOP);
		lblAltu.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltu.setBounds(164, 285, 52, 30);
		frame.getContentPane().add(lblAltu);
		
		JLabel lblAltura = new JLabel("1,65 cm");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltura.setBounds(211, 285, 200, 30);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblMe = new JLabel("Meta:");
		lblMe.setVerticalAlignment(SwingConstants.TOP);
		lblMe.setHorizontalAlignment(SwingConstants.LEFT);
		lblMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMe.setBounds(654, 194, 52, 30);
		frame.getContentPane().add(lblMe);
		
		JLabel lblMeta = new JLabel("Ganhar Peso");
		lblMeta.setVerticalAlignment(SwingConstants.TOP);
		lblMeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta.setBounds(701, 194, 200, 30);
		frame.getContentPane().add(lblMeta);
		
		JLabel lblDoenas = new JLabel("Doen\u00E7as:");
		lblDoenas.setVerticalAlignment(SwingConstants.TOP);
		lblDoenas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoenas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoenas.setBounds(654, 224, 61, 30);
		frame.getContentPane().add(lblDoenas);
		
		JLabel lblMeta_1 = new JLabel("-");
		lblMeta_1.setVerticalAlignment(SwingConstants.TOP);
		lblMeta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta_1.setBounds(725, 224, 200, 30);
		frame.getContentPane().add(lblMeta_1);
		
		JLabel lblIntolerncias = new JLabel("Intoler\u00E2ncias:");
		lblIntolerncias.setVerticalAlignment(SwingConstants.TOP);
		lblIntolerncias.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntolerncias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntolerncias.setBounds(654, 254, 87, 30);
		frame.getContentPane().add(lblIntolerncias);
		
		JLabel lblLactose = new JLabel("Lactose");
		lblLactose.setVerticalAlignment(SwingConstants.TOP);
		lblLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblLactose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLactose.setBounds(751, 254, 200, 30);
		frame.getContentPane().add(lblLactose);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexo.setBounds(164, 313, 52, 30);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblFeminino = new JLabel("Feminino");
		lblFeminino.setVerticalAlignment(SwingConstants.TOP);
		lblFeminino.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeminino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeminino.setBounds(211, 313, 200, 30);
		frame.getContentPane().add(lblFeminino);
		
		JLabel lblNomeemailcom = new JLabel("nome@email.com");
		lblNomeemailcom.setVerticalAlignment(SwingConstants.TOP);
		lblNomeemailcom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeemailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeemailcom.setBounds(703, 285, 200, 30);
		frame.getContentPane().add(lblNomeemailcom);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(654, 285, 52, 30);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblGosatariaDeMudar = new JLabel("Gostaria de mudar algum dado?");
		lblGosatariaDeMudar.setVerticalAlignment(SwingConstants.TOP);
		lblGosatariaDeMudar.setHorizontalAlignment(SwingConstants.LEFT);
		lblGosatariaDeMudar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGosatariaDeMudar.setBounds(459, 478, 231, 30);
		frame.getContentPane().add(lblGosatariaDeMudar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.decode("#2F3542"));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaEditarCadastro();
				TelaEditarCadastro.main(null);
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(509, 507, 89, 30);
		frame.getContentPane().add(btnEditar);
	}
}

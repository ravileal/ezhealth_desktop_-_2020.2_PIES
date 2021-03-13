package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Util.ViewUtils;

public class LayoutMain {
	
	protected JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LayoutMain window = new LayoutMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public LayoutMain() {
		this.frame = new JFrame();
		this.configureFrame();
		this.configurePanelHeader();
		this.configurePanelMenuBar();
	}
	
	private void configureFrame() {
		frame.setResizable(false);
		frame.setBounds(100, 100, 1058, 603);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	private void configurePanelHeader() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#2F3542"));
		panel.setBounds(0, 0, 1058, 107);
		panel.setLayout(null);		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF");
		
		JLabel lblImgHospital = new JLabel(""); 
		lblImgHospital.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				TelaHome.main(null);
				
			}
		});
		lblImgHospital.setBounds(43, 30, 52, 51);
		new ViewUtils().setImageInLabel("/Images/hospital.png", lblImgHospital, panel);
		
		JLabel lblNewLabel_title = new JLabel("EZHEALTH");
		lblNewLabel_title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				TelaHome.main(null);
				
			}
		});
		lblNewLabel_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_title.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_title.setBounds(112, 41, 96, 25);
		panel.add(lblNewLabel_title);
		
		JLabel lblImgMinhaConta = new JLabel(""); 
		lblImgMinhaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				TelaMeusDados.main(null);
				
			}
		});
		lblImgMinhaConta.setBounds(930, 43, 39, 40);
		new ViewUtils().setImageInLabel("/Images/accountWhite.png", lblImgMinhaConta, panel);
		
		JLabel lblNewLabel_minhaConta = new JLabel("<html>Minha<br>Conta</html>");
		lblNewLabel_minhaConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				TelaMeusDados.main(null);
				
			}
		});
		lblNewLabel_minhaConta.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		lblNewLabel_minhaConta.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_minhaConta.setBounds(978, 39, 70, 51);
		panel.add(lblNewLabel_minhaConta);
		
		frame.getContentPane().add(panel);
	}
	
	private void configurePanelMenuBar() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#A4B0BE"));
		panel.setBounds(0, 106, 136, 497);
		panel.setLayout(null);
		
		// label menu
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);

		// bot�o home
		JLabel labelHome = new JLabel("Home");
		labelHome.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelHome.setBounds(36, 33, 98, 35);
		panel.add(labelHome);
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaHome.main(null);
			}
		});
		JLabel lblImgHome = new JLabel("");
		lblImgHome.setBounds(10, 40, 19, 18);
		new ViewUtils().setImageInLabel("/Images/home.png", lblImgHome, panel);
		
		
		// bot�o refei��es
		JLabel labelRefeicoes = new JLabel("<html>Refei\u00E7\u00F5es <br> Personalizadas</html>");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelRefeicoes.setBounds(36, 70, 98, 35);
		labelRefeicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		panel.add(labelRefeicoes);
		JLabel lblImgRefeicao = new JLabel(""); 
		lblImgRefeicao.setBounds(10, 75, 19, 18);
		new ViewUtils().setImageInLabel("/Images/restaurant.png", lblImgRefeicao, panel);
		
		// bot�o exercicio
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelExercicios.setBounds(36, 106, 98, 35);
		labelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new TelaExercicios();
				TelaExercicios.main(null);
			}
		});
		panel.add(labelExercicios);
		JLabel lblImgExercicio = new JLabel(""); 
		lblImgExercicio.setBounds(10, 112, 19, 18);
		new ViewUtils().setImageInLabel("/Images/fitness.png", lblImgExercicio, panel);
		
		
		// label mais op��es
		JLabel lblMaisOpcoes = new JLabel("Mais op\u00E7\u00F5es");
		lblMaisOpcoes.setVerticalAlignment(SwingConstants.TOP);
		lblMaisOpcoes.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaisOpcoes.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lblMaisOpcoes.setBounds(10, 151, 124, 30);
		panel.add(lblMaisOpcoes);
		
		// bot�o meus dados
		JLabel labelMeusDados = new JLabel("Meus Dados");
		labelMeusDados.setHorizontalAlignment(SwingConstants.LEFT);
		labelMeusDados.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelMeusDados.setBounds(36, 177, 98, 35);
		labelMeusDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				new TelaMeusDados();
				TelaMeusDados.main(null);
			}
		});
		panel.add(labelMeusDados);
		JLabel lblImgMeusDados = new JLabel(""); 
		lblImgMeusDados.setBounds(10, 184, 19, 18);
		new ViewUtils().setImageInLabel("/Images/account.png", lblImgMeusDados, panel);
		
		// bot�o sair
		JLabel labelSair = new JLabel("Sair");
		labelSair.setHorizontalAlignment(SwingConstants.LEFT);
		labelSair.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelSair.setBounds(36, 211, 98, 35);
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
		
		frame.getContentPane().add(panel);
	}
}

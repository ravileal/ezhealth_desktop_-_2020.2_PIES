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

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
		frame.setBounds(100, 100, 1030, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("activeCaption"));
		panel.setBounds(0, 72, 119, 474);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHome.setBounds(10, 33, 63, 27);
		panel.add(labelHome);
		
		JLabel labelRefeicoes = new JLabel("Refei\u00E7\u00F5es ");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRefeicoes.setBounds(10, 59, 144, 35);
		panel.add(labelRefeicoes);
		
		JLabel labelPersonalizadas = new JLabel("Personalizadas");
		labelPersonalizadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPersonalizadas.setBounds(10, 80, 86, 27);
		panel.add(labelPersonalizadas);
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);
		
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelExercicios.setBounds(10, 106, 144, 35);
		panel.add(labelExercicios);
		
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
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_2.setBounds(385, 142, 321, 130);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Calorias");
		lblNewLabel_4_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2.setBounds(131, 0, 68, 34);
		panel_2.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Consumidas");
		lblNewLabel_4_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1.setBounds(10, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1_1 = new JLabel("Perdidas");
		lblNewLabel_4_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1_1.setBounds(243, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1_1);
		
		JLabel labelCaloriasConsumidas = new JLabel("0 kcal");
		labelCaloriasConsumidas.setBounds(31, 87, 46, 14);
		panel_2.add(labelCaloriasConsumidas);
		
		JLabel labelCaloriasPerdidas = new JLabel("0 kcal");
		labelCaloriasPerdidas.setBounds(250, 87, 46, 14);
		panel_2.add(labelCaloriasPerdidas);
		
		JLabel lblNewLabel_4_1_1_2_2 = new JLabel("Consumir");
		lblNewLabel_4_1_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_2.setBounds(131, 32, 68, 45);
		panel_2.add(lblNewLabel_4_1_1_2_2);
		
		JLabel labelCaloriasConsumir = new JLabel("0 kcal");
		labelCaloriasConsumir.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelCaloriasConsumir.setBounds(141, 56, 68, 45);
		panel_2.add(labelCaloriasConsumir);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 331, 130);
		panel_2.add(panel_3);
		panel_3.setBackground(SystemColor.activeCaption);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Segunda - 10/02");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(139, 103, 125, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Fevereiro 2021");
		lblNewLabel_4.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(139, 71, 125, 45);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_4_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(156, 277, 125, 33);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(156, 313, 258, 69);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel labelCaloriasManha = new JLabel("0 kcal");
		labelCaloriasManha.setBounds(103, 41, 46, 14);
		panel_4.add(labelCaloriasManha);
		
		JLabel labelCafedaManha = new JLabel("Caf\u00E9 da Manh\u00E3");
		labelCafedaManha.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelCafedaManha.setBounds(71, 0, 125, 45);
		panel_4.add(labelCafedaManha);
		
		JLabel labelAdicionarCafe = new JLabel("+");
		labelAdicionarCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarCafe.setBounds(217, 11, 20, 45);
		panel_4.add(labelAdicionarCafe);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(SystemColor.activeCaption);
		panel_4_1.setBounds(156, 432, 258, 69);
		frame.getContentPane().add(panel_4_1);
		
		JLabel labelCaloriasLancheTarde = new JLabel("0 kcal");
		labelCaloriasLancheTarde.setBounds(103, 41, 46, 14);
		panel_4_1.add(labelCaloriasLancheTarde);
		
		JLabel labelLancheTarde = new JLabel("Lanche da tarde");
		labelLancheTarde.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelLancheTarde.setBounds(71, 0, 125, 45);
		panel_4_1.add(labelLancheTarde);
		
		JLabel labelAdicionarLancheTarde = new JLabel("+");
		labelAdicionarLancheTarde.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarLancheTarde.setBounds(217, 11, 20, 45);
		panel_4_1.add(labelAdicionarLancheTarde);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(SystemColor.activeCaption);
		panel_4_2.setBounds(424, 313, 258, 69);
		frame.getContentPane().add(panel_4_2);
		
		JLabel labelCaloriasLancheManha = new JLabel("0 kcal");
		labelCaloriasLancheManha.setBounds(103, 41, 46, 14);
		panel_4_2.add(labelCaloriasLancheManha);
		
		JLabel labelLancheManha = new JLabel("Lanche da manh\u00E3");
		labelLancheManha.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelLancheManha.setBounds(71, 0, 125, 45);
		panel_4_2.add(labelLancheManha);
		
		JLabel labelAdicionarLancheManha = new JLabel("+");
		labelAdicionarLancheManha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarLancheManha.setBounds(217, 11, 20, 45);
		panel_4_2.add(labelAdicionarLancheManha);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBackground(SystemColor.activeCaption);
		panel_4_3.setBounds(694, 313, 258, 69);
		frame.getContentPane().add(panel_4_3);
		
		JLabel labelCaloriasAlmoco = new JLabel("0 kcal");
		labelCaloriasAlmoco.setBounds(103, 41, 46, 14);
		panel_4_3.add(labelCaloriasAlmoco);
		
		JLabel labelAlmoco = new JLabel("Almo\u00E7o");
		labelAlmoco.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelAlmoco.setBounds(91, 0, 125, 45);
		panel_4_3.add(labelAlmoco);
		
		JLabel labelAdicionarAlmoco = new JLabel("+");
		labelAdicionarAlmoco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarAlmoco.setBounds(217, 11, 20, 45);
		panel_4_3.add(labelAdicionarAlmoco);
		
		JPanel panel_4_4 = new JPanel();
		panel_4_4.setLayout(null);
		panel_4_4.setBackground(SystemColor.activeCaption);
		panel_4_4.setBounds(424, 432, 258, 69);
		frame.getContentPane().add(panel_4_4);
		
		JLabel labelCaloriasJanta = new JLabel("0 kcal");
		labelCaloriasJanta.setBounds(103, 41, 46, 14);
		panel_4_4.add(labelCaloriasJanta);
		
		JLabel labelJanta = new JLabel("Janta");
		labelJanta.setFont(new Font("Dialog", Font.PLAIN, 16));
		labelJanta.setBounds(98, 0, 125, 45);
		panel_4_4.add(labelJanta);
		
		JLabel labelAdicionarJanta = new JLabel("+");
		labelAdicionarJanta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarJanta.setBounds(217, 11, 20, 45);
		panel_4_4.add(labelAdicionarJanta);
		
		JPanel panel_4_5 = new JPanel();
		panel_4_5.setLayout(null);
		panel_4_5.setBackground(SystemColor.activeCaption);
		panel_4_5.setBounds(694, 432, 258, 69);
		frame.getContentPane().add(panel_4_5);
		
		JLabel labelCaloriasLancheNoite = new JLabel("0 kcal");
		labelCaloriasLancheNoite.setBounds(103, 41, 46, 14);
		panel_4_5.add(labelCaloriasLancheNoite);
		
		JLabel LancheNoite = new JLabel("Lanche da noite");
		LancheNoite.setFont(new Font("Dialog", Font.PLAIN, 16));
		LancheNoite.setBounds(69, 0, 125, 45);
		panel_4_5.add(LancheNoite);
		
		JLabel labelAdicionarLancheNoite = new JLabel("+");
		labelAdicionarLancheNoite.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelAdicionarLancheNoite.setBounds(217, 11, 20, 45);
		panel_4_5.add(labelAdicionarLancheNoite);
	}
}

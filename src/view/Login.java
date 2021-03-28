package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ControllerRefeicao;
import controller.ControllerSystem;
import controller.ControllerUsuario;
import model.Alimento;
import model.Refeicao;
import model.RefeicaoAlimentoUsuario;
import model.dao.connection.HandlerObject;
import util.DatasFormatadas;
import util.ViewUtils;
import validation.CredenciaisInvalidasException;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new ControllerSystem().startConnection();
					Login window = new Login();
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
	public Login() {
		initialize();
		// centraliza tela de login
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1058, 603);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login - EzHealth");
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1058, 603);
		panel.setBackground(Color.decode("#DFE4EA"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#DFE4EA", "#000000");
		
		JTextField campoLogin = new JTextField();
		campoLogin.setColumns(10);
		campoLogin.setBounds(701, 295, 277, 36);
		campoLogin.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(campoLogin);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Quicksand Medium", Font.PLAIN, 15));
		lblNewLabel.setBounds(701, 270, 70, 23);
		panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Quicksand Medium", Font.PLAIN, 15));
		lblSenha.setBounds(701, 354, 46, 23);
		panel.add(lblSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Realizar Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Quicksand Light", Font.BOLD, 20));
		lblNewLabel_1.setBounds(701, 194, 277, 23);
		panel.add(lblNewLabel_1);
		
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(701, 385, 277, 36);
		campoSenha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(campoSenha);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setFont(new Font("Quicksand", Font.PLAIN, 15));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(Color.decode("#2F3542"));
		btnLogin.setBounds(802, 526, 89, 36);
		btnLogin.setBorder(BorderFactory.createEmptyBorder());
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					ControllerUsuario.validarLogin(campoLogin.getText(), String.valueOf(campoSenha.getPassword()));
					
					frame.dispose();
					TelaHome.main(null);
				} catch (CredenciaisInvalidasException e1) {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorretos!");
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorretos!");
					e1.printStackTrace();
				}

			}
		});
		panel.add(btnLogin);
		
		JLabel lblNewLabel_1_1 = new JLabel("EZHEALTH");
		lblNewLabel_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(856, 106, 122, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ol\u00E1! :)");
		lblNewLabel_1_1_1.setFont(new Font("Quicksand", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(274, 73, 51, 23);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Bem vindo(a) de volta!");
		lblNewLabel_1_1_1_1.setFont(new Font("Quicksand", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(199, 107, 194, 23);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton btnCadastro = new JButton("N\u00E3o tem conta ainda? Cadastre-se");
		btnCadastro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastro.setBorder(BorderFactory.createEmptyBorder());
		btnCadastro.setFont(new Font("Quicksand", Font.PLAIN, 13));
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PopupCadastro();
				PopupCadastro.main(null);
			}
		});
		btnCadastro.setBackground(Color.decode("#2F3542"));
		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setBounds(116, 521, 277, 46);
		panel.add(btnCadastro);
		
		JLabel jLabelImagemLogin1 = new JLabel("");
		ImageIcon imgLogin1 = new ImageIcon(this.getClass().getResource("/Images/imagemlogin1.png"));
		jLabelImagemLogin1.setIcon(imgLogin1);
		jLabelImagemLogin1.setBounds(60, 143, 468, 355);
		panel.add(jLabelImagemLogin1);
		
		
		// ---- Label da imagem hospital ---- Inicio
		JLabel lblImgHospital = new JLabel(""); // Criação da label
		lblImgHospital.setBounds(776, 83, 70, 68); // Dimensões e posicionamento da label
		
		// criação do icone gerenando a iamgem a partir da path passado como argumento
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/Images/hospital.png")); 
		
		Image imagem = imageIcon.getImage(); // extrai a imagem encontrada que está no icone
		// redimensiona a imagem para a largura e altura da label
		imagem = imagem.getScaledInstance(lblImgHospital.getWidth(), lblImgHospital.getHeight(), Image.SCALE_DEFAULT);
		
		imageIcon = new ImageIcon(imagem); // define a imagem com dimensões atualizadas para o icone
		lblImgHospital.setIcon(imageIcon); // define o icone atualizado como icone da label
		 
		panel.add(lblImgHospital); // adiciona a label ao painel
		// ---- Label da imagem hospital ---- Fim
		
		
		


		
	}
	
	
}

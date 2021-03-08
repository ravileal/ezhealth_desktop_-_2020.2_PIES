package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerUsuario;
import Validation.CredenciaisInvalidasException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class TelaLogin {

	private JFrame frame;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1058, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1042, 564);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		campoLogin = new JTextField();
		campoLogin.setColumns(10);
		campoLogin.setBounds(687, 261, 277, 36);
		panel.add(campoLogin);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(687, 236, 46, 23);
		panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(687, 320, 46, 23);
		panel.add(lblSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Realizar Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(759, 159, 118, 23);
		panel.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 51));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					new ControllerUsuario().validarLogin(campoLogin.getText(), campoSenha.getText());
					new TelaHome().main(null);
				} catch (CredenciaisInvalidasException e1) {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorretos!");
					e1.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(788, 492, 89, 36);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_1_1 = new JLabel("EzHealth");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(791, 68, 118, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ol\u00E1! :)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(203, 41, 118, 23);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Bem vindo(a) de volta!");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(137, 75, 222, 23);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton btnCadastro = new JButton("N\u00E3o tem conta ainda? Cadastre-se");
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaCadastro().main(null);
			}
		});
		btnCadastro.setBackground(new Color(0, 0, 51));
		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setBounds(102, 487, 277, 46);
		panel.add(btnCadastro);
		
		JLabel jLabelImagemLogin1 = new JLabel("");
		ImageIcon imgLogin1 = new ImageIcon(this.getClass().getResource("/Images/imagemlogin1.png"));
		jLabelImagemLogin1.setIcon(imgLogin1);
		jLabelImagemLogin1.setBounds(46, 109, 468, 355);
		panel.add(jLabelImagemLogin1);
		
		JLabel imgLogin2 = new JLabel("");
		imgLogin2.setIcon(new ImageIcon(TelaLogin.class.getResource("/Images/hospital.png")));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Images/hospital.png"));
		Image img2 = icon.getImage();
		Image imgScale = img2.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgScale);
		imgLogin2.setBounds(676, 26, 105, 83);
		panel.add(imgLogin2);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(687, 351, 277, 36);
		panel.add(campoSenha);
	}
	
}

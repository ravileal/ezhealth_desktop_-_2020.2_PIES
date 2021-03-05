package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaLogin {

	private JFrame frame;
	private JTextField campoSenha;
	private JTextField campoLogin;

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
		
		campoSenha = new JTextField();
		campoSenha.setBounds(687, 345, 277, 36);
		panel.add(campoSenha);
		campoSenha.setColumns(10);
		
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
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 102));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Logado com sucesso!");
			}
		});
		btnLogin.setBounds(774, 437, 89, 36);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_1_1 = new JLabel("EzHealth");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(791, 68, 118, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ol\u00E1! :)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(128, 68, 118, 23);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Bem vindo(a) de volta!");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(69, 102, 222, 23);
		panel.add(lblNewLabel_1_1_1_1);
		
		JButton btnCadastro = new JButton("N\u00E3o tem conta ainda? Cadastre-se");
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Inicio de cadastro!");
			}
		});
		btnCadastro.setBackground(new Color(0, 0, 128));
		btnCadastro.setForeground(new Color(255, 255, 255));
		btnCadastro.setBounds(43, 437, 271, 36);
		panel.add(btnCadastro);
	}
}

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Util.ViewUtils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;

public class PopupEditarCadastro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupEditarCadastro window = new PopupEditarCadastro();
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
	public PopupEditarCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1056, 718);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 427, 1004, 18);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 225, 1004, 18);
		frame.getContentPane().add(separator);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeCompleto.setBounds(26, 107, 253, 30);
		frame.getContentPane().add(lblNomeCompleto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 99, 381, 30);
		frame.getContentPane().add(textField);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Masculino"}));
		comboBoxSexo.setMaximumRowCount(2);
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSexo.setBounds(235, 167, 110, 30);
		frame.getContentPane().add(comboBoxSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(182, 170, 62, 30);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setVerticalAlignment(SwingConstants.TOP);
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(372, 170, 48, 30);
		frame.getContentPane().add(lblPeso);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(419, 169, 97, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setVerticalAlignment(SwingConstants.TOP);
		lblKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKg.setBounds(520, 170, 56, 30);
		frame.getContentPane().add(lblKg);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(612, 170, 56, 30);
		frame.getContentPane().add(lblAltura);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(659, 167, 97, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel lblKg_1 = new JLabel("cm");
		lblKg_1.setVerticalAlignment(SwingConstants.TOP);
		lblKg_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKg_1.setBounds(760, 170, 56, 30);
		frame.getContentPane().add(lblKg_1);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(586, 102, 253, 30);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblPossuiAlgumaIntolerncia = new JLabel("Possui alguma Intoler\u00E2ncia?");
		lblPossuiAlgumaIntolerncia.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaIntolerncia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaIntolerncia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPossuiAlgumaIntolerncia.setBounds(777, 280, 253, 30);
		frame.getContentPane().add(lblPossuiAlgumaIntolerncia);
		
		JCheckBox Lactose = new JCheckBox("A lactose");
		Lactose.setBounds(804, 331, 83, 23);
		frame.getContentPane().add(Lactose);
		
		JCheckBox Gluten = new JCheckBox("A gluten");
		Gluten.setBounds(890, 331, 97, 23);
		frame.getContentPane().add(Gluten);
		
		JLabel lblPossuiAlgumaDoena = new JLabel("Possui alguma doen\u00E7a?");
		lblPossuiAlgumaDoena.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaDoena.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaDoena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPossuiAlgumaDoena.setBounds(481, 280, 253, 30);
		frame.getContentPane().add(lblPossuiAlgumaDoena);
		
		JCheckBox Diabetes = new JCheckBox("Diabetes");
		Diabetes.setBounds(481, 331, 97, 23);
		frame.getContentPane().add(Diabetes);
		
		JCheckBox Colesterol = new JCheckBox("Colesterol");
		Colesterol.setBounds(586, 331, 97, 23);
		frame.getContentPane().add(Colesterol);
		
		JRadioButton ManterPeso = new JRadioButton("Manter Peso");
		ManterPeso.setBounds(278, 331, 109, 23);
		frame.getContentPane().add(ManterPeso);
		
		JRadioButton PerderPeso = new JRadioButton("Perder Peso");
		PerderPeso.setBounds(149, 331, 109, 23);
		frame.getContentPane().add(PerderPeso);
		
		JRadioButton GanharPeso = new JRadioButton("Ganhar Peso");
		GanharPeso.setBounds(26, 331, 109, 23);
		frame.getContentPane().add(GanharPeso);
		
		JLabel lblQualSuaMeta = new JLabel("Qual sua meta?");
		lblQualSuaMeta.setVerticalAlignment(SwingConstants.TOP);
		lblQualSuaMeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblQualSuaMeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQualSuaMeta.setBounds(138, 280, 253, 30);
		frame.getContentPane().add(lblQualSuaMeta);
		
		JLabel lblPreenchaSInformaes = new JLabel("Preencha as informa\u00E7\u00F5es de acesso abaixo");
		lblPreenchaSInformaes.setVerticalAlignment(SwingConstants.TOP);
		lblPreenchaSInformaes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreenchaSInformaes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreenchaSInformaes.setBounds(26, 447, 343, 30);
		frame.getContentPane().add(lblPreenchaSInformaes);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(26, 496, 253, 30);
		frame.getContentPane().add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(78, 493, 381, 30);
		frame.getContentPane().add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(649, 493, 360, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setVerticalAlignment(SwingConstants.TOP);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(579, 496, 48, 30);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(513, 552, 126, 30);
		frame.getContentPane().add(lblConfirmarSenha);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(649, 549, 360, 30);
		frame.getContentPane().add(passwordField_1);
		
		JButton Cadastrar = new JButton("Finalizar");
		Cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Cadastrar.setBackground(Color.decode("#2F3542"));
		Cadastrar.setForeground(new Color(255, 255, 255));
		Cadastrar.setBounds(520, 636, 89, 30);
		frame.getContentPane().add(Cadastrar);
		
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#2F3542"));
		panel.setBounds(0, 0, 1058, 78);
		frame.getContentPane().add(panel);
		panel.setLayout(null);	
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF", true);
		
		JLabel lblEditarCadastro = new JLabel("Editar Cadastro");
		lblEditarCadastro.setVerticalAlignment(SwingConstants.TOP);
		lblEditarCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditarCadastro.setForeground(Color.WHITE);
		lblEditarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEditarCadastro.setBackground(Color.WHITE);
		lblEditarCadastro.setBounds(430, 23, 176, 30);
		panel.add(lblEditarCadastro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(734, 99, 139, 30);
		frame.getContentPane().add(textField_4);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.decode("#2F3542"));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaMeusDados();
				TelaMeusDados.main(null);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(392, 636, 89, 30);
		frame.getContentPane().add(btnCancelar);
	}
}

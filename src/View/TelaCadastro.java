package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.ControllerUsuario;
import Model.Usuario;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastro {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldNascimento;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JTextField Email;
	private JPasswordField ConfirmarSenha;
	private JPasswordField Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setBackground(Color.WHITE);
		lblCadastro.setVerticalAlignment(SwingConstants.TOP);
		lblCadastro.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCadastro.setBounds(439, 21, 109, 30);
		panel_1.add(lblCadastro);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeCompleto.setBounds(10, 104, 253, 30);
		frame.getContentPane().add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(133, 96, 381, 30);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(570, 104, 253, 30);
		frame.getContentPane().add(lblDataDeNascimento);
		
		textFieldNascimento = new JTextField();
		textFieldNascimento.setColumns(10);
		textFieldNascimento.setBounds(719, 96, 166, 30);
		frame.getContentPane().add(textFieldNascimento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSexo.setBounds(168, 167, 62, 30);
		frame.getContentPane().add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Maculino"}));
		comboBoxSexo.setMaximumRowCount(2);
		comboBoxSexo.setBounds(221, 164, 110, 30);
		frame.getContentPane().add(comboBoxSexo);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setVerticalAlignment(SwingConstants.TOP);
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(358, 167, 120, 30);
		frame.getContentPane().add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(405, 164, 97, 30);
		frame.getContentPane().add(textFieldPeso);
		
		JLabel lblKg = new JLabel("KG");
		lblKg.setVerticalAlignment(SwingConstants.TOP);
		lblKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKg.setBounds(506, 167, 56, 30);
		frame.getContentPane().add(lblKg);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(598, 167, 56, 30);
		frame.getContentPane().add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(645, 164, 97, 30);
		frame.getContentPane().add(textFieldAltura);
		
		JLabel lblKg_1 = new JLabel("KG");
		lblKg_1.setVerticalAlignment(SwingConstants.TOP);
		lblKg_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKg_1.setBounds(746, 167, 56, 30);
		frame.getContentPane().add(lblKg_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 241, 987, 18);
		frame.getContentPane().add(separator);
		
		JLabel lblQualSuaMeta = new JLabel("Qual sua meta?");
		lblQualSuaMeta.setVerticalAlignment(SwingConstants.TOP);
		lblQualSuaMeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblQualSuaMeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQualSuaMeta.setBounds(122, 296, 253, 30);
		frame.getContentPane().add(lblQualSuaMeta);
		
		JRadioButton GanharPeso = new JRadioButton("Ganhar Peso");
		GanharPeso.setBounds(10, 347, 109, 23);
		frame.getContentPane().add(GanharPeso);
		
		JRadioButton PerderPeso = new JRadioButton("Perder Peso");
		PerderPeso.setBounds(133, 347, 109, 23);
		frame.getContentPane().add(PerderPeso);
		
		JRadioButton ManterPeso = new JRadioButton("Manter Peso");
		ManterPeso.setBounds(262, 347, 109, 23);
		frame.getContentPane().add(ManterPeso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 443, 987, 18);
		frame.getContentPane().add(separator_1);
		
		JLabel lblPossuiAlgumaDoena = new JLabel("Possui alguma doen\u00E7a?");
		lblPossuiAlgumaDoena.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaDoena.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaDoena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPossuiAlgumaDoena.setBounds(465, 296, 253, 30);
		frame.getContentPane().add(lblPossuiAlgumaDoena);
		
		JCheckBox Diabetes = new JCheckBox("Diabetes");
		Diabetes.setBounds(465, 347, 97, 23);
		frame.getContentPane().add(Diabetes);
		
		JLabel lblPossuiAlgumaIntolerncia = new JLabel("Possui alguma Intoler\u00E2ncia?");
		lblPossuiAlgumaIntolerncia.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaIntolerncia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaIntolerncia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPossuiAlgumaIntolerncia.setBounds(761, 296, 253, 30);
		frame.getContentPane().add(lblPossuiAlgumaIntolerncia);
		
		JCheckBox Colesterol = new JCheckBox("Colesterol");
		Colesterol.setBounds(570, 347, 97, 23);
		frame.getContentPane().add(Colesterol);
		
		JCheckBox Lactose = new JCheckBox("A lactose");
		Lactose.setBounds(788, 347, 83, 23);
		frame.getContentPane().add(Lactose);
		
		JCheckBox Gluten = new JCheckBox("A gluten");
		Gluten.setBounds(874, 347, 97, 23);
		frame.getContentPane().add(Gluten);
		
		JLabel lblPreenchaSInformaes = new JLabel("Preencha as informa\u00E7\u00F5es de acesso abaixo");
		lblPreenchaSInformaes.setVerticalAlignment(SwingConstants.TOP);
		lblPreenchaSInformaes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreenchaSInformaes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreenchaSInformaes.setBounds(10, 463, 343, 30);
		frame.getContentPane().add(lblPreenchaSInformaes);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 512, 253, 30);
		frame.getContentPane().add(lblEmail);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(62, 509, 381, 30);
		frame.getContentPane().add(Email);
		
		JLabel lblSenha = new JLabel("senha");
		lblSenha.setVerticalAlignment(SwingConstants.TOP);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(563, 512, 48, 30);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(497, 568, 126, 30);
		frame.getContentPane().add(lblConfirmarSenha);
		
		JButton Cadastrar = new JButton("Finalizar");
		Cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuario = new Usuario();
				usuario.setNome(textFieldNome.getText());
				usuario.setSenha(Senha.getText());
				usuario.setUsuario(Email.getText());
				usuario.setSexo(comboBoxSexo.getName());
				usuario.setPeso(lblPeso.getText());
				usuario.setAltura(lblAltura.getText());
				usuario.setIdade(lblDataDeNascimento.getText());
				usuario.setCaloriasMeta(lblQualSuaMeta.getText());
				usuario.setObjetivo(lblQualSuaMeta.getText());
				
				try {
					new ControllerUsuario().adicionar(usuario);
					new TelaHome().main(null);
					System.out.println("Nome: " + usuario.getNome());
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Algum campo está vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar usuario");
					e1.printStackTrace();
				}
				
			}
		});
		Cadastrar.setForeground(new Color(255, 255, 255));
		Cadastrar.setBackground(new Color(0, 0, 51));
		Cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Cadastrar.setBounds(446, 652, 89, 30);
		frame.getContentPane().add(Cadastrar);
		
		ConfirmarSenha = new JPasswordField();
		ConfirmarSenha.setBounds(633, 565, 360, 30);
		frame.getContentPane().add(ConfirmarSenha);
		
		Senha = new JPasswordField();
		Senha.setBounds(633, 509, 360, 30);
		frame.getContentPane().add(Senha);
	}
}

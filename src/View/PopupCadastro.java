package View;

import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;


import Controller.ControllerUsuario;
import Model.Usuario;
import Util.DatasFormatadas;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;
import Validation.SenhaInvalidaException;
import Validation.UsuarioDuplicadoException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class PopupCadastro extends LayoutPopup {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupCadastro window = new PopupCadastro();
					window.dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopupCadastro() {
		super("Cadastro - EzHealth");
		configureContent();
	}
		
	public void configureContent() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 71, 700, 590);
		panel.setBackground(Color.decode("#E8EDF3"));
		panel.setLayout(null);
		
		
		// Dados pessoais
		JLabel lblDadosPessoais = new JLabel("Dados pessoais");
		lblDadosPessoais.setVerticalAlignment(SwingConstants.TOP);
		lblDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		lblDadosPessoais.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblDadosPessoais.setBounds(40, 11, 343, 30);
		panel.add(lblDadosPessoais);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNomeCompleto.setBounds(10, 30, 680, 30);
		panel.add(lblNomeCompleto);
		
		JFormattedTextField textFieldNome = new JFormattedTextField();
		textFieldNome.setBounds(114, 52, 463, 30);
		textFieldNome.setColumns(10);
		textFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeNascimento.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(114, 93, 218, 30);
		panel.add(lblDataDeNascimento);
		
		
		JFormattedTextField textFieldNascimento = new JFormattedTextField();
		textFieldNascimento.setColumns(10);
		textFieldNascimento.setBounds(114, 116, 218, 30);
		textFieldNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldNascimento);
		
		try {
			MaskFormatter formatter = new MaskFormatter("##/##/####");
			formatter.setPlaceholderCharacter('_');
			formatter.install(textFieldNascimento);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblSexo.setBounds(114, 156, 218, 30);
		panel.add(lblSexo);
		
		JComboBox<DefaultComboBoxModel<String>> comboBoxSexo = new JComboBox<DefaultComboBoxModel<String>>();
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Feminino", "Maculino"}));
		comboBoxSexo.setMaximumRowCount(2);
		comboBoxSexo.setBounds(114, 175, 218, 30);
		panel.add(comboBoxSexo);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setVerticalAlignment(SwingConstants.TOP);
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblPeso.setBounds(431, 93, 38, 18);
		panel.add(lblPeso);
		
		JLabel lblKg = new JLabel("(Kg)");
		lblKg.setVerticalAlignment(SwingConstants.TOP);
		lblKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblKg.setBounds(477, 97, 31, 15);
		panel.add(lblKg);
		
		JFormattedTextField textFieldPeso = new JFormattedTextField();
		textFieldPeso.setBounds(359, 116, 218, 30);
		textFieldPeso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldPeso);
		
		try {
			MaskFormatter formatter = new MaskFormatter("##.##");
			formatter.setPlaceholder("00.00");
			formatter.install(textFieldPeso);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAltura.setBounds(431, 156, 49, 18);
		panel.add(lblAltura);
		
		JLabel lblKg_2 = new JLabel("(cm)");
		lblKg_2.setVerticalAlignment(SwingConstants.TOP);
		lblKg_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblKg_2.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblKg_2.setBounds(477, 160, 38, 15);
		panel.add(lblKg_2);

		JFormattedTextField textFieldAltura = new JFormattedTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAltura.setBounds(359, 177, 218, 30);
		panel.add(textFieldAltura);
		
		try {
			MaskFormatter formatter = new MaskFormatter("#.##");
			formatter.setPlaceholder("0.00");
			formatter.install(textFieldAltura);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 220, 615, 18);
		panel.add(separator);
		
		
		// Informações médicas e nutricionais
		JLabel lblInformaesNutricionasE = new JLabel("Informa\u00E7\u00F5es nutricionais e m\u00E9dicas");
		lblInformaesNutricionasE.setVerticalAlignment(SwingConstants.TOP);
		lblInformaesNutricionasE.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformaesNutricionasE.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblInformaesNutricionasE.setBounds(40, 232, 343, 30);
		panel.add(lblInformaesNutricionasE);
		
		// Definição de meta 
		JLabel lblQualSuaMeta = new JLabel("Qual sua meta?");
		lblQualSuaMeta.setVerticalAlignment(SwingConstants.TOP);
		lblQualSuaMeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualSuaMeta.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblQualSuaMeta.setBounds(20, 258, 166, 30);
		panel.add(lblQualSuaMeta);
		
		JRadioButton radio_perderPeso = new JRadioButton("Perder Peso");
		radio_perderPeso.setBackground(Color.decode("#E8EDF3"));
		radio_perderPeso.setBounds(40, 282, 109, 23);
		radio_perderPeso.setActionCommand("Perder Peso");
		panel.add(radio_perderPeso);
		
		JRadioButton radio_manterPeso = new JRadioButton("Manter Peso");
		radio_manterPeso.setBackground(Color.decode("#E8EDF3"));
		radio_manterPeso.setBounds(40, 308, 109, 23);
		radio_manterPeso.setActionCommand("Manter Peso");
		radio_manterPeso.setSelected(true);
		panel.add(radio_manterPeso);
		
		JRadioButton radio_ganharPeso = new JRadioButton("Ganhar Peso");
		radio_ganharPeso.setBackground(Color.decode("#E8EDF3"));
		radio_ganharPeso.setActionCommand("Ganhar Peso");
		radio_ganharPeso.setBounds(40, 334, 109, 23);
		panel.add(radio_ganharPeso);
		
		ButtonGroup buttonGroupMeta = new ButtonGroup();
		buttonGroupMeta.add(radio_perderPeso);
		buttonGroupMeta.add(radio_manterPeso);
		buttonGroupMeta.add(radio_ganharPeso);

		
		
		// Definição de doença
		JLabel lblPossuiAlgumaDoena = new JLabel("Possui alguma doen\u00E7a?");
		lblPossuiAlgumaDoena.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaDoena.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaDoena.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblPossuiAlgumaDoena.setBounds(248, 258, 253, 30);
		panel.add(lblPossuiAlgumaDoena);
		
		JCheckBox checkbox_diabetes = new JCheckBox("Diabetes");
		checkbox_diabetes.setBackground(Color.decode("#E8EDF3"));
		checkbox_diabetes.setBounds(290, 297, 109, 23);
		panel.add(checkbox_diabetes);

		JCheckBox checkbox_colesterolAlto = new JCheckBox("Colesterol Alto");
		checkbox_colesterolAlto.setBackground(Color.decode("#E8EDF3"));
		checkbox_colesterolAlto.setBounds(290, 323, 109, 23);
		panel.add(checkbox_colesterolAlto);
		
		// Definição de intolerancia
		JLabel lblPossuiAlgumaIntolerncia = new JLabel("Possui alguma Intoler\u00E2ncia?");
		lblPossuiAlgumaIntolerncia.setVerticalAlignment(SwingConstants.TOP);
		lblPossuiAlgumaIntolerncia.setHorizontalAlignment(SwingConstants.LEFT);
		lblPossuiAlgumaIntolerncia.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblPossuiAlgumaIntolerncia.setBounds(451, 258, 204, 30);
		panel.add(lblPossuiAlgumaIntolerncia);
		
		
		JCheckBox checkbox_lactose = new JCheckBox("Lactose");
		checkbox_lactose.setBackground(Color.decode("#E8EDF3"));
		checkbox_lactose.setBounds(506, 295, 100, 23);
		panel.add(checkbox_lactose);
		
		JCheckBox checkbox_gluten = new JCheckBox("Gluten");
		checkbox_gluten.setBackground(Color.decode("#E8EDF3"));
		checkbox_gluten.setBounds(506, 323, 100, 23);
		panel.add(checkbox_gluten);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 376, 615, 18);
		panel.add(separator_1);
		
		// Dados de acesso
		JLabel lblPreenchaSInformaes = new JLabel("Dados de acesso");
		lblPreenchaSInformaes.setVerticalAlignment(SwingConstants.TOP);
		lblPreenchaSInformaes.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreenchaSInformaes.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblPreenchaSInformaes.setBounds(40, 387, 343, 30);
		panel.add(lblPreenchaSInformaes);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setVerticalAlignment(SwingConstants.TOP);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblSenha.setBounds(114, 469, 218, 30);
		panel.add(lblSenha);
		
		JPasswordField textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(114, 494, 218, 30);
		textFieldSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarSenha.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblConfirmarSenha.setBounds(348, 471, 229, 30);
		panel.add(lblConfirmarSenha);
		
		JPasswordField textFieldConfirmaSenha = new JPasswordField();
		textFieldConfirmaSenha.setBounds(359, 494, 218, 30);
		textFieldConfirmaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldConfirmaSenha);
		
		JLabel lbl_usuario = new JLabel("Usuario");
		lbl_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_usuario.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lbl_usuario.setBounds(214, 405, 253, 23);
		panel.add(lbl_usuario);
		
		JTextField textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(114, 428, 463, 30);
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBackground(new Color(47, 53, 66));
		cadastrar.setForeground(new Color(255, 255, 255));
		cadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadastrar.setBounds(425, 540, 100, 30);
		cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuario = new Usuario();
				usuario.setNome(textFieldNome.getText());
				usuario.setSexo(comboBoxSexo.getSelectedItem().toString());
				usuario.setPeso(textFieldPeso.getText());
				usuario.setAltura(textFieldAltura.getText());

				String[] data = textFieldNascimento.getText().split("/");
				usuario.setDataNascimento(
						LocalDate.of(
							Integer.parseInt(data[2]), 
							Integer.parseInt(data[1]), 
							Integer.parseInt(data[0])));
				usuario.setUsuario(textFieldUsuario.getText());
				usuario.setSenha(String.valueOf(textFieldSenha.getPassword()));
				usuario.setConfirmaSenha(String.valueOf(textFieldConfirmaSenha.getPassword()));
				
				usuario.setObjetivo(buttonGroupMeta.getSelection().getActionCommand());
				
				usuario.setLactose(checkbox_lactose.isSelected());
				usuario.setGluten(checkbox_gluten.isSelected());
				
				usuario.setColesterolAlto(checkbox_colesterolAlto.isSelected());
				usuario.setDiabetes(checkbox_diabetes.isSelected());
				
				try {
					new ControllerUsuario().adicionar(usuario);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					dialog.dispose();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario");
					e1.printStackTrace();
				} catch (DadosVaziosException e1) {
					JOptionPane.showMessageDialog(null, "Algum campo está vazio");
					e1.printStackTrace();
				} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar usuario");
					e1.printStackTrace();
				} catch (SenhaInvalidaException e1) {
					JOptionPane.showMessageDialog(null, "As senhas estão diferentes!");
					e1.printStackTrace();
				} catch (UsuarioDuplicadoException e1) {
					JOptionPane.showMessageDialog(null, "Impossível concluir cadastro! Usuário digitado já esta cadastrado");
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(cadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.decode("#616774"));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(176, 540, 100, 30);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dialog.dispose();
			}
		});
		panel.add(btnCancelar);
		
		
		dialog.getContentPane().add(panel);
	}
	
	public void cadastrar() {
		
	}
}

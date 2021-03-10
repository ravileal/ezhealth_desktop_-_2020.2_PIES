
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

public class TelaMeusDados extends LayoutMain {


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
		frame.setTitle("Meus Dados - EzHealth");
		configureContent();
	}

	private void configureContent() {
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		JLabel lblMeusDadosPessoais = new JLabel("Meus dados Pessoais");
		lblMeusDadosPessoais.setVerticalAlignment(SwingConstants.TOP);
		lblMeusDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeusDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMeusDadosPessoais.setBounds(10, 11, 193, 30);
		panel.add(lblMeusDadosPessoais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 902, 12);
		panel.add(separator);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(85, 104, 52, 30);
		panel.add(lblNome);
		
		JLabel lblNomeCompletoDa = new JLabel("Nome completo da pessoa");
		lblNomeCompletoDa.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompletoDa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompletoDa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompletoDa.setBounds(147, 104, 200, 30);
		panel.add(lblNomeCompletoDa);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(85, 134, 160, 30);
		panel.add(lblDataDeNascimento);
		
		JLabel lblNascimento = new JLabel("dd/mm/aaaa");
		lblNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNascimento.setBounds(235, 134, 200, 30);
		panel.add(lblNascimento);
		
		JLabel lblPe = new JLabel("Peso:");
		lblPe.setVerticalAlignment(SwingConstants.TOP);
		lblPe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPe.setBounds(85, 164, 52, 30);
		panel.add(lblPe);
		
		JLabel lblPesoKg = new JLabel("45 kg");
		lblPesoKg.setVerticalAlignment(SwingConstants.TOP);
		lblPesoKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesoKg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoKg.setBounds(132, 164, 200, 30);
		panel.add(lblPesoKg);
		
		JLabel lblAltu = new JLabel("Altura:");
		lblAltu.setVerticalAlignment(SwingConstants.TOP);
		lblAltu.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltu.setBounds(85, 195, 52, 30);
		panel.add(lblAltu);
		
		JLabel lblAltura = new JLabel("1,65 cm");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltura.setBounds(132, 195, 200, 30);
		panel.add(lblAltura);
		
		JLabel lblMe = new JLabel("Meta:");
		lblMe.setVerticalAlignment(SwingConstants.TOP);
		lblMe.setHorizontalAlignment(SwingConstants.LEFT);
		lblMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMe.setBounds(575, 104, 52, 30);
		panel.add(lblMe);
		
		JLabel lblMeta = new JLabel("Ganhar Peso");
		lblMeta.setVerticalAlignment(SwingConstants.TOP);
		lblMeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta.setBounds(622, 104, 200, 30);
		panel.add(lblMeta);
		
		JLabel lblDoenas = new JLabel("Doen\u00E7as:");
		lblDoenas.setVerticalAlignment(SwingConstants.TOP);
		lblDoenas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoenas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoenas.setBounds(575, 134, 61, 30);
		panel.add(lblDoenas);
		
		JLabel lblMeta_1 = new JLabel("-");
		lblMeta_1.setVerticalAlignment(SwingConstants.TOP);
		lblMeta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta_1.setBounds(646, 134, 200, 30);
		panel.add(lblMeta_1);
		
		JLabel lblIntolerncias = new JLabel("Intoler\u00E2ncias:");
		lblIntolerncias.setVerticalAlignment(SwingConstants.TOP);
		lblIntolerncias.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntolerncias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntolerncias.setBounds(575, 164, 87, 30);
		panel.add(lblIntolerncias);
		
		JLabel lblLactose = new JLabel("Lactose");
		lblLactose.setVerticalAlignment(SwingConstants.TOP);
		lblLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblLactose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLactose.setBounds(672, 164, 200, 30);
		panel.add(lblLactose);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexo.setBounds(85, 223, 52, 30);
		panel.add(lblSexo);
		
		JLabel lblFeminino = new JLabel("Feminino");
		lblFeminino.setVerticalAlignment(SwingConstants.TOP);
		lblFeminino.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeminino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeminino.setBounds(132, 223, 200, 30);
		panel.add(lblFeminino);
		
		JLabel lblNomeemailcom = new JLabel("nome@email.com");
		lblNomeemailcom.setVerticalAlignment(SwingConstants.TOP);
		lblNomeemailcom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeemailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeemailcom.setBounds(624, 195, 200, 30);
		panel.add(lblNomeemailcom);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(575, 195, 52, 30);
		panel.add(lblEmail);
		
		JLabel lblGosatariaDeMudar = new JLabel("Gostaria de mudar algum dado?");
		lblGosatariaDeMudar.setVerticalAlignment(SwingConstants.TOP);
		lblGosatariaDeMudar.setHorizontalAlignment(SwingConstants.LEFT);
		lblGosatariaDeMudar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGosatariaDeMudar.setBounds(367, 312, 231, 30);
		panel.add(lblGosatariaDeMudar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.decode("#2F3542"));
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PopupEditarCadastro();
				PopupEditarCadastro.main(null);
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(427, 353, 89, 30);
		panel.add(btnEditar);
		
		frame.getContentPane().add(panel);
	}
}
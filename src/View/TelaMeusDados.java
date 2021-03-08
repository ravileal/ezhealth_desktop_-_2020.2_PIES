package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class TelaMeusDados {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		frame.setBounds(100, 100, 1014, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 73, 119, 530);
		frame.getContentPane().add(panel);
		
		JLabel labelHome = new JLabel("Home");
		labelHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelHome.setBounds(10, 33, 63, 27);
		panel.add(labelHome);
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaHome().main(null);
			}
		});
		
		JLabel labelRefeicoes = new JLabel("Refei\u00E7\u00F5es ");
		labelRefeicoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelRefeicoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelRefeicoes.setBounds(10, 59, 144, 35);
		panel.add(labelRefeicoes);
		labelRefeicoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaCriarRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel labelPersonalizadas = new JLabel("Personalizadas");
		labelPersonalizadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPersonalizadas.setBounds(10, 80, 86, 27);
		panel.add(labelPersonalizadas);
		labelPersonalizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);
		
		JLabel labelExercicios = new JLabel("Exerc\u00EDcios");
		labelExercicios.setHorizontalAlignment(SwingConstants.LEFT);
		labelExercicios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelExercicios.setBounds(10, 106, 144, 35);
		panel.add(labelExercicios);
		labelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaExercicios().main(null);
			}
		});
		
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
		labelSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
		JLabel lblMeusDadosPessoais = new JLabel("Meus dados Pessoais");
		lblMeusDadosPessoais.setVerticalAlignment(SwingConstants.TOP);
		lblMeusDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeusDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMeusDadosPessoais.setBounds(134, 92, 193, 30);
		frame.getContentPane().add(lblMeusDadosPessoais);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 121, 862, 10);
		frame.getContentPane().add(separator);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(130, 161, 52, 30);
		frame.getContentPane().add(lblNome);
		
		JLabel lblNomeCompletoDa = new JLabel("Nome completo da pessoa");
		lblNomeCompletoDa.setVerticalAlignment(SwingConstants.TOP);
		lblNomeCompletoDa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCompletoDa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompletoDa.setBounds(192, 161, 200, 30);
		frame.getContentPane().add(lblNomeCompletoDa);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(130, 191, 160, 30);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblNascimento = new JLabel("dd/mm/aaaa");
		lblNascimento.setVerticalAlignment(SwingConstants.TOP);
		lblNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNascimento.setBounds(280, 191, 200, 30);
		frame.getContentPane().add(lblNascimento);
		
		JLabel lblPe = new JLabel("Peso:");
		lblPe.setVerticalAlignment(SwingConstants.TOP);
		lblPe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPe.setBounds(130, 221, 52, 30);
		frame.getContentPane().add(lblPe);
		
		JLabel lblPesoKg = new JLabel("45 kg");
		lblPesoKg.setVerticalAlignment(SwingConstants.TOP);
		lblPesoKg.setHorizontalAlignment(SwingConstants.LEFT);
		lblPesoKg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPesoKg.setBounds(177, 221, 200, 30);
		frame.getContentPane().add(lblPesoKg);
		
		JLabel lblAltu = new JLabel("Altura:");
		lblAltu.setVerticalAlignment(SwingConstants.TOP);
		lblAltu.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltu.setBounds(130, 252, 52, 30);
		frame.getContentPane().add(lblAltu);
		
		JLabel lblAltura = new JLabel("1,65 cm");
		lblAltura.setVerticalAlignment(SwingConstants.TOP);
		lblAltura.setHorizontalAlignment(SwingConstants.LEFT);
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAltura.setBounds(177, 252, 200, 30);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblMe = new JLabel("Meta:");
		lblMe.setVerticalAlignment(SwingConstants.TOP);
		lblMe.setHorizontalAlignment(SwingConstants.LEFT);
		lblMe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMe.setBounds(620, 161, 52, 30);
		frame.getContentPane().add(lblMe);
		
		JLabel lblMeta = new JLabel("Ganhar Peso");
		lblMeta.setVerticalAlignment(SwingConstants.TOP);
		lblMeta.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta.setBounds(667, 161, 200, 30);
		frame.getContentPane().add(lblMeta);
		
		JLabel lblDoenas = new JLabel("Doen\u00E7as:");
		lblDoenas.setVerticalAlignment(SwingConstants.TOP);
		lblDoenas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoenas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDoenas.setBounds(620, 191, 61, 30);
		frame.getContentPane().add(lblDoenas);
		
		JLabel lblMeta_1 = new JLabel("-");
		lblMeta_1.setVerticalAlignment(SwingConstants.TOP);
		lblMeta_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMeta_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMeta_1.setBounds(691, 191, 200, 30);
		frame.getContentPane().add(lblMeta_1);
		
		JLabel lblIntolerncias = new JLabel("Intoler\u00E2ncias:");
		lblIntolerncias.setVerticalAlignment(SwingConstants.TOP);
		lblIntolerncias.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntolerncias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntolerncias.setBounds(620, 221, 87, 30);
		frame.getContentPane().add(lblIntolerncias);
		
		JLabel lblLactose = new JLabel("Lactose");
		lblLactose.setVerticalAlignment(SwingConstants.TOP);
		lblLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblLactose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLactose.setBounds(717, 221, 200, 30);
		frame.getContentPane().add(lblLactose);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setVerticalAlignment(SwingConstants.TOP);
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexo.setBounds(130, 280, 52, 30);
		frame.getContentPane().add(lblSexo);
		
		JLabel lblFeminino = new JLabel("Feminino");
		lblFeminino.setVerticalAlignment(SwingConstants.TOP);
		lblFeminino.setHorizontalAlignment(SwingConstants.LEFT);
		lblFeminino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeminino.setBounds(177, 280, 200, 30);
		frame.getContentPane().add(lblFeminino);
		
		JLabel lblNomeemailcom = new JLabel("nome@email.com");
		lblNomeemailcom.setVerticalAlignment(SwingConstants.TOP);
		lblNomeemailcom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeemailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeemailcom.setBounds(669, 252, 200, 30);
		frame.getContentPane().add(lblNomeemailcom);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setVerticalAlignment(SwingConstants.TOP);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(620, 252, 52, 30);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblGosatariaDeMudar = new JLabel("Gostaria de mudar algum dado?");
		lblGosatariaDeMudar.setVerticalAlignment(SwingConstants.TOP);
		lblGosatariaDeMudar.setHorizontalAlignment(SwingConstants.LEFT);
		lblGosatariaDeMudar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGosatariaDeMudar.setBounds(425, 445, 231, 30);
		frame.getContentPane().add(lblGosatariaDeMudar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaEditarCadastro().main(null);
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBackground(new Color(0, 0, 51));
		btnEditar.setBounds(475, 474, 89, 30);
		frame.getContentPane().add(btnEditar);
	}
}

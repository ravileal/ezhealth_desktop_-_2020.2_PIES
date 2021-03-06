package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JScrollPane;

public class TelaRefeicoes {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRefeicoes window = new TelaRefeicoes();
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
	public TelaRefeicoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 73, 119, 474);
		frame.getContentPane().add(panel);
		
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
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		
		JLabel labelNomeRefeicao = new JLabel("Caf\u00E9 da Manh\u00E3");
		labelNomeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelNomeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNomeRefeicao.setBounds(136, 91, 113, 30);
		frame.getContentPane().add(labelNomeRefeicao);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(136, 112, 92, 30);
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 153, 872, 2);
		frame.getContentPane().add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBackground(SystemColor.control);
		buttonVoltar.setBounds(908, 101, 70, 22);
		frame.getContentPane().add(buttonVoltar);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(136, 181, 141, 30);
		frame.getContentPane().add(lblListaDeAlimentos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 458, 429, -223);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblVerTabelaNutricional = new JLabel("Ver tabela nutricional");
		lblVerTabelaNutricional.setVerticalAlignment(SwingConstants.TOP);
		lblVerTabelaNutricional.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerTabelaNutricional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVerTabelaNutricional.setBounds(136, 494, 169, 30);
		frame.getContentPane().add(lblVerTabelaNutricional);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(460, 494, 70, 22);
		frame.getContentPane().add(buttonSalvar);
		
		JLabel labelAlimento = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelAlimento.setBounds(136, 236, 200, 30);
		frame.getContentPane().add(labelAlimento);
	}
}

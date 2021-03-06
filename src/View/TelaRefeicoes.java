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
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;

public class TelaRefeicoes {

	private JFrame frame;
	private JTextField txtPesquise;

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
		panel_1.setBounds(0, 0, 1014, 73);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		frame.getContentPane().add(panel_1);
		
		Panel panel = new Panel();
		panel.setBounds(0, 73, 119, 474);
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
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
		labelNomeRefeicao.setBounds(136, 91, 113, 30);
		labelNomeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelNomeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(labelNomeRefeicao);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setBounds(136, 112, 92, 30);
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 153, 872, 2);
		frame.getContentPane().add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBounds(908, 101, 70, 22);
		buttonVoltar.setBackground(SystemColor.control);
		frame.getContentPane().add(buttonVoltar);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setBounds(136, 181, 141, 30);
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblListaDeAlimentos);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBounds(136, 503, 70, 22);
		buttonSalvar.setBackground(SystemColor.menu);
		frame.getContentPane().add(buttonSalvar);
		
		JLabel lblAdicionarAlimentos = new JLabel("Adicionar Alimentos ou Refei\u00E7\u00F5es Personalizadas");
		lblAdicionarAlimentos.setBounds(643, 181, 354, 30);
		lblAdicionarAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblAdicionarAlimentos);
		
		txtPesquise = new JTextField();
		txtPesquise.setBounds(643, 231, 335, 35);
		txtPesquise.setForeground(SystemColor.scrollbar);
		txtPesquise.setToolTipText("Pesquisar");
		txtPesquise.setText("Pesquisar Alimentos/Refei\u00E7\u00F5es");
		frame.getContentPane().add(txtPesquise);
		txtPesquise.setColumns(10);
		
		JLabel lblUltimasPesquisas = new JLabel("Ultimas pesquisas");
		lblUltimasPesquisas.setBounds(643, 308, 354, 30);
		lblUltimasPesquisas.setVerticalAlignment(SwingConstants.TOP);
		lblUltimasPesquisas.setHorizontalAlignment(SwingConstants.LEFT);
		lblUltimasPesquisas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblUltimasPesquisas);
		
		JScrollPane scrollPaneUltimasPesquisas = new JScrollPane();
		scrollPaneUltimasPesquisas.setBounds(642, 336, 344, 188);
		frame.getContentPane().add(scrollPaneUltimasPesquisas);
		
		JLabel labelAlimento_1 = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneUltimasPesquisas.setColumnHeaderView(labelAlimento_1);
		
		JScrollPane scrollPaneListaAlimentos = new JScrollPane();
		scrollPaneListaAlimentos.setBounds(135, 222, 395, 242);
		frame.getContentPane().add(scrollPaneListaAlimentos);
		
		JLabel labelAlimento = new JLabel("Suco de uva    200ml - 300kcal");
		scrollPaneListaAlimentos.setColumnHeaderView(labelAlimento);
		labelAlimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}

package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TelaCriarRefeicoesPersonalizadas {

	private JFrame frame;
	private JTextField txtPesquisarAlimentos;
	private JTextField txtEditarNomeRefeio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarRefeicoesPersonalizadas window = new TelaCriarRefeicoesPersonalizadas();
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
	public TelaCriarRefeicoesPersonalizadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1023, 578);
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
		
		JLabel lblCriarNovaRefeio = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		lblCriarNovaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblCriarNovaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriarNovaRefeio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCriarNovaRefeio.setBounds(136, 91, 253, 30);
		frame.getContentPane().add(lblCriarNovaRefeio);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(908, 101, 70, 22);
		frame.getContentPane().add(buttonVoltar);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas().main(null);
			}
		});
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 153, 872, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(643, 181, 354, 30);
		frame.getContentPane().add(lblAdicionarAlimentosNa);
		
		txtPesquisarAlimentos = new JTextField();
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setText("Pesquisar Alimentos");
		txtPesquisarAlimentos.setForeground(SystemColor.scrollbar);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(643, 231, 335, 35);
		frame.getContentPane().add(txtPesquisarAlimentos);
		
		JLabel lblUltimasPesquisas = new JLabel("Ultimas pesquisas");
		lblUltimasPesquisas.setVerticalAlignment(SwingConstants.TOP);
		lblUltimasPesquisas.setHorizontalAlignment(SwingConstants.LEFT);
		lblUltimasPesquisas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUltimasPesquisas.setBounds(643, 308, 354, 30);
		frame.getContentPane().add(lblUltimasPesquisas);
		
		JScrollPane scrollPaneUltimasPesquisas = new JScrollPane();
		scrollPaneUltimasPesquisas.setBounds(642, 336, 344, 188);
		frame.getContentPane().add(scrollPaneUltimasPesquisas);
		
		JLabel labelAlimento_1_1 = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneUltimasPesquisas.setColumnHeaderView(labelAlimento_1_1);
		
		JLabel labelAlimento_2 = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento_2.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneUltimasPesquisas.setColumnHeaderView(labelAlimento_2);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(136, 503, 70, 22);
		frame.getContentPane().add(buttonSalvar);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(136, 181, 141, 30);
		frame.getContentPane().add(lblListaDeAlimentos);
		
		JScrollPane scrollPaneListaAlimentos = new JScrollPane();
		scrollPaneListaAlimentos.setBounds(135, 222, 395, 242);
		frame.getContentPane().add(scrollPaneListaAlimentos);
		
		JLabel labelAlimento_1 = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento_1.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneListaAlimentos.setColumnHeaderView(labelAlimento_1);
		
		JLabel labelAlimento = new JLabel("Suco de uva    200ml - 300kcal");
		labelAlimento.setHorizontalAlignment(SwingConstants.LEFT);
		labelAlimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneListaAlimentos.setColumnHeaderView(labelAlimento);
		
		txtEditarNomeRefeio = new JTextField();
		txtEditarNomeRefeio.setToolTipText("Pesquisar");
		txtEditarNomeRefeio.setText("Editar nome refei\u00E7\u00E3o");
		txtEditarNomeRefeio.setForeground(SystemColor.scrollbar);
		txtEditarNomeRefeio.setColumns(10);
		txtEditarNomeRefeio.setBounds(136, 120, 241, 22);
		frame.getContentPane().add(txtEditarNomeRefeio);
	}
}

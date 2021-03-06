package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TelaRefeicoesPersonalizadas {

	private JFrame frame;
	private JTextField txtPesquisarAlimentosPara;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRefeicoesPersonalizadas window = new TelaRefeicoesPersonalizadas();
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
	public TelaRefeicoesPersonalizadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBuscarAlimentos = new JLabel("Buscar Alimentos");
		lblBuscarAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarAlimentos.setBounds(136, 184, 354, 30);
		frame.getContentPane().add(lblBuscarAlimentos);
		
		txtPesquisarAlimentosPara = new JTextField();
		txtPesquisarAlimentosPara.setToolTipText("Pesquisar");
		txtPesquisarAlimentosPara.setText("Pesquisar Alimentos para adicionar");
		txtPesquisarAlimentosPara.setForeground(SystemColor.scrollbar);
		txtPesquisarAlimentosPara.setColumns(10);
		txtPesquisarAlimentosPara.setBounds(136, 228, 814, 35);
		frame.getContentPane().add(txtPesquisarAlimentosPara);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
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
		
		JLabel labeRefeicao = new JLabel("Refei\u00E7\u00F5es Personalizadas");
		labeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labeRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeRefeicao.setBounds(136, 91, 193, 30);
		frame.getContentPane().add(labeRefeicao);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(136, 112, 92, 30);
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 153, 872, 2);
		frame.getContentPane().add(separator);
		
		JLabel labelCriarRefeicao = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		labelCriarRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelCriarRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelCriarRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCriarRefeicao.setBounds(155, 555, 354, 30);
		frame.getContentPane().add(labelCriarRefeicao);
		labelCriarRefeicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaCriarRefeicoesPersonalizadas().main(null);
			}
		});
		
		JLabel lblBuscarAlimentos_2 = new JLabel("+");
		lblBuscarAlimentos_2.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarAlimentos_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarAlimentos_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscarAlimentos_2.setBounds(136, 551, 354, 30);
		frame.getContentPane().add(lblBuscarAlimentos_2);
		
		JScrollPane scrollPaneRefeicoes = new JScrollPane();
		scrollPaneRefeicoes.setBounds(140, 290, 810, 229);
		frame.getContentPane().add(scrollPaneRefeicoes);
		
		JLabel labelArrayRefeicoesProntas = new JLabel("Refei\u00E7\u00E3o 01     200g - 300kcal");
		labelArrayRefeicoesProntas.setVerticalAlignment(SwingConstants.TOP);
		labelArrayRefeicoesProntas.setHorizontalAlignment(SwingConstants.LEFT);
		labelArrayRefeicoesProntas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPaneRefeicoes.setColumnHeaderView(labelArrayRefeicoesProntas);
	}
}
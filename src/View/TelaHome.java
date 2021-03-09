package View;

import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Panel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.JPanel;

public class TelaHome extends LayoutMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaHome window = new TelaHome();
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
	public TelaHome() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Home - EzHealth");
		frame.getContentPane().add(configurePanelContent());
	}
	
	private JPanel configurePanelContent() {
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
				
		this.configureData(panel);
		this.configurePanelCalorias(panel);
		this.configureButtonsRefeicoes(panel);
		
		return panel;
	}
	
	private void configureData(JPanel panel_content) {
		JLabel labelMes = new JLabel("Fevereiro 2021");
		labelMes.setBounds(20, 11, 125, 45);
		panel_content.add(labelMes);
		labelMes.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		
		JLabel labelData = new JLabel("Segunda - 10/02");
		labelData.setBounds(20, 43, 125, 22);
		panel_content.add(labelData);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
	}
	
	
	private void configurePanelCalorias(JPanel panel_content) {
		Panel panel = new Panel();
		panel.setBounds(296, 90, 334, 139);
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel.setBackground(Color.decode("#CED6E0"));
		panel.setLayout(null);
		
		JLabel lbl_calorias_title = new JLabel("Calorias");
		lbl_calorias_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lbl_calorias_title.setBounds(144, 11, 68, 34);
		panel.add(lbl_calorias_title);
		
		JLabel lbl_caloriasConsumir_title = new JLabel("Consumir");
		lbl_caloriasConsumir_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasConsumir_title.setBounds(144, 48, 68, 45);
		panel.add(lbl_caloriasConsumir_title);
		
		JLabel lbl_caloriasConsumir = new JLabel("0 kcal");
		lbl_caloriasConsumir.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasConsumir.setBounds(154, 72, 68, 45);
		panel.add(lbl_caloriasConsumir);
		
		JLabel lbl_caloriasConsumidas_title = new JLabel("Consumidas");
		lbl_caloriasConsumidas_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasConsumidas_title.setBounds(23, 42, 88, 45);
		panel.add(lbl_caloriasConsumidas_title);
		
		JLabel lbl_caloriasConsumidas = new JLabel("0 kcal");
		lbl_caloriasConsumidas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasConsumidas.setBounds(44, 87, 46, 14);
		panel.add(lbl_caloriasConsumidas);
		
		JLabel lbl_caloriasGastas_title = new JLabel("Gastas");
		lbl_caloriasGastas_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 14));
		lbl_caloriasGastas_title.setBounds(256, 42, 88, 45);
		panel.add(lbl_caloriasGastas_title);
		
		JLabel lbl_caloriasGastas = new JLabel("0 kcal");
		lbl_caloriasGastas.setFont(new Font("Quicksand Medium", Font.PLAIN, 12));
		lbl_caloriasGastas.setBounds(263, 87, 46, 14);
		panel.add(lbl_caloriasGastas);
		
		panel_content.add(panel);
	}
	
	public void configureButtonsRefeicoes(JPanel panel_content) {
		// titulo e refeições
		JLabel lbl_refeicao_title = new JLabel("Refei\u00E7\u00F5es");
		lbl_refeicao_title.setBounds(32, 291, 125, 33);
		panel_content.add(lbl_refeicao_title);
		lbl_refeicao_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		
		// Café da manhã
		JPanel panel_cafeManha = new JPanel();
		panel_cafeManha.setBounds(32, 342, 258, 53);
		panel_content.add(panel_cafeManha);
		panel_cafeManha.setBackground(Color.decode("#CED6E0"));
		panel_cafeManha.setLayout(null);
		
		JLabel labelCaloriasManha = new JLabel("0 kcal");
		labelCaloriasManha.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasManha.setBounds(103, 30, 46, 14);
		panel_cafeManha.add(labelCaloriasManha);
		
		JLabel labelCafedaManha = new JLabel("Caf\u00E9 da Manh\u00E3");
		labelCafedaManha.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelCafedaManha.setBounds(65, 0, 125, 33);
		panel_cafeManha.add(labelCafedaManha);
		
		
		JLabel labelAdicionarCafe = new JLabel("+");
		labelAdicionarCafe.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarCafe.setBounds(217, 11, 20, 25);
		panel_cafeManha.add(labelAdicionarCafe);
		labelAdicionarCafe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da manhã
		JPanel panel_lancheManha = new JPanel();
		panel_lancheManha.setBounds(332, 342, 258, 53);
		panel_content.add(panel_lancheManha);
		panel_lancheManha.setLayout(null);
		panel_lancheManha.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasLancheManha = new JLabel("0 kcal");
		labelCaloriasLancheManha.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheManha.setBounds(103, 30, 46, 14);
		panel_lancheManha.add(labelCaloriasLancheManha);
		
		JLabel labelLancheManha = new JLabel("Lanche da manh\u00E3");
		labelLancheManha.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelLancheManha.setBounds(65, 0, 149, 33);
		panel_lancheManha.add(labelLancheManha);
		
		JLabel labelAdicionarLancheManha = new JLabel("+");
		labelAdicionarLancheManha.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheManha.setBounds(217, 11, 20, 25);
		panel_lancheManha.add(labelAdicionarLancheManha);
		labelAdicionarLancheManha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Almoço
		JPanel panel_almoco = new JPanel();
		panel_almoco.setBounds(634, 342, 258, 53);
		panel_content.add(panel_almoco);
		panel_almoco.setLayout(null);
		panel_almoco.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasAlmoco = new JLabel("0 kcal");
		labelCaloriasAlmoco.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasAlmoco.setBounds(103, 30, 46, 14);
		panel_almoco.add(labelCaloriasAlmoco);
		
		JLabel labelAlmoco = new JLabel("Almo\u00E7o");
		labelAlmoco.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelAlmoco.setBounds(91, 0, 125, 33);
		panel_almoco.add(labelAlmoco);
		
		JLabel labelAdicionarAlmoco = new JLabel("+");
		labelAdicionarAlmoco.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarAlmoco.setBounds(217, 11, 20, 25);
		panel_almoco.add(labelAdicionarAlmoco);
		labelAdicionarAlmoco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da tarde
		JPanel panel_lancheTarde = new JPanel();
		panel_lancheTarde.setBackground(Color.decode("#CED6E0"));
		panel_lancheTarde.setBounds(32, 422, 258, 53);
		panel_lancheTarde.setLayout(null);
		panel_content.add(panel_lancheTarde);
		
		JLabel labelCaloriasLancheTarde = new JLabel("0 kcal");
		labelCaloriasLancheTarde.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheTarde.setBounds(103, 30, 46, 14);
		panel_lancheTarde.add(labelCaloriasLancheTarde);
		
		JLabel labelLancheTarde = new JLabel("Lanche da tarde");
		labelLancheTarde.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelLancheTarde.setBounds(56, 0, 125, 33);
		panel_lancheTarde.add(labelLancheTarde);
		
		JLabel labelAdicionarLancheTarde = new JLabel("+");
		labelAdicionarLancheTarde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		labelAdicionarLancheTarde.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheTarde.setBounds(217, 11, 20, 25);
		panel_lancheTarde.add(labelAdicionarLancheTarde);
		
		
		// Janta
		JPanel panel_janta = new JPanel();
		panel_janta.setBounds(332, 422, 258, 53);
		panel_content.add(panel_janta);
		panel_janta.setLayout(null);
		panel_janta.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasJanta = new JLabel("0 kcal");
		labelCaloriasJanta.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasJanta.setBounds(103, 30, 46, 14);
		panel_janta.add(labelCaloriasJanta);
		
		JLabel labelJanta = new JLabel("Janta");
		labelJanta.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		labelJanta.setBounds(98, 0, 51, 33);
		panel_janta.add(labelJanta);
		
		JLabel labelAdicionarJanta = new JLabel("+");
		labelAdicionarJanta.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarJanta.setBounds(217, 11, 20, 25);
		panel_janta.add(labelAdicionarJanta);
		labelAdicionarJanta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});
		
		// Lanche da noite
		JPanel panel_lancheNoite = new JPanel();
		panel_lancheNoite.setBounds(634, 422, 258, 53);
		panel_content.add(panel_lancheNoite);
		panel_lancheNoite.setLayout(null);
		panel_lancheNoite.setBackground(Color.decode("#CED6E0"));
		
		JLabel labelCaloriasLancheNoite = new JLabel("0 kcal");
		labelCaloriasLancheNoite.setFont(new Font("Quicksand Light", Font.PLAIN, 11));
		labelCaloriasLancheNoite.setBounds(103, 30, 46, 14);
		panel_lancheNoite.add(labelCaloriasLancheNoite);
		
		JLabel LancheNoite = new JLabel("Lanche da noite");
		LancheNoite.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		LancheNoite.setBounds(50, 0, 125, 33);
		panel_lancheNoite.add(LancheNoite);
		
		JLabel labelAdicionarLancheNoite = new JLabel("+");
		labelAdicionarLancheNoite.setFont(new Font("Quicksand Light", Font.PLAIN, 20));
		labelAdicionarLancheNoite.setBounds(217, 11, 20, 25);
		panel_lancheNoite.add(labelAdicionarLancheNoite);
		labelAdicionarLancheNoite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaAlimentos.main(null);
			}
		});

	}

}

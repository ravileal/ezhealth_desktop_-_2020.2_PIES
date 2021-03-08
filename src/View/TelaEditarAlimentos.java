package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class TelaEditarAlimentos {

	private JFrame frame;
	private JTextField textFieldQuantidadedoAlimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarAlimentos window = new TelaEditarAlimentos();
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
	public TelaEditarAlimentos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
		JLabel lblData = new JLabel("Alimento x");
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(31, 84, 177, 30);
		frame.getContentPane().add(lblData);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(31, 105, 92, 30);
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 146, 960, 2);
		frame.getContentPane().add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaEditarRefeicaoPersonalizada().main(null);
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(910, 92, 70, 22);
		frame.getContentPane().add(buttonVoltar);
		
		JLabel lblAlimentoX = new JLabel("Quantidade");
		lblAlimentoX.setVerticalAlignment(SwingConstants.TOP);
		lblAlimentoX.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlimentoX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlimentoX.setBounds(20, 183, 141, 30);
		frame.getContentPane().add(lblAlimentoX);
		
		textFieldQuantidadedoAlimento = new JTextField();
		textFieldQuantidadedoAlimento.setBounds(119, 185, 86, 20);
		frame.getContentPane().add(textFieldQuantidadedoAlimento);
		textFieldQuantidadedoAlimento.setColumns(10);
		
		JLabel lblG = new JLabel("g");
		lblG.setVerticalAlignment(SwingConstants.TOP);
		lblG.setHorizontalAlignment(SwingConstants.LEFT);
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblG.setBounds(210, 183, 92, 30);
		frame.getContentPane().add(lblG);
		
		JLabel lblseTiverLactose = new JLabel("*se tiver lactose, aparece aqui");
		lblseTiverLactose.setForeground(Color.RED);
		lblseTiverLactose.setVerticalAlignment(SwingConstants.TOP);
		lblseTiverLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblseTiverLactose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblseTiverLactose.setBounds(20, 224, 248, 30);
		frame.getContentPane().add(lblseTiverLactose);
		
		JLabel lblCaloriasTotais = new JLabel("Calorias totais:");
		lblCaloriasTotais.setVerticalAlignment(SwingConstants.TOP);
		lblCaloriasTotais.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriasTotais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaloriasTotais.setBounds(20, 359, 141, 30);
		frame.getContentPane().add(lblCaloriasTotais);
		
		JLabel lblkcal = new JLabel("500kcal");
		lblkcal.setVerticalAlignment(SwingConstants.TOP);
		lblkcal.setHorizontalAlignment(SwingConstants.LEFT);
		lblkcal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblkcal.setBounds(137, 359, 141, 30);
		frame.getContentPane().add(lblkcal);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(449, 459, 70, 22);
		frame.getContentPane().add(buttonSalvar);
	}
}

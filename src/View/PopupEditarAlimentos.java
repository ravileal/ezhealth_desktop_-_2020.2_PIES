package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Util.ViewUtils;

import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class PopupEditarAlimentos {

	private JFrame frame;
	private JTextField textFieldQuantidadedoAlimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupEditarAlimentos window = new PopupEditarAlimentos();
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
	public PopupEditarAlimentos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1053, 550);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#2F3542"));
		panel.setBounds(0, 0, 1058, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);	
		
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#2F3542", "#FFFFFF", true);
		
		JLabel lblImgHospital = new JLabel(""); 
		lblImgHospital.setBounds(43, 24, 52, 51);
		
		new ViewUtils().setImageInLabel("/Images/hospital.png", lblImgHospital, panel);
		
		JLabel lblNewLabel_title = new JLabel("EZHEALTH");
		lblNewLabel_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 16));
		lblNewLabel_title.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_title.setBounds(112, 37, 96, 25);
		panel.add(lblNewLabel_title);
		
		JLabel lblImgMinhaConta = new JLabel(""); 
		lblImgMinhaConta.setBounds(930, 29, 39, 40);
		
		new ViewUtils().setImageInLabel("/Images/accountWhite.png", lblImgMinhaConta, panel);
		
		JLabel lblNewLabel_minhaConta = new JLabel("<html>Minha<br>Conta</html>");
		lblNewLabel_minhaConta.setFont(new Font("Quicksand Medium", Font.PLAIN, 18));
		lblNewLabel_minhaConta.setForeground(Color.decode("#A4B0BE"));
		lblNewLabel_minhaConta.setBounds(978, 24, 70, 51);
		panel.add(lblNewLabel_minhaConta);
		
		JLabel lblData = new JLabel("Alimento x");
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(30, 97, 177, 30);
		frame.getContentPane().add(lblData);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(30, 118, 92, 30);
		frame.getContentPane().add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 146, 1017, 2);
		frame.getContentPane().add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaEditarRefeicaoPersonalizada();
				TelaEditarRefeicaoPersonalizada.main(null);
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(948, 105, 70, 22);
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

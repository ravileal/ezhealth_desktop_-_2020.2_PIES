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

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JSeparator;

public class TelaEditarExercicios {

	private JFrame frame;
	private JTextField textFieldMinutosExercicios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaEditarExercicios window = new TelaEditarExercicios();
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
	public TelaEditarExercicios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1057, 563);
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
		
		JLabel lblExercicioX = new JLabel("Exercicio  x");
		lblExercicioX.setVerticalAlignment(SwingConstants.TOP);
		lblExercicioX.setHorizontalAlignment(SwingConstants.LEFT);
		lblExercicioX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExercicioX.setBounds(30, 97, 177, 30);
		frame.getContentPane().add(lblExercicioX);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(30, 118, 92, 30);
		frame.getContentPane().add(labelData);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaExercicios();
				TelaExercicios.main(null);
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(976, 105, 70, 22);
		frame.getContentPane().add(buttonVoltar);
		
		JLabel lblMinutos = new JLabel("Minutos praticados");
		lblMinutos.setVerticalAlignment(SwingConstants.TOP);
		lblMinutos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMinutos.setBounds(20, 183, 141, 30);
		frame.getContentPane().add(lblMinutos);
		
		textFieldMinutosExercicios = new JTextField();
		textFieldMinutosExercicios.setColumns(10);
		textFieldMinutosExercicios.setBounds(164, 185, 86, 20);
		frame.getContentPane().add(textFieldMinutosExercicios);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setVerticalAlignment(SwingConstants.TOP);
		lblMin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMin.setBounds(255, 183, 92, 30);
		frame.getContentPane().add(lblMin);
		
		JLabel lblCaloriasTotaisGastas = new JLabel("Calorias totais gastas:");
		lblCaloriasTotaisGastas.setVerticalAlignment(SwingConstants.TOP);
		lblCaloriasTotaisGastas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriasTotaisGastas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaloriasTotaisGastas.setBounds(20, 359, 155, 30);
		frame.getContentPane().add(lblCaloriasTotaisGastas);
		
		JLabel lblkcal = new JLabel("500kcal");
		lblkcal.setVerticalAlignment(SwingConstants.TOP);
		lblkcal.setHorizontalAlignment(SwingConstants.LEFT);
		lblkcal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblkcal.setBounds(185, 359, 141, 30);
		frame.getContentPane().add(lblkcal);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(449, 459, 70, 22);
		frame.getContentPane().add(buttonSalvar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 146, 1026, 2);
		frame.getContentPane().add(separator);
	}

}

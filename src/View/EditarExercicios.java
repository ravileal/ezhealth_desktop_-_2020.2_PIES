package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JSeparator;

public class EditarExercicios {

	private JFrame frame;
	private JTextField textFieldMinutosExercicios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarExercicios window = new EditarExercicios();
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
	public EditarExercicios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		
		JLabel lblExercicioX = new JLabel("Exercicio  x");
		lblExercicioX.setVerticalAlignment(SwingConstants.TOP);
		lblExercicioX.setHorizontalAlignment(SwingConstants.LEFT);
		lblExercicioX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExercicioX.setBounds(31, 84, 177, 30);
		frame.getContentPane().add(lblExercicioX);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(31, 105, 92, 30);
		frame.getContentPane().add(labelData);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new ().main(null);
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(910, 92, 70, 22);
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
		separator.setBounds(20, 146, 960, 2);
		frame.getContentPane().add(separator);
	}

}

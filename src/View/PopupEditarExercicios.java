package View;

import java.awt.EventQueue;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Model.Alimento;
import Model.Exercicio;
import Util.DatasFormatadas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class PopupEditarExercicios extends LayoutPopup {
	
	private Exercicio exercicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupEditarExercicios window = new PopupEditarExercicios();
					window.dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 */
	public static void main(Exercicio exercicio) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try { 
					PopupEditarExercicios window = new PopupEditarExercicios(exercicio);
					window.dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopupEditarExercicios() {
		super("Editar Exercicio - EzHealth");
		configureContent();
	}
	/**
	 * Create the application.
	 */
	public PopupEditarExercicios(Exercicio exercicio) {
		super("Editar Exercicio - EzHealth");
		this.exercicio = exercicio;
		configureContent();
	}

	/**
	 * Initialize the contents of the dialog.
	 */
	private void configureContent() {
		
		Panel panel = new Panel();
		panel.setBounds(0, 71, 700, 590);
		panel.setBackground(Color.decode("#E8EDF3"));
		panel.setLayout(null);
				
		JLabel lblExercicioX = new JLabel("Exercicio "+exercicio.getNome());
		lblExercicioX.setVerticalAlignment(SwingConstants.TOP);
		lblExercicioX.setHorizontalAlignment(SwingConstants.LEFT);
		lblExercicioX.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblExercicioX.setBounds(10, 11, 177, 30);
		panel.add(lblExercicioX);
		
		DatasFormatadas dataFormatada = new DatasFormatadas(exercicio.getData());
		JLabel labelData = new JLabel(dataFormatada.getDiaSemana() +  " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		labelData.setBounds(590, 13, 100, 30);
		panel.add(labelData);
		
		JLabel lblMinutos = new JLabel("Minutos praticados");
		lblMinutos.setVerticalAlignment(SwingConstants.TOP);
		lblMinutos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinutos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblMinutos.setBounds(86, 69, 141, 30);
		panel.add(lblMinutos);
		
		JTextField textFieldMinutosExercicios = new JTextField();
		textFieldMinutosExercicios.setText(exercicio.getDuracao());
		textFieldMinutosExercicios.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		textFieldMinutosExercicios.setColumns(10);
		textFieldMinutosExercicios.setBounds(86, 94, 169, 30);
		panel.add(textFieldMinutosExercicios);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setVerticalAlignment(SwingConstants.TOP);
		lblMin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMin.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblMin.setBounds(259, 101, 30, 14);
		panel.add(lblMin);
		
		JLabel lblCaloriasTotaisGastas = new JLabel("Calorias totais gastas:");
		lblCaloriasTotaisGastas.setVerticalAlignment(SwingConstants.TOP);
		lblCaloriasTotaisGastas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriasTotaisGastas.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblCaloriasTotaisGastas.setBounds(397, 69, 169, 30);
		panel.add(lblCaloriasTotaisGastas);
		
		JLabel lblkcal = new JLabel("kcal");
		lblkcal.setVerticalAlignment(SwingConstants.TOP);
		lblkcal.setHorizontalAlignment(SwingConstants.LEFT);
		lblkcal.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblkcal.setBounds(576, 101, 61, 22);
		panel.add(lblkcal);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 680, 2);
		panel.add(separator);
		
		
		JTextField textField_caloriasTotais = new JTextField();
		textField_caloriasTotais.setText(String.valueOf(exercicio.getCalorias()));
		textField_caloriasTotais.setEnabled(false);
		textField_caloriasTotais.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		textField_caloriasTotais.setColumns(10);
		textField_caloriasTotais.setBounds(396, 94, 170, 30);
		panel.add(textField_caloriasTotais);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dialog.dispose();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBackground(new Color(97, 103, 116));
		btnCancelar.setBounds(204, 167, 100, 30);
		panel.add(btnCancelar);
		
		JButton salvar = new JButton("Salvar");
		salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String kcal = textField_caloriasTotais.getText();
				exercicio.setCalorias(Integer.parseInt(kcal));
				String qtd = textFieldMinutosExercicios.getText();
				exercicio.setDuracao(qtd);
				JOptionPane.showMessageDialog(null, "Exercicio atualizado");
				dialog.dispose();
			}
		});
		salvar.setForeground(Color.WHITE);
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salvar.setBackground(new Color(47, 53, 66));
		salvar.setBounds(343, 167, 100, 30);
		panel.add(salvar);
		
		dialog.getContentPane().add(panel);
	}
}

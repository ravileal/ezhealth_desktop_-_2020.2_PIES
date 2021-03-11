package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
import javax.swing.JButton;

public class PopupEditarAlimentos extends LayoutPopup {
	private JTextField txt_kcal;

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
		super("Editar Alimento - EzHealth");
		configureContent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void configureContent() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 71, 700, 590);
		panel.setBackground(Color.decode("#E8EDF3"));
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Alimento x");
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblData.setBounds(10, 11, 92, 30);
		panel.add(lblData);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		labelData.setBounds(590, 13, 100, 30);
		panel.add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 680, 2);
		panel.add(separator);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaEditarRefeicaoPersonalizada();
				TelaEditarRefeicaoPersonalizada.main(null);
			}
		});
		buttonVoltar.setBackground(Color.decode("#2F3542"));
		buttonVoltar.setForeground(new Color(255, 255, 255));
		buttonVoltar.setBounds(948, 105, 70, 22);
		panel.add(buttonVoltar);
		
		JLabel lblAlimentoX = new JLabel("Quantidade");
		lblAlimentoX.setVerticalAlignment(SwingConstants.TOP);
		lblAlimentoX.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlimentoX.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAlimentoX.setBounds(136, 78, 97, 30);
		panel.add(lblAlimentoX);
		
		JTextField textFieldQuantidadedoAlimento = new JTextField();
		textFieldQuantidadedoAlimento.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		textFieldQuantidadedoAlimento.setBounds(136, 108, 126, 30);
		panel.add(textFieldQuantidadedoAlimento);
		textFieldQuantidadedoAlimento.setColumns(10);
		
		JLabel lblG = new JLabel("g");
		lblG.setVerticalAlignment(SwingConstants.TOP);
		lblG.setHorizontalAlignment(SwingConstants.LEFT);
		lblG.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblG.setBounds(272, 112, 24, 15);
		panel.add(lblG);
		
		JLabel lblseTiverLactose = new JLabel("*se tiver lactose, aparece aqui");
		lblseTiverLactose.setForeground(Color.RED);
		lblseTiverLactose.setVerticalAlignment(SwingConstants.TOP);
		lblseTiverLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblseTiverLactose.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblseTiverLactose.setBounds(10, 52, 248, 30);
		panel.add(lblseTiverLactose);
		
		JLabel lblCaloriasTotais = new JLabel("Calorias totais");
		lblCaloriasTotais.setVerticalAlignment(SwingConstants.TOP);
		lblCaloriasTotais.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaloriasTotais.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblCaloriasTotais.setBounds(431, 75, 126, 30);
		panel.add(lblCaloriasTotais);
		
		JLabel lblkcal = new JLabel("kcal");
		lblkcal.setVerticalAlignment(SwingConstants.TOP);
		lblkcal.setHorizontalAlignment(SwingConstants.LEFT);
		lblkcal.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblkcal.setBounds(560, 111, 54, 30);
		panel.add(lblkcal);
		
		frame.getContentPane().add(panel);
		
		txt_kcal = new JTextField();
		txt_kcal.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		txt_kcal.setText("500");
		txt_kcal.setEditable(false);
		txt_kcal.setColumns(10);
		txt_kcal.setBounds(431, 108, 126, 30);
		panel.add(txt_kcal);
		
		JButton salvar = new JButton("Salvar");
		salvar.setForeground(Color.WHITE);
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salvar.setBackground(new Color(47, 53, 66));
		salvar.setBounds(360, 190, 100, 30);
		panel.add(salvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBackground(new Color(97, 103, 116));
		btnCancelar.setBounds(221, 190, 100, 30);
		panel.add(btnCancelar);
	}
}

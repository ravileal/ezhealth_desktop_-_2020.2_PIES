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

public class PopupEditarAlimentos extends LayoutPopup {
	private JTextField txtkcal;

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
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(10, 11, 92, 30);
		panel.add(lblData);
		
		JLabel labelData = new JLabel("Quarta - 10/02");
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelData.setBounds(598, 13, 92, 30);
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
		lblAlimentoX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlimentoX.setBounds(147, 78, 86, 30);
		panel.add(lblAlimentoX);
		
		JTextField textFieldQuantidadedoAlimento = new JTextField();
		textFieldQuantidadedoAlimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldQuantidadedoAlimento.setBounds(136, 108, 126, 30);
		panel.add(textFieldQuantidadedoAlimento);
		textFieldQuantidadedoAlimento.setColumns(10);
		
		JLabel lblG = new JLabel("(g)");
		lblG.setVerticalAlignment(SwingConstants.TOP);
		lblG.setHorizontalAlignment(SwingConstants.LEFT);
		lblG.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblG.setBounds(232, 82, 24, 15);
		panel.add(lblG);
		
		JLabel lblseTiverLactose = new JLabel("*se tiver lactose, aparece aqui");
		lblseTiverLactose.setForeground(Color.RED);
		lblseTiverLactose.setVerticalAlignment(SwingConstants.TOP);
		lblseTiverLactose.setHorizontalAlignment(SwingConstants.LEFT);
		lblseTiverLactose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblseTiverLactose.setBounds(10, 52, 248, 30);
		panel.add(lblseTiverLactose);
		
		JLabel lblCaloriasTotais = new JLabel("Calorias totais");
		lblCaloriasTotais.setVerticalAlignment(SwingConstants.TOP);
		lblCaloriasTotais.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaloriasTotais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaloriasTotais.setBounds(431, 75, 126, 30);
		panel.add(lblCaloriasTotais);
		
		JLabel lblkcal = new JLabel("kcal");
		lblkcal.setVerticalAlignment(SwingConstants.TOP);
		lblkcal.setHorizontalAlignment(SwingConstants.LEFT);
		lblkcal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblkcal.setBounds(560, 111, 54, 30);
		panel.add(lblkcal);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		buttonSalvar.setBackground(Color.decode("#2F3542"));
		buttonSalvar.setForeground(new Color(255, 255, 255));
		buttonSalvar.setBounds(314, 179, 70, 22);
		panel.add(buttonSalvar);
		
		frame.getContentPane().add(panel);
		
		txtkcal = new JTextField();
		txtkcal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtkcal.setText("500");
		txtkcal.setEditable(false);
		txtkcal.setColumns(10);
		txtkcal.setBounds(431, 108, 126, 30);
		panel.add(txtkcal);
	}
}

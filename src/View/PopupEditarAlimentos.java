package View;

import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.ControllerAlimento;
import Controller.ControllerRefeicao;
import Model.Alimento;
import Model.Refeicao;
import Util.DatasFormatadas;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PopupEditarAlimentos extends LayoutPopup {
	
	private Alimento alimento;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupEditarAlimentos window = new PopupEditarAlimentos();
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
	public static void main(Alimento alimento) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PopupEditarAlimentos window = new PopupEditarAlimentos(alimento);
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
	public PopupEditarAlimentos() {
		super("Editar Alimento - EzHealth");
		configureContent();
	}
	
	private PopupEditarAlimentos(Alimento alimento) {
		super("Editar Alimento - EzHealth");
		this.alimento = alimento;
		configureContent();
	}

	/**
	 * Initialize the contents of the dialog.
	 */
	private void configureContent() {
		DatasFormatadas dataFormatada = new DatasFormatadas(new Date());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 71, 700, 590);
		panel.setBackground(Color.decode("#E8EDF3"));
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Alimento " + alimento.getNome());
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblData.setBounds(10, 11, 344, 30);
		panel.add(lblData);
		
		JLabel labelData = new JLabel( dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
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
				dialog.dispose();
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
		textFieldQuantidadedoAlimento.setColumns(10);
		textFieldQuantidadedoAlimento.setText(String.valueOf(alimento.getQuantidade()));
		panel.add(textFieldQuantidadedoAlimento);
		
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
		lblseTiverLactose.setVisible(alimento.getLactose());
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
		
		dialog.getContentPane().add(panel);
		
		JTextField txt_kcal = new JTextField();
		txt_kcal.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		txt_kcal.setText("500");
		txt_kcal.setEditable(false);
		txt_kcal.setColumns(10);
		txt_kcal.setBounds(431, 108, 126, 30);
		txt_kcal.setText(String.valueOf(alimento.getCalorias()));
		panel.add(txt_kcal);
		
		JButton salvar = new JButton("Salvar");
		salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String kcal = txt_kcal.getText();
				alimento.setCalorias(Integer.parseInt(kcal));
				String qtd = textFieldQuantidadedoAlimento.getText();
				alimento.setQuantidade(Integer.parseInt(qtd));
				JOptionPane.showMessageDialog(null, "Alimento atualizado");
				dialog.dispose();
			}
		});
		salvar.setForeground(Color.WHITE);
		salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salvar.setBackground(new Color(47, 53, 66));
		salvar.setBounds(360, 190, 100, 30);
		panel.add(salvar);
		
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
		btnCancelar.setBounds(221, 190, 100, 30);
		panel.add(btnCancelar);
	}
}

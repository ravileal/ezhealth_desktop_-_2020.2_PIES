package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.TextField;

public class teste {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste window = new teste();
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
	public teste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(0, 64, 133, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Home");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(37, 22, 63, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(37, 60, 76, 27);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Personalizadas");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_2.setBounds(37, 81, 86, 27);
		panel.add(lblNewLabel_6_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(0, 0, 979, 66);
		frame.getContentPane().add(panel_1);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(424, 142, 258, 130);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Segunda");
		lblNewLabel.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(424, 82, 49, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ter\u00E7a");
		lblNewLabel_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(483, 82, 32, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quarta");
		lblNewLabel_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(533, 82, 42, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quinta");
		lblNewLabel_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(585, 82, 42, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexta");
		lblNewLabel_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(633, 82, 32, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("S\u00E1bado");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(684, 82, 42, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Domingo");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(364, 82, 50, 22);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("13");
		lblNewLabel_2.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(543, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("14");
		lblNewLabel_2_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(595, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("15");
		lblNewLabel_2_2.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(643, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("16");
		lblNewLabel_2_3.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(694, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("12");
		lblNewLabel_2_4.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_4.setBounds(493, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("11");
		lblNewLabel_2_5.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_5.setBounds(445, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("10");
		lblNewLabel_2_6.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_2_6.setBounds(385, 103, 12, 14);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_3 = new JLabel(">");
		lblNewLabel_3.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(736, 90, 12, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("<");
		lblNewLabel_3_1.setFont(new Font("Quicksand Light", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(342, 90, 12, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Fevereiro 2021");
		lblNewLabel_4.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(139, 71, 125, 45);
		frame.getContentPane().add(lblNewLabel_4);
		
		Panel panel_3_2 = new Panel();
		panel_3_2.setBackground(new Color(176, 224, 230));
		panel_3_2.setBounds(156, 316, 258, 45);
		frame.getContentPane().add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("+");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(228, 0, 20, 45);
		panel_3_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Caf\u00E9 da Manh\u00E3");
		lblNewLabel_4_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(70, 0, 125, 45);
		panel_3_2.add(lblNewLabel_4_1_1);
		
		Panel panel_3_2_1 = new Panel();
		panel_3_2_1.setBackground(new Color(176, 224, 230));
		panel_3_2_1.setBounds(424, 316, 258, 45);
		frame.getContentPane().add(panel_3_2_1);
		panel_3_2_1.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Lanche da Manh\u00E3");
		lblNewLabel_4_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(60, 1, 138, 44);
		panel_3_2_1.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("+");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(228, 0, 20, 44);
		panel_3_2_1.add(lblNewLabel_5_1);
		
		Panel panel_3_2_2 = new Panel();
		panel_3_2_2.setBackground(new Color(176, 224, 230));
		panel_3_2_2.setBounds(694, 316, 258, 45);
		frame.getContentPane().add(panel_3_2_2);
		panel_3_2_2.setLayout(null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("+");
		lblNewLabel_5_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"asdasd");
			}
		});
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_1.setBounds(228, 0, 30, 44);
		panel_3_2_2.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Almo\u00E7o");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_1.setBounds(101, 1, 54, 44);
		panel_3_2_2.add(lblNewLabel_4_1_1_1_1);
		
		Panel panel_3_2_1_1 = new Panel();
		panel_3_2_1_1.setBackground(new Color(176, 224, 230));
		panel_3_2_1_1.setBounds(424, 374, 258, 45);
		frame.getContentPane().add(panel_3_2_1_1);
		panel_3_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("+");
		lblNewLabel_5_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_3.setBounds(228, 0, 20, 44);
		panel_3_2_1_1.add(lblNewLabel_5_1_3);
		
		JLabel lblNewLabel_4_1_1_1_3 = new JLabel("Janta");
		lblNewLabel_4_1_1_1_3.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_3.setBounds(102, 1, 43, 44);
		panel_3_2_1_1.add(lblNewLabel_4_1_1_1_3);
		
		Panel panel_3_2_2_1 = new Panel();
		panel_3_2_2_1.setBackground(new Color(176, 224, 230));
		panel_3_2_2_1.setBounds(694, 374, 258, 45);
		frame.getContentPane().add(panel_3_2_2_1);
		panel_3_2_2_1.setLayout(null);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("+");
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_2.setBounds(228, 0, 20, 44);
		panel_3_2_2_1.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Lanche da noite");
		lblNewLabel_4_1_1_1_2.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_2.setBounds(68, 0, 125, 44);
		panel_3_2_2_1.add(lblNewLabel_4_1_1_1_2);
		
		Panel panel_3_2_3 = new Panel();
		panel_3_2_3.setBackground(new Color(176, 224, 230));
		panel_3_2_3.setBounds(156, 374, 258, 45);
		frame.getContentPane().add(panel_3_2_3);
		panel_3_2_3.setLayout(null);
		
		JLabel lblNewLabel_5_1_4 = new JLabel("+");
		lblNewLabel_5_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_4.setBounds(228, 0, 20, 44);
		panel_3_2_3.add(lblNewLabel_5_1_4);
		
		JLabel lblNewLabel_4_1_1_1_4 = new JLabel("Lanche da tarde");
		lblNewLabel_4_1_1_1_4.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_4.setBounds(68, 0, 125, 44);
		panel_3_2_3.add(lblNewLabel_4_1_1_1_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_4_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(156, 277, 125, 33);
		frame.getContentPane().add(lblNewLabel_4_1);
	}
}

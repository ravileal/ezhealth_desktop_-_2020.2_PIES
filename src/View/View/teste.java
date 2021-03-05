package View;

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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

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
		frame.setBounds(100, 100, 1030, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("activeCaption"));
		panel.setBounds(0, 72, 119, 474);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Home");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 33, 63, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(10, 59, 76, 27);
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Personalizadas");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6_2.setBounds(10, 82, 86, 27);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7 = new JLabel("Menu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(10, 11, 63, 30);
		panel.add(lblNewLabel_7);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 1014, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		panel_3.setBounds(0, 0, 118, 73);
		panel_1.add(panel_3);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_2.setBounds(385, 142, 321, 130);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Calorias");
		lblNewLabel_4_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2.setBounds(131, 0, 68, 34);
		panel_2.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Consumidas");
		lblNewLabel_4_1_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1.setBounds(10, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1_1 = new JLabel("Perdidas");
		lblNewLabel_4_1_1_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_1_1.setBounds(243, 42, 88, 45);
		panel_2.add(lblNewLabel_4_1_1_2_1_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("0 kcal");
		lblNewLabel_8_2_1.setBounds(31, 87, 46, 14);
		panel_2.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("0 kcal");
		lblNewLabel_8_2_1_1.setBounds(250, 87, 46, 14);
		panel_2.add(lblNewLabel_8_2_1_1);
		
		JLabel lblNewLabel_4_1_1_2_2 = new JLabel("Consumir");
		lblNewLabel_4_1_1_2_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_2.setBounds(131, 32, 68, 45);
		panel_2.add(lblNewLabel_4_1_1_2_2);
		
		JLabel lblNewLabel_4_1_1_2_2_1 = new JLabel("0 kcal");
		lblNewLabel_4_1_1_2_2_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4_1_1_2_2_1.setBounds(141, 56, 68, 45);
		panel_2.add(lblNewLabel_4_1_1_2_2_1);
		
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
		panel_3_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2.setBounds(156, 316, 258, 66);
		frame.getContentPane().add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("+");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(216, 11, 20, 45);
		panel_3_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Caf\u00E9 da Manh\u00E3");
		lblNewLabel_4_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(70, 0, 125, 45);
		panel_3_2.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("0 kcal");
		lblNewLabel_8_2.setBounds(102, 41, 46, 14);
		panel_3_2.add(lblNewLabel_8_2);
		
		Panel panel_3_2_1 = new Panel();
		panel_3_2_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2_1.setBounds(424, 316, 258, 66);
		frame.getContentPane().add(panel_3_2_1);
		panel_3_2_1.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Lanche da Manh\u00E3");
		lblNewLabel_4_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(60, 1, 138, 44);
		panel_3_2_1.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("+");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(228, 11, 20, 44);
		panel_3_2_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_8_3 = new JLabel("0 kcal");
		lblNewLabel_8_3.setBounds(107, 41, 46, 14);
		panel_3_2_1.add(lblNewLabel_8_3);
		
		Panel panel_3_2_2 = new Panel();
		panel_3_2_2.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2_2.setBounds(694, 316, 258, 66);
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
		lblNewLabel_5_1_1.setBounds(228, 11, 30, 44);
		panel_3_2_2.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Almo\u00E7o");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_1.setBounds(101, 1, 54, 44);
		panel_3_2_2.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_8_4 = new JLabel("0 kcal");
		lblNewLabel_8_4.setBounds(111, 41, 46, 14);
		panel_3_2_2.add(lblNewLabel_8_4);
		
		Panel panel_3_2_1_1 = new Panel();
		panel_3_2_1_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2_1_1.setBounds(424, 435, 258, 66);
		frame.getContentPane().add(panel_3_2_1_1);
		panel_3_2_1_1.setLayout(null);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("+");
		lblNewLabel_5_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_3.setBounds(228, 11, 20, 44);
		panel_3_2_1_1.add(lblNewLabel_5_1_3);
		
		JLabel lblNewLabel_4_1_1_1_3 = new JLabel("Janta");
		lblNewLabel_4_1_1_1_3.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_3.setBounds(104, 0, 43, 44);
		panel_3_2_1_1.add(lblNewLabel_4_1_1_1_3);
		
		JLabel lblNewLabel_8_1 = new JLabel("0 kcal");
		lblNewLabel_8_1.setBounds(112, 41, 46, 14);
		panel_3_2_1_1.add(lblNewLabel_8_1);
		
		Panel panel_3_2_2_1 = new Panel();
		panel_3_2_2_1.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2_2_1.setBounds(694, 435, 258, 66);
		frame.getContentPane().add(panel_3_2_2_1);
		panel_3_2_2_1.setLayout(null);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("+");
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_2.setBounds(228, 11, 20, 44);
		panel_3_2_2_1.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Lanche da noite");
		lblNewLabel_4_1_1_1_2.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1_2.setBounds(68, 0, 125, 44);
		panel_3_2_2_1.add(lblNewLabel_4_1_1_1_2);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("0 kcal");
		lblNewLabel_8_1_1.setBounds(107, 41, 46, 14);
		panel_3_2_2_1.add(lblNewLabel_8_1_1);
		
		Panel panel_3_2_3 = new Panel();
		panel_3_2_3.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panel_3_2_3.setBounds(156, 435, 258, 66);
		frame.getContentPane().add(panel_3_2_3);
		panel_3_2_3.setLayout(null);
		
		JLabel lblNewLabel_5_1_4 = new JLabel("+");
		lblNewLabel_5_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5_1_4.setBounds(216, 10, 20, 44);
		panel_3_2_3.add(lblNewLabel_5_1_4);
		
		JLabel lblNewLabel_4_1_1_1_4 = new JLabel("Lanche da tarde");
		lblNewLabel_4_1_1_1_4.setBounds(65, 15, 125, 14);
		panel_3_2_3.add(lblNewLabel_4_1_1_1_4);
		lblNewLabel_4_1_1_1_4.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("0 kcal");
		lblNewLabel_8.setBounds(106, 40, 46, 14);
		panel_3_2_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_4_1 = new JLabel("Refei\u00E7\u00F5es");
		lblNewLabel_4_1.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(156, 277, 125, 33);
		frame.getContentPane().add(lblNewLabel_4_1);
	}
}

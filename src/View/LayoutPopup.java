package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Util.ViewUtils;

import javax.swing.SwingConstants;

public class LayoutPopup {
	
	protected JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LayoutPopup window = new LayoutPopup("Teste");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public LayoutPopup(String title) {
		this.frame = new JFrame();
		this.frame.setTitle(title);
		this.configureFrame();
		this.configurePanelHeader();
	}

	private void configureFrame() {
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 660);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		frame.setIconImages(icons);
		
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	private void configurePanelHeader() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#A4B0BE"));
		panel.setBounds(0, 0, frame.getWidth(), 70);
		panel.setLayout(null);
		new ViewUtils().configureTitleBarAlternative(frame, panel, "#A4B0BE", "#FFFFFF", true);
		
		
		frame.getContentPane().add(panel);
		
		String title = frame.getTitle().split("-")[0];
		JLabel lbl_title = new JLabel(title);
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 20));
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setBounds(29, 11, 161, 48);
		panel.add(lbl_title);
	}
}

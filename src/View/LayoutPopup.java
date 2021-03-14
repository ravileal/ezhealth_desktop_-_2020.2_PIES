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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Util.ViewUtils;

import javax.swing.SwingConstants;

public class LayoutPopup {
	
	protected JDialog dialog;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new LayoutPopup("Teste").dialog.setVisible(true);
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
		this.dialog = new JDialog();
		this.dialog.setModal(true);
		this.dialog.setTitle(title);
		this.configureDialog();
		this.configurePanelHeader();
	}

	private void configureDialog() {
		dialog.setResizable(false);
		dialog.setBounds(100, 100, 700, 660);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setUndecorated(true);
		dialog.getContentPane().setLayout(null);
		
		ArrayList<Image> icons = new ArrayList<Image>();
		icons.add(new ImageIcon(this.getClass().getResource("/Images/hospital.png")).getImage());
		dialog.setIconImages(icons);
		
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - dialog.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - dialog.getHeight()) / 2);
	    dialog.setLocation(x, y);
	}
	
	private void configurePanelHeader() {
		Panel panel = new Panel();
		panel.setBackground(Color.decode("#A4B0BE"));
		panel.setBounds(0, 0, dialog.getWidth(), 70);
		panel.setLayout(null);
		new ViewUtils().configureTitleBarAlternative(dialog, panel, "#A4B0BE", "#FFFFFF");
		
		
		dialog.getContentPane().add(panel);
		
		String title = dialog.getTitle().split("-")[0];
		JLabel lbl_title = new JLabel(title);
		lbl_title.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title.setFont(new Font("Quicksand Medium", Font.PLAIN, 20));
		lbl_title.setForeground(Color.WHITE);
		lbl_title.setBounds(29, 11, 161, 48);
		panel.add(lbl_title);
	}
	
}

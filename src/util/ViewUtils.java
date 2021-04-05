package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.dao.connection.Connection;

public class ViewUtils {
	
	private Window window;
	private String baseColor;
	private String baseColorText;
	private int positionXButtonMinimize;
	private int positionXButtonClose;
	
	// Essa função irá adicionar uma imagem em label e em seguida adiciona-lo ao painel 
	public void setImageInLabel(String path, JLabel jlabel, Panel panel) {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(path)); 
		Image imagem = imageIcon.getImage(); 
		imagem = imagem.getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(imagem); 
		jlabel.setIcon(imageIcon); 
		panel.add(jlabel); 
	}
	
	public void configureTitleBarAlternative(JDialog dialog, Object choicePanel, String baseColor, String baseColorText) {
		this.window = dialog;
		positionXButtonClose = 649;
		
		this.baseColor = baseColor;
		this.baseColorText = baseColorText;
		JButton close = buttonClose(false); 
	
		if(choicePanel instanceof JPanel) 
			((JPanel)choicePanel).add(close);
		else if(choicePanel instanceof Panel) 
			((Panel)choicePanel).add(close);
		
		configureTitleBarAlternative(choicePanel, baseColor, baseColorText);
	}
	
	public void configureTitleBarAlternative(JFrame frame, Object choicePanel, String baseColor, String baseColorText) {
		frame.setUndecorated(true);
		this.window = frame;
		positionXButtonMinimize = 958;
		positionXButtonClose = 1007;
		
		this.baseColor = baseColor;
		this.baseColorText = baseColorText;
		JButton close = buttonClose(true);
		JButton minimize = buttonMinimize();
		
		if(choicePanel instanceof JPanel) {
			((JPanel)choicePanel).add(minimize);
			((JPanel)choicePanel).add(close);
		} else if(choicePanel instanceof Panel) {
			((Panel)choicePanel).add(minimize);
			((Panel)choicePanel).add(close);
		}
		configureTitleBarAlternative(choicePanel, baseColor, baseColorText);
	}
	
	private void configureTitleBarAlternative(Object choicePanel, String baseColor, String baseColorText) {

		DragListener drag = new DragListener();
		window.addMouseListener(drag);
		window.addMouseMotionListener(drag);
	}
	
	private JButton buttonMinimize() {
		JButton btnNewButton_minimize = new JButton("_");
		btnNewButton_minimize.setBounds(positionXButtonMinimize, 0, 51, 23);
		btnNewButton_minimize.setFont(new Font("Quicksand", Font.PLAIN, 14));
		btnNewButton_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((Frame)window).setState(Frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c = btnNewButton_minimize.getBackground();
				btnNewButton_minimize.setBackground(new Color( c.getRed()/255, c.getGreen()/255, c.getBlue()/255, 0.5f));
				btnNewButton_minimize.setForeground(Color.decode("#FFFFFF"));
				btnNewButton_minimize.setText("_");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_minimize.setBackground(Color.decode(baseColor));
				btnNewButton_minimize.setForeground(Color.decode(baseColorText));
			}
		});
		btnNewButton_minimize.setMargin(new Insets(-12, 0, 0, 0));
		btnNewButton_minimize.setBorderPainted(false);
		btnNewButton_minimize.setFocusPainted(false);
		btnNewButton_minimize.setForeground(Color.decode(baseColorText));
		btnNewButton_minimize.setBackground(Color.decode(baseColor));
		
		return btnNewButton_minimize;
	}
	
	private JButton buttonClose(boolean close) {
		JButton btnNewButton_close = new JButton("X");
		btnNewButton_close.setBounds(positionXButtonClose, 0, 51, 23);
		btnNewButton_close.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(close) {
					System.exit(0);
					Connection.getInstance();
				}
				else
					window.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_close.setBackground(Color.decode("#E81123"));
				btnNewButton_close.setForeground(Color.decode("#FFFFFF"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_close.setBackground(Color.decode(baseColor));
				btnNewButton_close.setForeground(Color.decode(baseColorText));
			}
		});
		btnNewButton_close.setBorderPainted(false);
		btnNewButton_close.setFocusPainted(false);
		btnNewButton_close.setBackground(Color.decode(baseColor));
		btnNewButton_close.setForeground(Color.decode(baseColorText));
		
		return btnNewButton_close;
	}
	
}

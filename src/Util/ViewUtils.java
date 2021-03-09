package Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewUtils {
	
	public void setImageInLabel(String path, JLabel jlabel, Panel panel) {		
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(path)); 
		Image imagem = imageIcon.getImage(); 
		imagem = imagem.getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(imagem); 
		jlabel.setIcon(imageIcon); 
		panel.add(jlabel); 
	}
	
	public void configureTitleBarAlternative(JFrame frame, Object choicePanel, String baseColor, String baseColorText) {
		
		frame.setUndecorated(true);
		
		DragListener drag = new DragListener();
		frame.addMouseListener(drag);
		frame.addMouseMotionListener(drag);
				
		JButton btnNewButton_close = new JButton("X");
		btnNewButton_close.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		btnNewButton_close.setBounds(1007, 0, 51, 23);
		btnNewButton_close.setBackground(Color.decode(baseColor));
		btnNewButton_close.setForeground(Color.decode(baseColorText));
		
		
		
		JButton btnNewButton_minimize = new JButton("_");
		btnNewButton_minimize.setFont(new Font("Quicksand", Font.PLAIN, 14));
		btnNewButton_minimize.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
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
		btnNewButton_minimize.setBounds(958, 0, 51, 23);
		btnNewButton_minimize.setForeground(Color.decode(baseColorText));
		btnNewButton_minimize.setBackground(Color.decode(baseColor));
		
		if(choicePanel instanceof JPanel) {
			((JPanel)choicePanel).add(btnNewButton_minimize);
			((JPanel)choicePanel).add(btnNewButton_close);
		} else if(choicePanel instanceof Panel) {
			((Panel)choicePanel).add(btnNewButton_minimize);
			((Panel)choicePanel).add(btnNewButton_close);
		}
	}
}

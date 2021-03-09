package Util;

import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewUtils {
	public void setImageInLabel(String path, JLabel jlabel, Panel panel) {		
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(path)); 
		Image imagem = imageIcon.getImage(); 
		imagem = imagem.getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_DEFAULT);
		imageIcon = new ImageIcon(imagem); 
		jlabel.setIcon(imageIcon); 
		panel.add(jlabel); 
	}
}

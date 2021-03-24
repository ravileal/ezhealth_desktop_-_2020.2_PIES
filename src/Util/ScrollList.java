package Util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Model;

public class ScrollList<Object extends Model> extends JScrollPane {
	
	public interface MouseAdapterExcluir{
		void MouseAdapter(String nome);
	}
	public interface MouseAdapterAdicionar{
		void MouseAdapter(String nome);
	}
	
	private MouseAdapter adapterEditar;
	private MouseAdapterExcluir adapterExcluir;
	private MouseAdapterAdicionar adapterAdicionar;
	
	public MouseAdapter getAdapterEditar() {
		return adapterEditar;
	}

	public void setAdapterEditar(MouseAdapter adapterEditar) {
		this.adapterEditar = adapterEditar;
	}

	public MouseAdapterExcluir getAdapterExcluir() {
		return adapterExcluir;
	}

	public void setAdapterExcluir(MouseAdapterExcluir adapterExcluir) {
		this.adapterExcluir = adapterExcluir;
	}

	public MouseAdapterAdicionar getAdapterAdicionar() {
		return adapterAdicionar;
	}

	public void setAdapterAdicionar(MouseAdapterAdicionar adapterAdicionar) {
		this.adapterAdicionar = adapterAdicionar;
	}

	public void configureList(JPanel panel, List<Object> list) {
	
		JPanel panel_refeicoes = new JPanel();
		panel_refeicoes.setLayout(new BoxLayout(panel_refeicoes, BoxLayout.Y_AXIS));
		panel_refeicoes.setBackground(Color.decode("#DFE4EA"));
		setViewportView(panel_refeicoes);
		
		JPanel panel_item = null;
		
		for (Object obj : list) {
			panel_item = new JPanel();
			panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
			panel_item.setMaximumSize(new Dimension(getWidth(), 10));
			panel_item.setBackground(Color.decode("#DFE4EA"));
			panel_refeicoes.add(panel_item);
			
			panel_refeicoes.add(configureItemList(obj.getNome(), panel));
			
			panel_item = new JPanel();
			panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
			panel_item.setMaximumSize(new Dimension(getWidth(), 10));
			panel_item.setBackground(Color.decode("#DFE4EA"));
			panel_refeicoes.add(panel_item);
			
			panel_item = new JPanel();
			panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
			panel_item.setMaximumSize(new Dimension(getWidth(), 1));
			panel_item.setBackground(Color.decode("#A4B0BE"));
			panel_refeicoes.add(panel_item);
		}
	}
	
	public Panel configureItemList(String nome, JPanel panel) {
		Panel panel_item = new Panel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.setPreferredSize(new Dimension(0, 50));
		panel_item.setBackground(Color.decode("#DFE4EA"));
		
	
		// configurações da label
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(new JLabel(nome));
		panel_item.add(Box.createVerticalStrut(10)); 
		
		// configurações dos botões
		if(adapterEditar != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/edit.png", botaoEditar(nome), panel_item);
		} 
		if(adapterExcluir != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/remove.png", botaoExcluir(nome), panel_item);
		}
		if(adapterAdicionar != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/add.png", botaoAdicionar(nome), panel_item);
		}
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		return panel_item;
	}
	
	private JLabel botaoEditar(String nome) {
		JLabel botaoEditar = new JLabel();
		botaoEditar.setSize(20, 20);
		botaoEditar.addMouseListener(adapterEditar);
		return botaoEditar;
	}

	private JLabel botaoExcluir(String nome) {
		JLabel botaoExcluir = new JLabel();
		botaoExcluir.setSize(20, 20);
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adapterExcluir.MouseAdapter(nome);
			}
		});
		return botaoExcluir;
	}
	
	private JLabel botaoAdicionar(String nome) {
		JLabel botaoExcluir = new JLabel();
		botaoExcluir.setSize(20, 20);
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adapterAdicionar.MouseAdapter(nome);
			}
		});
		return botaoExcluir;
	}
}

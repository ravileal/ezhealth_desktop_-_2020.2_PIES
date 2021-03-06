package util;

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

import model.Model;

public class ScrollList<T extends Model> extends JScrollPane {
	public ScrollList() {
	}
	
	public interface MouseAdapterNome{
		void mouseAdapter(Model obj);
	}
	
	private MouseAdapterNome adapterEditar;
	private MouseAdapterNome adapterExcluir;
	private MouseAdapterNome adapterAdicionar;
	
	public MouseAdapterNome getAdapterEditar() {
		return adapterEditar;
	}

	public void setAdapterEditar(MouseAdapterNome adapterEditar) {
		this.adapterEditar = adapterEditar;
	}

	public MouseAdapterNome getAdapterExcluir() {
		return adapterExcluir;
	}

	public void setAdapterExcluir(MouseAdapterNome adapterExcluir) {
		this.adapterExcluir = adapterExcluir;
	}

	public MouseAdapterNome getAdapterAdicionar() {
		return adapterAdicionar;
	}

	public void setAdapterAdicionar(MouseAdapterNome adapterAdicionar) {
		this.adapterAdicionar = adapterAdicionar;
	}

	public void configureList(JPanel panel, List<T> list) {
	
		JPanel panel_refeicoes = new JPanel();
		panel_refeicoes.setLayout(new BoxLayout(panel_refeicoes, BoxLayout.Y_AXIS));
		panel_refeicoes.setBackground(Color.decode("#DFE4EA"));
		setViewportView(panel_refeicoes);
		
		JPanel panel_item = null;
		
		for (T obj : list) {
			panel_item = new JPanel();
			panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
			panel_item.setMaximumSize(new Dimension(getWidth(), 10));
			panel_item.setBackground(Color.decode("#DFE4EA"));
			panel_refeicoes.add(panel_item);
			
			panel_refeicoes.add(configureItemList(obj, panel));
			
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
	
	public Panel configureItemList(T obj, JPanel panel) {
		Panel panel_item = new Panel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.setPreferredSize(new Dimension(0, 50));
		panel_item.setBackground(Color.decode("#DFE4EA"));
		
	
		// configurações da label
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(new JLabel(obj.getNome()));
		panel_item.add(Box.createVerticalStrut(10)); 
		
		// configurações dos botões
		if(adapterEditar != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/edit.png", botaoEditar(obj), panel_item);
		} 
		if(adapterExcluir != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/remove.png", botaoExcluir(obj), panel_item);
		}
		if(adapterAdicionar != null) {
			panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
			new ViewUtils().setImageInLabel("/Images/add.png", botaoAdicionar(obj), panel_item);
		}
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		return panel_item;
	}
	
	private JLabel botaoEditar(T obj) {
		JLabel botaoEditar = new JLabel();
		botaoEditar.setSize(20, 20);
		botaoEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adapterEditar.mouseAdapter(obj);
				super.mouseClicked(e);
			}
		});
		return botaoEditar;
	}

	private JLabel botaoExcluir(T obj) {
		JLabel botaoExcluir = new JLabel();
		botaoExcluir.setSize(20, 20);
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adapterExcluir.mouseAdapter(obj);
			}
		});
		return botaoExcluir;
	}
	
	private JLabel botaoAdicionar(T obj) {
		JLabel botaoExcluir = new JLabel();
		botaoExcluir.setSize(20, 20);
		botaoExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adapterAdicionar.mouseAdapter(obj);
			}
		});
		return botaoExcluir;
	}
}

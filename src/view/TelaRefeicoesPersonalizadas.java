package view;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.ControllerUsuario;
import model.Alimento;
import model.Model;
import model.Refeicao;
import model.Usuario;
import util.DatasFormatadas;
import util.ScrollList;
import util.ViewUtils;
import util.ScrollList.MouseAdapterNome;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;

import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JPanel;

public class TelaRefeicoesPersonalizadas extends LayoutMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaRefeicoesPersonalizadas window = new TelaRefeicoesPersonalizadas();
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
	public TelaRefeicoesPersonalizadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Refeições personalizadass - EzHealth");
		configureContent();
	}
	private void configureContent() {
		DatasFormatadas dataFormatada = new DatasFormatadas(new Date());
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
	
		JLabel labeRefeicao = new JLabel("Refei\u00E7\u00F5es Personalizadas");
		labeRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labeRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labeRefeicao.setFont(new Font("Quicksand", Font.PLAIN, 16));
		labeRefeicao.setBounds(28, 11, 232, 30);
		panel.add(labeRefeicao);
		
		JLabel labelData = new JLabel(dataFormatada.getDiaSemana() + " - " + dataFormatada.getDiaMes());
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		labelData.setBounds(28, 32, 107, 30);
		panel.add(labelData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 872, 2);
		panel.add(separator);
		
		JLabel labelCriarRefeicao = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		labelCriarRefeicao.setVerticalAlignment(SwingConstants.TOP);
		labelCriarRefeicao.setHorizontalAlignment(SwingConstants.LEFT);
		labelCriarRefeicao.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		labelCriarRefeicao.setBounds(87, 437, 274, 30);
		panel.add(labelCriarRefeicao);
		labelCriarRefeicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				TelaCriarRefeicoesPersonalizadas.main(null);
			}
		});
		
		JLabel lblBuscarAlimentos_2 = new JLabel("+");
		lblBuscarAlimentos_2.setVerticalAlignment(SwingConstants.TOP);
		lblBuscarAlimentos_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscarAlimentos_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBuscarAlimentos_2.setBounds(56, 433, 21, 30);
		panel.add(lblBuscarAlimentos_2);
		
		configureListRefeicoes(panel);
		frame.getContentPane().add(panel);
	}
	
	private void configureListRefeicoes(JPanel panel){
		MouseAdapterNome btnEditar = (Model obj) -> {
			frame.dispose();
			TelaEditarRefeicaoPersonalizada.main((Refeicao) obj);
		};
		
		MouseAdapterNome btnExcluir = (Model obj) -> {
			try {
				Usuario usuario = ControllerUsuario.getUsuarioLogado();
				
				Refeicao ref = (Refeicao) obj;
				usuario.decCaloriasConsumidas(ref.getCalorias());
				usuario.getListRefeicao().remove(ref);
				
				ControllerUsuario.setUsuarioLogado(usuario);
				ControllerUsuario.editar();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, refeição não encontrada");
				e.printStackTrace();
			} catch (DadosVaziosException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, algum dados está em branco");
				e.printStackTrace();
			} catch (OperacaoNaoConcluidaRepositorioExeception e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, erro ao salvar no banco");
				e.printStackTrace();
			} catch (SenhaInvalidaException e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar remover, usuario com senha inválida");
				e.printStackTrace();
			} 
			
			for (Component compo : panel.getComponents()) 
				if(compo instanceof JScrollPane)
					panel.remove(compo);
			
			configureListRefeicoes(panel);
			
			frame.revalidate();
			frame.repaint();
		};
		
		
		ScrollList<Refeicao> list_2 = new ScrollList<Refeicao>();
		list_2.setAdapterEditar(btnEditar);
		list_2.setAdapterExcluir(btnExcluir);
		list_2.getVerticalScrollBar().setUnitIncrement(4);
		list_2.setBorder(BorderFactory.createEmptyBorder());
		list_2.setBounds(28, 92, 820, 337);
		list_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list_2.configureList(panel,  ControllerUsuario.getUsuarioLogado().getListRefeicao() );
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Nenhum refeição personalizada cadastrada");
			e1.printStackTrace();
		}
		panel.add(list_2);
	}
	
}

package view;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;

import javax.swing.SwingConstants;

import controller.ControllerAlimento;
import controller.ControllerRefeicao;
import controller.ControllerRefeicaoAlimentoUsuario;
import controller.ControllerUsuario;
import model.Alimento;
import model.AlimentoModel;
import model.Refeicao;
import model.to.ToRefeicao;
import util.DatasFormatadas;
import util.ScrollList;
import util.ScrollList.MouseAdapterNome;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

import javax.swing.BorderFactory;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.FocusManager;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaAlimentos extends LayoutMain {
	
	private ToRefeicao refeicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaAlimentos window = new TelaAlimentos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String nome) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaAlimentos window = new TelaAlimentos(nome);
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
	public TelaAlimentos() {
		initialize();
	}

	private TelaAlimentos(String nome) {
		try {
			refeicao = new ControllerRefeicao().buscar(nome).toToRefeicao();
			refeicao.setListAlimento(new ControllerRefeicaoAlimentoUsuario().buscarTodosAlimentosPorIdRefeicao(refeicao.getId()));  
//			new ControllerRefeicao(true)
//			.buscar(nome)
//			.forEach((ref) -> {
//				if(ref.getData().equals(new Date()))
//					refeicao = ref;
//			});
		} catch (NullPointerException e) {
			refeicao = new ToRefeicao();
			refeicao.setNome(nome);
			refeicao.setData(
					new DatasFormatadas(new Date()).getDiaMesNumber() + "/" +
					new DatasFormatadas(new Date()).getMesNumber() + "/" +
					new DatasFormatadas(new Date()).getAno());
			refeicao.setListAlimento(new ArrayList<Alimento>());
			try {
				refeicao.setId(new ControllerRefeicao().adicionar(refeicao));
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(null, "Refeição nula");
				e1.printStackTrace();
			} catch (DadosVaziosException e1) {
				JOptionPane.showMessageDialog(null, "Refeição com nome inválido");
				e1.printStackTrace();
			} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
				JOptionPane.showMessageDialog(null, "Não foi possivel salvar refeição");
				e1.printStackTrace();
			}
		} catch (DadosVaziosException e) {
			JOptionPane.showMessageDialog(null, "Refeição com nome inválido");
		}
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Tela Alimentos - EzHealth");
		configureContent();
	}
		
	private void configureContent() {
		
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel lblMinhaRefeio = new JLabel(refeicao.getNome());
		lblMinhaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblMinhaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblMinhaRefeio.setFont(new Font("Quicksand", Font.PLAIN, 16));
		lblMinhaRefeio.setBounds(20, 11, 341, 30);
		panel.add(lblMinhaRefeio);

		JLabel labelData = new JLabel( refeicao.getData() );
		labelData.setVerticalAlignment(SwingConstants.TOP);
		labelData.setHorizontalAlignment(SwingConstants.LEFT);
		labelData.setFont(new Font("Quicksand Light", Font.PLAIN, 13));
		labelData.setBounds(21, 32, 253, 30);
		panel.add(labelData);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 902, 10);
		panel.add(separator);


		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(535, 73, 412, 30);
		panel.add(lblAdicionarAlimentosNa);

		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHome.main(null);
				frame.dispose();
			}
		});
		buttonVoltar.setBackground(Color.decode("#2F3542"));
		buttonVoltar.setForeground(new Color(255, 255, 255));
		buttonVoltar.setBounds(829, 19, 70, 22);
		buttonVoltar.setBorder(BorderFactory.createEmptyBorder());
		panel.add(buttonVoltar);

		JTextField txtPesquisarAlimentos = new JTextField() {
			@Override
			protected void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				if(!(getText().isEmpty() && 
				   !(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)))
					return;
					
				Graphics2D graphics2D = (Graphics2D)graphics.create();
				graphics2D.setFont(getFont().deriveFont(Font.LAYOUT_LEFT_TO_RIGHT));
		        graphics2D.setColor(Color.GRAY);
		        graphics2D.drawString("Digite o nome do alimento", 5, 20);
		        graphics2D.dispose();
			}
		};
		txtPesquisarAlimentos.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				frame.revalidate();
				frame.repaint();
			}
		});    
        txtPesquisarAlimentos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtPesquisarAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 14));
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setForeground(Color.black);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(535, 96, 335, 30);
		panel.add(txtPesquisarAlimentos);

		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Quicksand Light", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(20, 73, 141, 30);
		panel.add(lblListaDeAlimentos);
		
		configureListAlimentos(panel);
		configureListAlimentosRefeicao(panel);
	}

	private void configureListAlimentos(JPanel panel){
		ScrollList<Alimento> list = new ScrollList<Alimento>();
		list.getVerticalScrollBar().setUnitIncrement(4);
		list.setBorder(BorderFactory.createEmptyBorder());
		list.setBounds(534, 168, 336, 307);
		list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		try {
			final List<AlimentoModel> listAlimento = new ControllerAlimento().buscarTodosModel();
			
			MouseAdapterNome btnAdicionar = new MouseAdapterNome() {
				@Override
				public void mouseAdapter(String nome) {
					try {						
						for(AlimentoModel alimento: listAlimento)
							if(alimento.getNome().equals(nome)) {
								try {
									String idAlimento = new ControllerAlimento().adicionar(alimento.toAlimento());
									Alimento ali = new ControllerAlimento().buscar(idAlimento);
									new ControllerRefeicaoAlimentoUsuario().adicionar(ali, refeicao.toRefeicao());
									
									refeicao.addAlimento(ali);
									refeicao.setData(
											new DatasFormatadas(new Date()).getDiaMesNumber() + "/" +
											new DatasFormatadas(new Date()).getMesNumber() + "/" +
											new DatasFormatadas(new Date()).getAno());
									
								} catch (DadosVaziosException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (OperacaoNaoConcluidaRepositorioExeception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						
						for (Component compo : panel.getComponents()) 
							if(compo instanceof JScrollPane)
								panel.remove(compo);
							
						configureListAlimentos(panel);
						configureListAlimentosRefeicao(panel); 
						
						frame.revalidate();
						frame.repaint();
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Alimento não encontrado");
						e.printStackTrace();
					} 
				}
			};
		
			list.setAdapterAdicionar(btnAdicionar);
			list.configureList(panel, listAlimento);
		
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Alimento não encontrado");
			e1.printStackTrace();
		} catch (DadosVaziosException e1) {
			JOptionPane.showMessageDialog(null, "Alimento com nome inválido");
			e1.printStackTrace();
		} finally {
			panel.add(list);			
		}
		
	}
	
	
	private void configureListAlimentosRefeicao(JPanel panel){
		MouseAdapterNome btnEditar = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				for(Alimento obj: refeicao.getListAlimento())
					if(obj.getNome().equals(nome)) {
						PopupEditarAlimentos.main(obj);
						break;
					}
			}
		};
		
		MouseAdapterNome btnExcluir = new MouseAdapterNome() {
			@Override
			public void mouseAdapter(String nome) {
				for(Alimento obj: refeicao.getListAlimento())
					if(obj.getNome().equals(nome)) {
						new ControllerUsuario().removerCaloriasConsumidas(obj.getCalorias());
						refeicao.delAlimento(obj);
						break;
					}
				
				atualizarRefeicao();
				for (Component compo : panel.getComponents()) 
					if(compo instanceof JScrollPane)
						panel.remove(compo);
				
				configureListAlimentos(panel);
				configureListAlimentosRefeicao(panel);
				
				frame.revalidate();
				frame.repaint();
			}
		};
		
		
		ScrollList<Alimento> list_2 = new ScrollList<Alimento>();
		list_2.setAdapterEditar(btnEditar);
		list_2.setAdapterExcluir(btnExcluir);
		list_2.getVerticalScrollBar().setUnitIncrement(4);
		list_2.setBorder(BorderFactory.createEmptyBorder());
		list_2.setBounds(20, 100, 466, 375);
		list_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		try {
			list_2.configureList(panel, refeicao.getListAlimento());
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, "Alimento não encontrado");
			e1.printStackTrace();
		} 
		panel.add(list_2);
	}
	
	
	private void atualizarRefeicao() {
		try {
			new ControllerRefeicao().editar(refeicao);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Refeição nula");
			e.printStackTrace();
		} catch (DadosVaziosException e) {
			JOptionPane.showMessageDialog(null, "Refeição com nome inválido");
			e.printStackTrace();
		} catch (OperacaoNaoConcluidaRepositorioExeception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível atualizar refeição");
			e.printStackTrace();
		}
	}
	

	
}

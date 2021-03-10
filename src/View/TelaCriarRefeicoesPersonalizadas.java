package View;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Controller.ControllerAlimento;
import Util.ViewUtils;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarRefeicoesPersonalizadas extends LayoutMain {

	private JScrollPane scrollPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaCriarRefeicoesPersonalizadas window = new TelaCriarRefeicoesPersonalizadas();
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
	public TelaCriarRefeicoesPersonalizadas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Criar Refeição Personalizada - EzHealth");		
		configureContent();
	}

	private void configureContent() {
		JPanel panel = new JPanel();
		panel.setBounds(136, 106, 922, 497);
		panel.setBackground(Color.decode("#DFE4EA"));
		panel.setLayout(null);
		
		JLabel lblCriarNovaRefeio = new JLabel("Criar nova Refei\u00E7\u00E3o Personalizada");
		lblCriarNovaRefeio.setVerticalAlignment(SwingConstants.TOP);
		lblCriarNovaRefeio.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriarNovaRefeio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCriarNovaRefeio.setBounds(36, 13, 253, 30);
		panel.add(lblCriarNovaRefeio);
		
		Button buttonVoltar = new Button("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVoltar.setBackground(SystemColor.menu);
		buttonVoltar.setBounds(793, 21, 70, 22);
		panel.add(buttonVoltar);
		buttonVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TelaRefeicoesPersonalizadas();
				TelaRefeicoesPersonalizadas.main(null);
			}
		});
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 872, 2);
		panel.add(separator);
		
		JLabel lblAdicionarAlimentosNa = new JLabel("Adicionar Alimentos na Refei\u00E7\u00E3o Personalizada");
		lblAdicionarAlimentosNa.setVerticalAlignment(SwingConstants.TOP);
		lblAdicionarAlimentosNa.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarAlimentosNa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdicionarAlimentosNa.setBounds(528, 101, 354, 30);
		panel.add(lblAdicionarAlimentosNa);
		
		JTextField txtPesquisarAlimentos = new JTextField();
		txtPesquisarAlimentos.setToolTipText("Pesquisar");
		txtPesquisarAlimentos.setText("Pesquisar Alimentos");
		txtPesquisarAlimentos.setForeground(SystemColor.scrollbar);
		txtPesquisarAlimentos.setColumns(10);
		txtPesquisarAlimentos.setBounds(528, 143, 335, 35);
		panel.add(txtPesquisarAlimentos);
	
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setBackground(SystemColor.menu);
		buttonSalvar.setBounds(36, 448, 70, 22);
		panel.add(buttonSalvar);
		
		JLabel lblListaDeAlimentos = new JLabel("Lista de Alimentos");
		lblListaDeAlimentos.setVerticalAlignment(SwingConstants.TOP);
		lblListaDeAlimentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeAlimentos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeAlimentos.setBounds(36, 101, 141, 30);
		panel.add(lblListaDeAlimentos);
		
		
		JTextField txtEditarNomeRefeio = new JTextField();
		txtEditarNomeRefeio.setToolTipText("Pesquisar");
		txtEditarNomeRefeio.setText("Editar nome refei\u00E7\u00E3o");
		txtEditarNomeRefeio.setForeground(SystemColor.scrollbar);
		txtEditarNomeRefeio.setColumns(10);
		txtEditarNomeRefeio.setBounds(36, 35, 241, 22);
		panel.add(txtEditarNomeRefeio);
		
		criarPainelRefeicoes();
		
		frame.getContentPane().add(panel);
	}
	
	public void criarPainelRefeicoes() {		
		if(scrollPane != null)
			frame.getContentPane().remove(scrollPane);

		JPanel panel_refeicoes = new JPanel();
		panel_refeicoes.setLayout(new BoxLayout(panel_refeicoes, BoxLayout.Y_AXIS));
		
//		for (Alimento a : new ControllerAlimento().buscar("")) {
		panel_refeicoes.add(Box.createRigidArea(new Dimension(0, 10)));
		JPanel panel_item = new JPanel();
		panel_item.setLayout(new BoxLayout(panel_item, BoxLayout.X_AXIS));
		panel_item.add(new JLabel("Laranja"));
		panel_item.add(botaoEditar("Laranja"));
		panel_item.add(Box.createRigidArea(new Dimension(10, 0)));
		panel_item.add(botaoExcluir("Laranja"));
		panel_refeicoes.add(panel_item);
//        }
		
		scrollPane = new JScrollPane(panel_refeicoes);
		scrollPane.setBounds(162, 247, 467, 260);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame.getContentPane().add(scrollPane);
		frame.revalidate();
	}
	
	public JButton botaoEditar(String nome) {
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					PopupEditarAlimentos.main(null);
				}
			}
		);
		return botaoEditar;
	}
	
	public JButton botaoExcluir(String nome) {
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						new ControllerAlimento().remover(nome);
					} catch (DadosVaziosException e1) {
						JOptionPane.showMessageDialog(null, "Algum campo está vazio");
						e1.printStackTrace();
					} catch (OperacaoNaoConcluidaRepositorioExeception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao excluir refeição");
						e1.printStackTrace();
					}
					criarPainelRefeicoes();
				}
			}
		);
		return botaoExcluir;
	}
}

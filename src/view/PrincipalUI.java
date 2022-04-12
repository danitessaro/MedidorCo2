package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalUI() {
		setTitle("Sistema para cálcular emissão de CO2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 470);
		
		JMenuBar jbPrincipal = new JMenuBar();
		setJMenuBar(jbPrincipal);
		
		JMenu jmCadastros = new JMenu("Cadastros");
		jbPrincipal.add(jmCadastros);
		
		JMenuItem jmiColaboradores = new JMenuItem("Colaboradores");
		jmiColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroColaboradorUI cadColaborador = new CadastroColaboradorUI();
				cadColaborador.setVisible(true);
				contentPane.add(cadColaborador, 0);
			}
		});
		jmCadastros.add(jmiColaboradores);
		
		JMenuItem jmiVeiculos = new JMenuItem("Veículos");
		jmiVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculoUI cadVeiculo = new CadastroVeiculoUI();
				cadVeiculo.setVisible(true);
				contentPane.add(cadVeiculo, 0);
			}
		});
		jmCadastros.add(jmiVeiculos);
		
		JMenu jmConsultas = new JMenu("Consultas");
		jbPrincipal.add(jmConsultas);
		
		JMenuItem jmiConsultaColaborador = new JMenuItem("Colaboradores");
		jmiConsultaColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ConsultaColaboradoresUI consultaColabUI = new ConsultaColaboradoresUI();
					consultaColabUI.setVisible(true);
					contentPane.add(consultaColabUI, 0);
			}
		});
		jmConsultas.add(jmiConsultaColaborador);
		
		JMenuItem jmiConsultaVeiculo = new JMenuItem("Veículo");
		jmiConsultaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVeiculoUI consultaVeicUI = new ConsultaVeiculoUI();
				consultaVeicUI.setVisible(true);
				contentPane.add(consultaVeicUI, 0);
			}
		});
		jmConsultas.add(jmiConsultaVeiculo);
		
		JMenu jmChamados = new JMenu("Chamados");
		jbPrincipal.add(jmChamados);
		
		JMenuItem jmiRegistrarChamado = new JMenuItem("Registrar Chamado");
		jmChamados.add(jmiRegistrarChamado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 612, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 423, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}

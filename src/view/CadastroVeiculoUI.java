package view;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.VeiculoController;
import models.Veiculo;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroVeiculoUI extends JInternalFrame {
	private JTextField txtPlaca;
	private JTextField txtAutonomia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculoUI frame = new CadastroVeiculoUI();
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
	public CadastroVeiculoUI() {
		setClosable(true);
		setTitle("Cadastro de Veiculos");
		setBounds(100, 100, 408, 225);
		
		JPanel jpCadastroVeiculo = new JPanel();
		jpCadastroVeiculo.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JButton jbCancelar = new JButton("Cancelar");
		
		JButton jbSalvar = new JButton("Salvar");
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Veiculo veiculo = new Veiculo();
					veiculo.setPlaca(txtPlaca.getText());
					veiculo.setAutonomiaLitro(Double.parseDouble(txtAutonomia.getText()));
					
					new VeiculoController().salvar(veiculo);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar veículo");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroVeiculo, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(jbSalvar)
					.addGap(18)
					.addComponent(jbCancelar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadastroVeiculo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbCancelar)
						.addComponent(jbSalvar))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel jlPlaca = new JLabel("Placa:");
		
		JLabel jlAutonomia = new JLabel("Autonomia por litro: ");
		
		txtPlaca = new JTextField();
		txtPlaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtPlaca.setColumns(10);
		
		txtAutonomia = new JTextField();
		txtAutonomia.setColumns(10);
		GroupLayout gl_jpCadastroVeiculo = new GroupLayout(jpCadastroVeiculo);
		gl_jpCadastroVeiculo.setHorizontalGroup(
			gl_jpCadastroVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroVeiculo.createSequentialGroup()
					.addGroup(gl_jpCadastroVeiculo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadastroVeiculo.createSequentialGroup()
							.addComponent(jlPlaca)
							.addGap(1)
							.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpCadastroVeiculo.createSequentialGroup()
							.addComponent(jlAutonomia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(290, Short.MAX_VALUE))
		);
		gl_jpCadastroVeiculo.setVerticalGroup(
			gl_jpCadastroVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadastroVeiculo.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_jpCadastroVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadastroVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlAutonomia)
						.addComponent(txtAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(213, Short.MAX_VALUE))
		);
		jpCadastroVeiculo.setLayout(gl_jpCadastroVeiculo);
		getContentPane().setLayout(groupLayout);

	}

}

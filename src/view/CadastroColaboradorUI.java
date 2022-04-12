package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;

import controller.ColaboradorController;
import models.Colaborador;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroColaboradorUI extends JInternalFrame {
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaboradorUI frame = new CadastroColaboradorUI();
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
	public CadastroColaboradorUI() {
		setClosable(true);
		setTitle("Cadastro de Colaboradores");
		setBounds(100, 100, 564, 251);
		
		JPanel jpColaborador = new JPanel();
		jpColaborador.setBorder(new TitledBorder(null, "Colaborador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton jbCancelar = new JButton("Cancelar");
		
		JButton jbSalvar = new JButton("Salvar");
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Colaborador colaborador = new Colaborador();
					colaborador.setCpf(txtCpf.getText());
					colaborador.setNome(txtNome.getText());
					colaborador.setEndereco(txtEndereco.getText());
				
				new ColaboradorController().salvar(colaborador);
				JOptionPane.showMessageDialog(null, "Colaborador salvo com sucesso");
				dispose();
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar colaborador");
			}
				
		}
	});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(jpColaborador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(jbSalvar)
							.addGap(18)
							.addComponent(jbCancelar)
							.addGap(24))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addComponent(jpColaborador, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jbCancelar)
						.addComponent(jbSalvar))
					.addGap(170))
		);
		
		JLabel lbCpf = new JLabel("CPF:");
		
		JLabel jlNome = new JLabel("Nome:");
		
		JLabel jlEndereco = new JLabel("Endereço:");
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		GroupLayout gl_jpColaborador = new GroupLayout(jpColaborador);
		gl_jpColaborador.setHorizontalGroup(
			gl_jpColaborador.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpColaborador.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpColaborador.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpColaborador.createSequentialGroup()
							.addComponent(lbCpf)
							.addGap(2)
							.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpColaborador.createSequentialGroup()
							.addComponent(jlEndereco)
							.addGap(3)
							.addComponent(txtEndereco))
						.addGroup(gl_jpColaborador.createSequentialGroup()
							.addComponent(jlNome)
							.addGap(1)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpColaborador.setVerticalGroup(
			gl_jpColaborador.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpColaborador.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_jpColaborador.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_jpColaborador.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpColaborador.createSequentialGroup()
							.addGap(14)
							.addComponent(jlNome))
						.addGroup(gl_jpColaborador.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jpColaborador.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlEndereco)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		jpColaborador.setLayout(gl_jpColaborador);
		getContentPane().setLayout(groupLayout);

	}
}

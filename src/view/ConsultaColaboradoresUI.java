package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ColaboradorController;
import view.tables.ColaboradorTableModel;

import javax.swing.JScrollPane;

public class ConsultaColaboradoresUI extends JInternalFrame {
	private JTable jtColaboradores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaColaboradoresUI frame = new ConsultaColaboradoresUI();
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
	public ConsultaColaboradoresUI() {
		setClosable(true);
		setTitle("Consulta de Colaboradores");
		setBounds(100, 100, 748, 202);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnExcluir = new JButton("Excluir");
		
		JButton btnEditar = new JButton("Editar");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar)
					.addGap(25))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		
		jtColaboradores = new JTable();
		jtColaboradores.setModel(new ColaboradorTableModel(new ColaboradorController().listar()));
		scrollPane.setViewportView(jtColaboradores);
		getContentPane().setLayout(groupLayout);

	}
}

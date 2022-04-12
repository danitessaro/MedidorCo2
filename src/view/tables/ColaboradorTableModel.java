package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import models.*;

public class ColaboradorTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COL_CPF = 0;
	private static final int COL_NOME = 1;
	private static final int COL_ENDERECO = 2; 
	
	
	private List<Colaborador> informacoes;       

	public ColaboradorTableModel(List<Colaborador> infomacoes) {
		this.informacoes = new ArrayList<Colaborador>(informacoes);
	}

	public int getRowCount() {
		return informacoes.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {
		if (column == COL_CPF) return "CPF";
		if (column == COL_NOME) return "Nome";
		if (column == COL_ENDERECO) return "Endereço";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		Colaborador colaborador = informacoes.get(row);
		if (column == COL_CPF)
			return colaborador.getCpf();
		if (column == COL_NOME)
			return colaborador.getNome();
		else 
			if (column == COL_ENDERECO) 
					return colaborador.getEndereco();
		return ""; 
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Colaborador colaborador = informacoes.get(rowIndex);
		
		if (columnIndex == COL_CPF)
			colaborador.setCpf(aValue.toString());
		if (columnIndex == COL_NOME)
			colaborador.setNome(aValue.toString());
		else 
			if (columnIndex == COL_ENDERECO) 
				colaborador.setEndereco(aValue.toString());
	}

	public Class<?> getColumnClass(int columnIndex) {
	
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public Colaborador get(int row) {
		return informacoes.get(row);
	}
	
}

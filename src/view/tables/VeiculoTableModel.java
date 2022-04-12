package view.tables;

import java.util.ArrayList;
import java.util.List;

import models.Colaborador;
import models.Veiculo;

public class VeiculoTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_PLACA = 0;
	private static final int COL_AUTONOMIA = 1;
	
	
	private List<Veiculo> informacoes;       

	public VeiculoTableModel(List<Veiculo> infomacoes) {
		this.informacoes = new ArrayList<Veiculo>(informacoes);
	}

	public int getRowCount() {
		return informacoes.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int column) {
		if (column == COL_PLACA) return "Placa";
		if (column == COL_AUTONOMIA) return "Autonomia por Litro";
		return ""; 
	}

	public Object getValueAt(int row, int column) {
		Veiculo veiculo = informacoes.get(row);
		if (column == COL_PLACA)
			return veiculo.getPlaca();
		else 
			if (column == COL_AUTONOMIA) 
					return veiculo.getAutonomiaLitro();
		return ""; 
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Veiculo veiculo = informacoes.get(rowIndex);
		
		if (columnIndex == COL_PLACA)
			veiculo.setPlaca(aValue.toString());
		else 
			if (columnIndex == COL_AUTONOMIA) 
				veiculo.setAutonomiaLitro(Double.parseDouble(toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
	
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public Veiculo get(int row) {
		return informacoes.get(row);
	}
}

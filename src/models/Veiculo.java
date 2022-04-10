package models;

public class Veiculo {
	
	private int id;
	private String placa;
	private double autonomiaLitro;
	private boolean disponibilidade; 
	
	public Veiculo() {
		
	}
	
	public Veiculo(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getAutonomiaLitro() {
		return autonomiaLitro;
	}
	public void setAutonomiaLitro(double autonomiaLitro) {
		this.autonomiaLitro = autonomiaLitro;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String toString() {
		return String.format("ID: %s - Placa: %s - Autonomia por Litro: %s - Disponibilidade: %s", this.id, this.placa, this.autonomiaLitro,this.disponibilidade);
	}

}

package models;

public class Chamado {
	
	private int numeroProtocolo;
	private String enderecoAtendimento;
	private double kmPercorrido;
	private Veiculo veiculo;
	private double emissaoCo2;
	
	public Chamado(double kmPercorrido, Veiculo veiculo) {
		if (this.kmPercorrido > 0) {
			this.kmPercorrido = kmPercorrido;
			this.veiculo = veiculo;
			calculaEmissaoCo2();
		}
	}
		

	
	public int getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(int numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public String getEnderecoAtendimento() {
		return enderecoAtendimento;
	}
	public void setEnderecoAtendimento(String enderecoAtendimento) {
		this.enderecoAtendimento = enderecoAtendimento;
	}
	public double getKmPercorrido() {
		return kmPercorrido;
	}
	public void setKmPercorrido(double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void calculaEmissaoCo2() {
		double consumoGasolina = this.kmPercorrido * this.veiculo.getAutonomiaLitro();
		this.setEmissaoCo2(consumoGasolina * 0.82 * 0.75 * 3.7); 
		
	}



	public double getEmissaoCo2() {
		return emissaoCo2;
	}



	public void setEmissaoCo2(double emissaoCo2) {
		this.emissaoCo2 = emissaoCo2;
	}

}

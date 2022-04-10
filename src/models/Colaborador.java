package models;

public class Colaborador {
	
	private int id;
	private String cpf;
	private String nome;
	private Boolean habilitado;
	private String endereco;
	
	public Colaborador(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}
	public Colaborador() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String toString() {
		return String.format("ID: %s - Nome: %s - CPF: %s - Endereço: %s", this.id, this.nome, this.cpf,this.endereco);
	}

}
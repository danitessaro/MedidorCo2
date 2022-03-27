package models;

public class Colaborador {
	
	private int id;
	private String cpf;
	private String nome;
	private Boolean cnh;
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
	public Boolean getCnh() {
		return cnh;
	}
	public void setCnh(Boolean cnh) {
		this.cnh = cnh;
	}
	public String getEndereço() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String toString() {
		return String.format("ID: %s - Nome: %s - CPF: %s - Endereço: %s", this.id, this.nome, this.cpf,this.endereco);
	}

}
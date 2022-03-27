package dao;

import java.util.ArrayList;
import java.util.List;
import models.Veiculo;

public class VeiculoDao {
	
	private static VeiculoDao instance;
	private List<Veiculo> listaVeiculos = new ArrayList<>();
	
	/*
	 * Singleton
	 */
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void salvar(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) {
		listaVeiculos.set(veiculo.getId(), veiculo);
	}
	
	public void excluir(Veiculo veiculo) {
	 	listaVeiculos.remove(veiculo);
	}
	
	public List<Veiculo> listar(){
		return listaVeiculos;
	}

}

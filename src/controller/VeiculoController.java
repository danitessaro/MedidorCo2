package controller;

import java.util.List;
import dao.VeiculoDao;
import models.Veiculo;

public class VeiculoController {
	
	public void salvar(Veiculo veiculo) throws Exception {
		if (veiculo.getId() == 0) {
			throw new Exception("Veículo inválido");
		}
		VeiculoDao.getInstance().salvar(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws Exception {
		if (veiculo.getId() == 0) {
			throw new Exception("Veículo inválido");
		}
		VeiculoDao.getInstance().atualizar(veiculo);
	}
	
//	public void excluir(Veiculo veiculo) throws Exception {
//		if (veiculo.getId() == 0) {
//			throw new Exception("Nenhum veículo selecionado");
//		}
//		VeiculoDao.getInstance().excluir(veiculo);
//	}
//	
	public List<Veiculo> listar(){
		return VeiculoDao.getInstance().listar();
	}

}

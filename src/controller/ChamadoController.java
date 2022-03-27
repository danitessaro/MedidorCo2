package controller;

import java.util.List;

import dao.ChamadoDao;
import models.Chamado;

public class ChamadoController {
	
	public void salvar(Chamado chamado) throws Exception {
		if (chamado.getNumeroProtocolo() == 0) {
			throw new Exception("Número de protocolo inválido");
		}
		ChamadoDao.getInstance().salvar(chamado);
	}
	
	public void atualizar(Chamado chamado) throws Exception {
		if (chamado.getNumeroProtocolo() == 0) {
			throw new Exception("Número de protocolo inválido");
		}
		ChamadoDao.getInstance().atualizar(chamado);
	}
	
	public void excluir(int idChamado) throws Exception {
		if (idChamado == 0) {
			throw new Exception("Nenhum chamado selecionado");
		}
		ChamadoDao.getInstance().excluir(idChamado);
	}
	
	public List<Chamado> listar(){
		return ChamadoDao.getInstance().listar();
	}

}

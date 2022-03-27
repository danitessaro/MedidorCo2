package controller;

import java.util.List;

import dao.ColaboradorDao;
import models.Colaborador;

public class ColaboradorController {
	
	public void salvar(Colaborador colaborador) throws Exception {
		if (colaborador.getNome() == null || colaborador.getNome().length() < 3) {
			throw new Exception("Nome inválido");
		}
		ColaboradorDao.getInstance().salvar(colaborador);
	}
	
	public void atualizar(Colaborador colaborador) throws Exception {
		if (colaborador.getNome() == null || colaborador.getNome().length() < 3) {
			throw new Exception("Nome inválido");
		}
		ColaboradorDao.getInstance().atualizar(colaborador);
	}
	
	public void excluir(int idColaborador) throws Exception {
		if (idColaborador == 0) {
			throw new Exception("Nenhum colaborador selecionado");
		}
		ColaboradorDao.getInstance().excluir(idColaborador);
	}
	
	public List<Colaborador> listar(){
		return ColaboradorDao.getInstance().listar();
	}

}

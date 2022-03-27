package dao;

import java.util.ArrayList;
import java.util.List;
import models.Chamado;

public class ChamadoDao {

	private static ChamadoDao instance;
	private List<Chamado> listaChamados = new ArrayList<>();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		listaChamados.add(chamado);
	}
	
	public void atualizar(Chamado chamado) {
		listaChamados.set(chamado.getNumeroProtocolo(), chamado);
	}
	
	public void excluir(int numeroProtocolo) {
		listaChamados.remove(numeroProtocolo);
	}
	
	public List<Chamado> listar(){
		return listaChamados;
	}

}

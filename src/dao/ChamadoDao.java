package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Chamado;
import models.Veiculo;
import util.ConnectionUtil;

public class ChamadoDao {

	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void salvar(Chamado chamado) {
		
		try {
			String sql = "insert into chamado (Numero_protocolo, Endereco_atendimento, Km_percorrido, Veiculo_Id_Carro) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chamado.getNumeroProtocolo());
			pstmt.setString(2, chamado.getEnderecoAtendimento());
			pstmt.setDouble(3, chamado.getKmPercorrido());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(Chamado chamado) {
		
		try {
			String sql = "update chamado set Numero_protocolo = ?, Endereco_atendimento = ?, Km_percorrido = ?, Veiculo_Id_Carro = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chamado.getNumeroProtocolo());
			pstmt.setString(2, chamado.getEnderecoAtendimento());
			pstmt.setDouble(3, chamado.getKmPercorrido());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir(int numeroProtocolo) {
		
		try {
			String sql = "delete from chamado where Numero_protocolo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, numeroProtocolo);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Chamado> listar(){
		
		List<Chamado> listaChamados = new ArrayList<>();
		try {
			String sql = "select * from Chamados";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setNumeroProtocolo(rs.getInt("Numero_protocolo"));
				chamado.setEnderecoAtendimento(rs.getString("Endereco_atendimento"));
				chamado.setKmPercorrido(rs.getDouble("Km_Percorrido"));
				chamado.setVeiculo(new Veiculo(rs.getInt("Veiculos_Id_carro")));
				listaChamados.add(chamado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}
		
}



package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {
	
	private static VeiculoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
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
		try {
			String sql = "insert into veiculo (Id_carro, placa, Autonomia_Litro, disponibilidade) values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, veiculo.getId());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setDouble(3, veiculo.getAutonomiaLitro());
			pstmt.setBoolean(4, veiculo.isDisponibilidade());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		
		try {
			String sql = "update veiculo set Id_carro = ?, placa = ?, Autonomia_litro = ?, disponibilidade = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, veiculo.getId());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setDouble(3, veiculo.getAutonomiaLitro());
			pstmt.setBoolean(4, veiculo.isDisponibilidade());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluir(int idVeiculo) {
	 	
		try {
			String sql = "delete from Veiculos where Id_carro = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idVeiculo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Veiculo> listar(){
		
		List<Veiculo> listaColaboradores = new ArrayList<>();
		try {
			String sql = "select * from Veiculos";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("Id_carro"));
				v.setPlaca(rs.getString("placa"));
				v.setAutonomiaLitro(rs.getDouble("Autonomia_litro"));
				v.setDisponibilidade(rs.getBoolean("disponibilidade"));
				listaColaboradores.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaboradores;
	}
		
}



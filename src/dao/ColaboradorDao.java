package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Colaborador;
import util.ConnectionUtil;

public class ColaboradorDao {

	private static ColaboradorDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton
	 */
	
	public static ColaboradorDao getInstance() {
		if (instance == null) {
			instance = new ColaboradorDao();
		}
		return instance;
	}
	
	public void salvar(Colaborador colaborador) {
		
		try {
			String sql = "insert into Colaboradores (id_Colaboradores, cpf, Nome, Habilitado, Endereco) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, colaborador.getId());
			pstmt.setString(2, colaborador.getCpf());
			pstmt.setString(3, colaborador.getNome());
			pstmt.setString(4, colaborador.getEndereco());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(Colaborador colaborador) {
		
		try {
			String sql = "update Colaboradores set id_Colaboradores = ?, cpf = ?, Nome = ?, Endereco = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, colaborador.getId());
			pstmt.setString(2, colaborador.getCpf());
			pstmt.setString(3, colaborador.getNome());
			pstmt.setString(4, colaborador.getEndereco());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idColaborador) {
		
		try {
			String sql = "delete from Colaboradores where id_Colaboradores = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idColaborador);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Colaborador> listar(){
		
		List<Colaborador> listaColaboradores = new ArrayList<>();
		try {
			String sql = "select * from Colaboradores";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Colaborador c = new Colaborador();
				c.setId(rs.getInt("id_Colaboradores"));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("Nome"));
				c.setEndereco(rs.getString("Endereco"));
				listaColaboradores.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaColaboradores;
	}
		
	}



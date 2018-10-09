package br.com.senac.desweb.prodmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.desweb.prodmanager.connection.ConnectionFactory;
import br.com.senac.desweb.prodmanager.model.Categoria;

public class ProdutoCategoriaDAO {
	
	static Connection cn = null;
	
	public void inserir(int idProduto, List<Categoria> listCategoria) throws SQLException{

		String sql = "INSERT INTO PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA) "
				+ "VALUES(?, ?)";

		PreparedStatement stmt = null;
		

		cn = ConnectionFactory.getConnection();

		try {
			
			for(int i = 0; i<listCategoria.size(); i++) {
				stmt = cn.prepareStatement(sql);
				stmt.setInt(1, idProduto);
				stmt.setInt(2, listCategoria.get(i).getId());
				stmt.execute();
			}


		} finally {
			ConnectionFactory.closeConnection(cn, stmt);
		}

	}
	
	public void alterar(int idProduto, List<Categoria> listCategoria) throws SQLException{

		String sql = "UPDATE PRODUTO_CATEGORIA SET ID_PRODUTO = ?, ID_CATEGORIA = ? "
				+ "WHERE ID_PRODUTO = ?)";

		PreparedStatement stmt = null;
		cn = ConnectionFactory.getConnection();

		try {
			
			for(int i = 0; i<listCategoria.size(); i++) {
				stmt = cn.prepareStatement(sql);
				stmt.setInt(1, idProduto);
				stmt.setInt(2, listCategoria.get(i).getId());
				stmt.execute();
			}


		} finally {
			ConnectionFactory.closeConnection(cn, stmt);
		}

	}
	
	public List<Categoria> listar(int idProduto) throws SQLException{

		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT * FROM CATEGORIA C INNER JOIN PRODUTO_CATEGORIA PC ON C.ID = PC.ID_CATEGORIA"
				+ " WHERE PC.ID_PRODUTO = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		cn = ConnectionFactory.getConnection();

		try {
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("ID"));
				cat.setNome(rs.getString("NOME"));
				categorias.add(cat);
			}
			

		} finally {
			ConnectionFactory.closeConnection(cn, stmt, rs);
		}
		return categorias;

	}
	

}

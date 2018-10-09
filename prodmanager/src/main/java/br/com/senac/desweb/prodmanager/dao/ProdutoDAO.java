package br.com.senac.desweb.prodmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.desweb.prodmanager.connection.ConnectionFactory;
import br.com.senac.desweb.prodmanager.model.Produto;

public class ProdutoDAO {
	
	static Connection cn = null;
	
	public void inserir(Produto produto) {

		String sql = "INSERT INTO Produto (ID, NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DISPONIVEL, DT_CADASTRO) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		cn = ConnectionFactory.getConnection();

		
		

		try {

			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getPrecoCompra());
			stmt.setDouble(5, produto.getPrecoVenda());
			stmt.setInt(6, produto.getQtd());
			stmt.setBoolean(7, produto.isDisponivel());
			stmt.setDate(8, new Date (produto.getDtCadastro().getTime()));
			stmt.execute();
			
//			Retornando o ID do produto recem cadastrado.
			rs = stmt.getGeneratedKeys();
            int i = 0;
            if (rs.next()) {
                i = rs.getInt(1);
                System.out.println(i);
                produto.setId(i);
//                System.out.println(produto.getId());
            }

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(cn, stmt, rs);
		}

	}
	
	public void atualizar(Produto produto) throws SQLException{
		
		String sql = "UPDATE PRODUTO SET ID=?, NOME=?, DESCRICAO=?, PRECO_COMPRA=?, PRECO_VENDA=?, QUANTIDADE=?, DISPONIVEL=?, DT_CADASTRO=?"
				+ "WHERE ID=?";
		PreparedStatement stmt = null;
		cn = ConnectionFactory.getConnection();
		
		try {
			stmt = cn.prepareStatement(sql);
			stmt.setLong(1, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getPrecoCompra());
			stmt.setDouble(5, produto.getPrecoVenda());
			stmt.setInt(6, produto.getQtd());
			stmt.setBoolean(7, produto.isDisponivel());
			stmt.setDate(8, new Date (produto.getDtCadastro().getTime()));
			stmt.setLong(9, produto.getId());
			stmt.execute();
			
			
			
		} finally {
			ConnectionFactory.closeConnection(cn, stmt);
		}
		
	}
	
public void excluir(Produto produto) throws SQLException{
		
		String sql = "UPDATE PRODUTO DISPONIVEL=? WHERE ID=?";
		PreparedStatement stmt = null;
		cn = ConnectionFactory.getConnection();
		
		try {
			stmt = cn.prepareStatement(sql);
			stmt.setBoolean(7, produto.isDisponivel());
			stmt.setLong(9, produto.getId());
			stmt.execute();
	
			
		} finally {
			ConnectionFactory.closeConnection(cn, stmt);
		}
		
	}

public List<Produto> listar() throws SQLException{
	
	List<Produto> lista = new ArrayList<>();
	String sql = "SELECT * FROM PRODUTO";
	PreparedStatement stmt = null;
	cn = ConnectionFactory.getConnection();
	ResultSet rs = null;
	
	try {
		
		stmt = cn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Produto p = new Produto();
			
			p.setId(rs.getLong("ID"));
			p.setNome(rs.getString("NOME"));
			p.setDescricao(rs.getString("DESCRCAO"));
			p.setPrecoCompra(rs.getDouble("PRECO_COMPRA"));
			p.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
			p.setQtd(rs.getInt("QUANTIDADE"));
			p.setDisponivel(rs.getBoolean("DISPONIVEL"));
			p.setDtCadastro(new java.util.Date(rs.getDate("DT_CADASTRO").getTime()));
			lista.add(p);
		}
		
	} finally {
		ConnectionFactory.closeConnection(cn, stmt, rs);
	}
	
	
	return lista;
}
	

}

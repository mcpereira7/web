package br.com.senac.desweb.prodmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Categoria> listaCategoria(int idProduto){
		List<Categoria> lista = new ArrayList<>();
			
		return lista;
	}

}

package br.com.senac.desweb.prodmanager.model;

import java.util.List;
import java.util.Date;

public class Produto {

	private long id;
	private String nome;
	private String descricao;
	private double precoCompra;
	private double precoVenda;
	private int qtd;
	private boolean disponivel;
	private Date dtCadastro;
	private List<Categoria> catPoduto;
	
	public Produto() {
		
	}

	public Produto(long id, String nome, String descricao, double precoCompra, double precoVenda, int qtd,
		boolean disponivel, Date dtCadastro) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.qtd = qtd;
		this.disponivel = disponivel;
		this.dtCadastro = dtCadastro;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public List<Categoria> getCatPoduto() {
		return catPoduto;
	}

	public void setCatPoduto(List<Categoria> catPoduto) {
		this.catPoduto = catPoduto;
	}
	
	
	
	
}

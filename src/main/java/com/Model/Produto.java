package com.Model;

import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

	private int id_produto;
	private String nome;
	private String descricao;
	private String mercado;
	private String tecnologia;
	
	public Produto () {		
	}

	public Produto(int id_produto, String nome, String descricao, String mercado, String tecnologia) {
		this.id_produto = id_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.mercado = mercado;
		this.tecnologia = tecnologia;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
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

	public String getMercado() {
		return mercado;
	}

	public void setMercado(String mercado) {
		this.mercado = mercado;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
}

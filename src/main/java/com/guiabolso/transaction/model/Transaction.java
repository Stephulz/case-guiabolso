package com.guiabolso.transaction.model;

public class Transaction {

	private String descricao;

	private Long data;

	private Integer valor;

	public Transaction(String descricao, Long data, Integer valor) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
}

package br.com.model;

public class Log {
	private String cnpjFornecedor;
	private String nome;
	private String data;
	private int qtd;
	private int id;
	private String acao;
	
	public Log(String cnpjFornecedor, String nome, String data, int qtd, int id, String acao) {
		this.cnpjFornecedor = cnpjFornecedor;
		this.nome = nome;
		this.data = data;
		this.qtd = qtd;
		this.id = id;
		this.acao = acao;
	}
	
	public Log(){
		
	}
	
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
}

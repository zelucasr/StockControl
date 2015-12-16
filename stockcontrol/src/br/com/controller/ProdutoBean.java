package br.com.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.business.ProdutoService;
import br.com.exception.BadCNPJException;
import br.com.exception.BadProductNameException;
import br.com.exception.BadProductQtdException;
import br.com.model.Produto;

@RequestScoped
@ManagedBean
public class ProdutoBean {

	private Produto produto;
	private int id;
	private String cnpj;
	private Produto resultado;
	private ArrayList<Produto> all;
	private ProdutoService meuService = ProdutoService.getInstance();

	@PostConstruct
	public void init() {
		produto = new Produto();
		resultado = new Produto();
		all = new ArrayList<Produto>();
	}

	public Produto getProduto() {
		return produto;
	}

	public void saveProduto() throws BadCNPJException, BadProductNameException, BadProductQtdException {
		meuService.add(produto, cnpj);
	}

	public void procurarProduto() {
		resultado = meuService.getProductByName(produto.getNome());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getResultado() {
		return resultado;
	}

	public void setResultado(Produto resultado) {
		this.resultado = resultado;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Produto> getAll() {
		all = meuService.getAllProducts();
		return all;
	}

	public void setAll(ArrayList<Produto> all) {
		this.all = all;
	}

	public void delete() {
		String id =	(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		meuService.remove(id);
	}

}

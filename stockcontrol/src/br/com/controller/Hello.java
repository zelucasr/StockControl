package br.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.model.Produto;

@RequestScoped
@ManagedBean
public class Hello {
	
	public Produto produto;
	
	@PostConstruct
	public void init() {
		produto = new Produto();
	}

	public String getMessage() {
		return "O importante é o que importa!";
	}
	
	public String getHorario() {
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    return "Atualizado em " + sdf.format(new Date());
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	public void nomeFoiDigitado() {
	    System.out.println("\nChamou o botão");
	  }
	
}
package br.com.controller;

import java.util.ArrayList;

import br.com.business.UserService;
import br.com.exception.BadLoginException;
import br.com.exception.BadPasswordException;
import br.com.exception.UserPassNotMatchException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.model.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private User usuario;
	private ArrayList<User> all;
	private UserService meuService = UserService.getInstance();
	
	@PostConstruct
	public void init() {
		this.usuario = new User();
		all = meuService.getAllUsers();
	}
	
	public void setUsuario(User usuario){
		this.usuario = usuario;
	}

	public User getUsuario() {
		return usuario;
	}
	
	public ArrayList<User> getAll() {
		return all;
	}

	public String fazerLogin() throws BadLoginException, BadPasswordException, UserPassNotMatchException{
		meuService.fazerLogin(usuario);
		return "control";
	}
	
	public void cadastrar() throws BadLoginException, BadPasswordException{
		meuService.fazerCadastro(usuario.getLogin(), usuario.getPassword());
		usuario.setLogin("");
		usuario.setPassword("");
	}
}

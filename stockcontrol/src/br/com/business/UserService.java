package br.com.business;

import java.util.ArrayList;

import br.com.dao.UserDao;
import br.com.exception.BadLoginException;
import br.com.exception.BadPasswordException;
import br.com.exception.UserPassNotMatchException;
import br.com.helpers.UserPassMatchValidator;
import br.com.helpers.UserValidator;
import br.com.model.User;

public class UserService {
	private UserDao dao;
	private static UserService meuService;
	
	private UserService(){
		dao = new UserDao();
	}
	
	public void fazerLogin(User usuario) throws BadLoginException, BadPasswordException, UserPassNotMatchException{
		UserValidator uValidator = new UserValidator();
		uValidator.validate(usuario);
		User user = dao.findByLogin(usuario.getLogin());
		UserPassMatchValidator mValidator = new UserPassMatchValidator();
		mValidator.validate(usuario, user);
	}
	
	public void fazerCadastro(String login, String senha) throws BadLoginException, BadPasswordException{
		User user = new User();
		user.setLogin(login);
		user.setPassword(senha);
		UserValidator uValidator = new UserValidator();
		uValidator.validate(user);
		dao.save(user);
	}
	
	public ArrayList<User> getAllUsers(){
		return dao.findAll();
	}
	
	public static synchronized UserService getInstance() {
		if (meuService == null)
			meuService = new UserService();
		return meuService;
	}
	
}

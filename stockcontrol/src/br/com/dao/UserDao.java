package br.com.dao;

import java.util.ArrayList;

import br.com.model.User;

public class UserDao{
	
	private ArrayList<User> lista = new ArrayList<User>();
	private int identificador = 0;
	
	public void save(User user){
		if(findByLogin(user.getLogin())==null){
			user.setId(identificador);
			identificador++;
			lista.add(user);
		}
	}
	
	public void delete(int id){
		lista.remove(id);
		for(int i = id; i < lista.size(); i++){
			lista.get(id).setId(id);
		}
	}
	
	public User getById(int id){
		return lista.get(id);
	}
	
	public ArrayList<User> findAll(){
		return lista;
	}
	
	public User findByLogin(String login){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getLogin().equals(login)){
				return lista.get(i);
			}
		}
		return null;
	}
	
	public User findById(int id){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getId()==id){
				return lista.get(i);
			}
		}
		return null;
	}
}
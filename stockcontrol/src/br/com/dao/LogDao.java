package br.com.dao;

import java.util.ArrayList;

import br.com.model.Log;

public class LogDao implements ILogDao{
	
	private ArrayList<Log> lista = new ArrayList<Log>();
	private int identificador = 0;
	
	public void save(Log log){
		log.setId(identificador);
		identificador++;
		lista.add(log);
	}
	
	public void delete(int id){
		lista.remove(id);
		for(int i = id; i < lista.size(); i++){
			lista.get(id).setId(id);
		}
	}
	
	public Log getById(int id){
		return lista.get(id);
	}
	
	public ArrayList<Log> findAll(){
		return lista;
	}

	public ArrayList<Log> findByCNPJ(String cnpj) {
		ArrayList<Log> resultado = new ArrayList<Log>();
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getCnpjFornecedor().equals(cnpj)){
				resultado.add(lista.get(i));
			}
		}
		return resultado;
	}
	
	public ArrayList<Log> findByDate(String data){
		ArrayList<Log> resultado = new ArrayList<Log>();
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getData().equals(data)){
				resultado.add(lista.get(i));
			}
		}
		return resultado;
	}
}
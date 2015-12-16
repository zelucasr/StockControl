package br.com.dao;

import java.util.ArrayList;

import br.com.model.Log;

public interface ILogDao {
	void save(Log log);
	void delete(int id);
	Log getById(int id);
	ArrayList<Log> findByCNPJ(String cnpj);
	ArrayList<Log> findByDate(String data);
	ArrayList<Log> findAll();
}
package br.com.business;

import java.util.ArrayList;

import br.com.dao.LogDao;
import br.com.exception.BadCNPJException;
import br.com.exception.BadProductNameException;
import br.com.exception.BadProductQtdException;
import br.com.helpers.*;
import br.com.model.Log;

public class LogService {
	private LogDao dao;
	private static LogService meuService;
	
	public LogService() {
        dao = new LogDao();
    }
	
	public void add(Log log) throws BadCNPJException, BadProductQtdException, BadProductNameException{
		//CNPJValidator cnpjValidator = new CNPJValidator();
		//ProductNameValidator pnameValidator = new ProductNameValidator();
		QtdProductValidator qtdpValidator = new QtdProductValidator();
		
        //cnpjValidator.validate(null, null, log.getCnpjFornecedor());
        //pnameValidator.validate(log.getNome());
		qtdpValidator.validate(log.getQtd());
		
		dao.save(log);
    }
	
	public ArrayList<Log> getLogByCNPJ(String cnpj) throws BadCNPJException{
		//CNPJValidator cnpjValidator = new CNPJValidator();
		//cnpjValidator.validate(cnpj);
		return dao.findByCNPJ(cnpj);
	}
	
	public ArrayList<Log> getAllLogs(){
		return dao.findAll();
	}
	
	public void remove(int id){
		dao.delete(id);
	}
	
	public static synchronized LogService getInstance() {
		if (meuService == null){
			meuService = new LogService();
		}
		return meuService;
	}
}

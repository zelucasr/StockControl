package br.com.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.business.LogService;
import br.com.exception.BadCNPJException;
import br.com.exception.BadProductNameException;
import br.com.exception.BadProductQtdException;
import br.com.model.Log;

@RequestScoped
@ManagedBean
public class LogBean {
	
	private Log log;
	private ArrayList<Log> all;
	private LogService meuService = LogService.getInstance();
	
	@PostConstruct
	public void init() {
		this.log = new Log();
		all = meuService.getAllLogs();
	}
	
	public void saveLog() throws BadCNPJException, BadProductQtdException, BadProductNameException{
		meuService.add(log);
	}
	
	public void getLogByCNPJ() throws BadCNPJException{
		all = meuService.getLogByCNPJ(log.getCnpjFornecedor());
	}
	
	public ArrayList<Log> getAll(){
		return all;
	}
	
	public void removeLogById(int id){
		meuService.remove(id);
	}
	public Log getLog(){
		return log;
	}
}
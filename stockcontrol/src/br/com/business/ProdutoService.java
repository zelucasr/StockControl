package br.com.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

import br.com.dao.ProdutoDao;
import br.com.exception.BadCNPJException;
import br.com.exception.BadProductNameException;
import br.com.exception.BadProductQtdException;
import br.com.helpers.*;
import br.com.model.Log;
import br.com.model.Produto;

public class ProdutoService {
	private ProdutoDao dao;
	private static ProdutoService meuService;
	private LogService logService = LogService.getInstance();
	
	public ProdutoService() {
        dao = new ProdutoDao();
    }
	
	public void add(Produto produto, String cnpj) throws BadCNPJException, BadProductNameException, BadProductQtdException{
		//CNPJValidator cnpjValidator = new CNPJValidator();
		//ProductNameValidator pnameValidator = new ProductNameValidator();
		QtdProductValidator qtdpValidator = new QtdProductValidator();
		
		//cnpjValidator.validate(cnpj);
		//pnameValidator.validate(produto.getNome());
		qtdpValidator.validate(produto.getQtd());
		
		dao.save(produto);
		
		Locale locale = new Locale("pt","BR");
		GregorianCalendar calendar = new GregorianCalendar(); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy' - 'HH':'mm'h'",locale);
		String data = formatador.format(calendar.getTime());
		Log meuLog = new Log(cnpj, produto.getNome(), data, produto.getQtd(), 0, "Adicionar");
		
		logService.add(meuLog);
    }
	
	public Produto getProductByName(String name){
		return dao.getByName(name);
	}
	
	public Produto getProductById(int id){
		return dao.getById(id);
	}
	
	public ArrayList<Produto> getAllProducts(){
		return (ArrayList<Produto>) dao.findAll();
	}
	
	public void remove(String name){
		dao.delete(name);
	}
	
	public static synchronized ProdutoService getInstance() {
		if (meuService == null)
			meuService = new ProdutoService();
		return meuService;
	}
}

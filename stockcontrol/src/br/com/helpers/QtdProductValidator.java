package br.com.helpers;

import br.com.exception.BadProductQtdException;

public class QtdProductValidator implements IValidator{
	public void validate(Object obj) throws BadProductQtdException{
		int qtd = (Integer) obj;
		if(qtd <= 0){
			throw new BadProductQtdException();
		}
	}
}

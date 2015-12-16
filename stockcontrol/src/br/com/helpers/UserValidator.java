package br.com.helpers;

import br.com.model.User;
import br.com.exception.BadLoginException;
import br.com.exception.BadPasswordException;

public class UserValidator implements IValidator{
	public void validate(Object obj) throws BadLoginException, BadPasswordException{
		User user = (User) obj;
		if(user.getLogin().equals("")){
			throw new BadLoginException();
		}
		if(user.getPassword().equals("")){
			throw new BadPasswordException();
		}
	}
}

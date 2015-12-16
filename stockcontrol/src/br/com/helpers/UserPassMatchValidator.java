package br.com.helpers;

import br.com.exception.UserPassNotMatchException;
import br.com.model.User;

public class UserPassMatchValidator{
	public void validate(Object obj1, Object obj2) throws UserPassNotMatchException {
		User user1 = (User) obj1;
		User user2 = (User) obj2;
		if(!user1.getPassword().equals(user2.getPassword())){
			throw new UserPassNotMatchException();
		}
	}
}

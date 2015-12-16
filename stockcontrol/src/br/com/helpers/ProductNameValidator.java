package br.com.helpers;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ProductNameValidator implements Validator{
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException{
		String str = (String) obj;
		if(str.equals("")){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("O nome não pode ficar em branco.");
			throw new ValidatorException(message);
		}
	}
}
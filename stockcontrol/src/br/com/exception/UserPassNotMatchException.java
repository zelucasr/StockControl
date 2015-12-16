package br.com.exception;

public class UserPassNotMatchException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Login e senha não conferem. Tente novamente.";
	}
}

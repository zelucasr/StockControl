package br.com.exception;

public class BadPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O campo senha não pode ficar em branco.";
	}
}

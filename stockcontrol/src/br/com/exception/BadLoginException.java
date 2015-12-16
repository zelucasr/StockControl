package br.com.exception;

public class BadLoginException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O campo login não pode ficar em branco.";
	}
}

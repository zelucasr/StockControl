package br.com.exception;

public class BadProductNameException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O campo nome do produto não pode ficar em branco.";
	}
}

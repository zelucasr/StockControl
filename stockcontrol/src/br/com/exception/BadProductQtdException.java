package br.com.exception;

public class BadProductQtdException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "A quantidade deve ser maior que 0.";
	}
}

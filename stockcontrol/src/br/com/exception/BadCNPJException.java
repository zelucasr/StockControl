package br.com.exception;

public class BadCNPJException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O CNPJ informado n�o � um CNPJ v�lido.";
	}
}

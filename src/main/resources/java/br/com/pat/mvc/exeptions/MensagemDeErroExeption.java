package br.com.pat.mvc.exeptions;

public class MensagemDeErroExeption extends RuntimeException {

	private static final long serialVersionUID = -618210585197817999L;

	public MensagemDeErroExeption(String mensagem) {
		super(mensagem);
	}

}

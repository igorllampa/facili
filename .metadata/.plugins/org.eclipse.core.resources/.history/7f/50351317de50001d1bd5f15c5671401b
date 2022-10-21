package br.com.facilitecommerce.domain.exception;

public class CupomNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public CupomNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CupomNaoEncontradoException(Long cupomId) {
		this(String.format("O cupom %d não foi encontrado.", cupomId));
	}
}

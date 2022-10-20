package br.com.facilitecommerce.domain.exception;

public class CarrinhoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public CarrinhoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CarrinhoNaoEncontradoException(Long carrinhoId) {
		this(String.format("O carrinho %d não foi encontrado.", carrinhoId));
	}
}

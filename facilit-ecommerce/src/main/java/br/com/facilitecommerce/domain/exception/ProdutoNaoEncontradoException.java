package br.com.facilitecommerce.domain.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoNaoEncontradoException(Long produtoId) {
		this(String.format("O produto %d não foi encontrado.", produtoId));
	}
}

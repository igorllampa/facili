package br.com.facilitecommerce.domain.exception;

public class ItemCarrinhoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ItemCarrinhoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public ItemCarrinhoNaoEncontradoException(Long carrinhoId, Long itemCarrinhoId) {
		this(String.format("O item %d do carrinho %d não foi encontrado.", itemCarrinhoId, carrinhoId));
	}
}

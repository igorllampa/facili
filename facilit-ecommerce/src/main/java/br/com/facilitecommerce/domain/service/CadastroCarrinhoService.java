package br.com.facilitecommerce.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.facilitecommerce.domain.exception.EntidadeEmUsoException;
import br.com.facilitecommerce.domain.exception.ProdutoNaoEncontradoException;
import br.com.facilitecommerce.domain.model.Carrinho;
import br.com.facilitecommerce.domain.model.Produto;
import br.com.facilitecommerce.domain.repository.CarrinhoRepository;
import br.com.facilitecommerce.domain.repository.ProdutoRepository;

@Service
public class CadastroCarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Transactional
	public Carrinho salvar (Carrinho carrinho) {
		return carrinhoRepository.save(carrinho);
	}
	
	@Transactional
	public void remover(Long carrinhoId) {
		
		carrinhoRepository.deleteById(carrinhoId);
		
	}
	
	public Carrinho buscar(Long carrinhoId) {
		return carrinhoRepository.findById(carrinhoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(carrinhoId) );
	}
}

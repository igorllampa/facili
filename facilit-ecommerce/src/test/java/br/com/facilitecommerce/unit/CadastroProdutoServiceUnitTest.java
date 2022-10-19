package br.com.facilitecommerce.unit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.facilitecommerce.domain.model.Produto;
import br.com.facilitecommerce.domain.service.CadastroProdutoService;

@SpringBootTest
public class CadastroProdutoServiceUnitTest {

	@Autowired
	CadastroProdutoService cadastroProdutoService;
	
	@Test 
	public void deveRetornarSucesso_QuandoCadastrarProduto() {
	    Produto produto = new Produto();
	    produto.setNome("Produto Teste");
	    produto.setPreco(new BigDecimal(18));	   	   
	    
	    Produto produtoCadastrado = cadastroProdutoService.salvar(produto);
	    
	    assertNotNull(produtoCadastrado);	    	   
	}
	
	@Test 
	public void deveFalhar_QuandoCadastrarProdutoComNomeVazio() {
				
	    Produto produto = new Produto();
	    produto.setNome("");
	    produto.setPreco(new BigDecimal(18));	   	   
	    
	    assertThrows(ConstraintViolationException.class, 
	    		() -> cadastroProdutoService.salvar(produto));
	    	    	    	    	
	}
	
	@Test 
	public void deveFalhar_QuandoCadastrarProdutoComPrecoZerado() {
				
	    Produto produto = new Produto();
	    produto.setNome("Produto");
	    produto.setPreco(BigDecimal.ZERO);	   	   
	    
	    assertThrows(ConstraintViolationException.class, 
	    		() -> cadastroProdutoService.salvar(produto));
	    	    	    	    	
	}
	
	@Test 
	public void deveFalhar_QuandoCadastrarProdutoComNomeMaiorQueLimiteMaximoDeCaracteres() {
				
	    Produto produto = new Produto();
	    produto.setNome("a".repeat(101));
	    produto.setPreco(new BigDecimal(18));	   	   
	    
	    assertThrows(ConstraintViolationException.class, 
	    		() -> cadastroProdutoService.salvar(produto));	    	    	    	    
	}	
}

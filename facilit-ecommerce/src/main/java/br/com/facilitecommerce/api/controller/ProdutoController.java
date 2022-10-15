package br.com.facilitecommerce.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.facilitecommerce.domain.model.Produto;
import br.com.facilitecommerce.domain.repository.ProdutoRepository;
import br.com.facilitecommerce.domain.service.CadastroProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private CadastroProdutoService cadastroProduto;
	
	@Autowired
	private ProdutoRepository produtoRepository;	
	
	@GetMapping("/{produtoId}")
	public Produto buscar(@PathVariable Long produtoId) {
		return cadastroProduto.buscar(produtoId);
	}
	
	@GetMapping()
	public List<Produto> listar(){
		return produtoRepository.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@RequestBody @Valid Produto produto) {
		return cadastroProduto.salvar(produto);
	}
		
	@PutMapping("/{produtoId}")
	public Produto atualizar(@PathVariable Long produtoId, @RequestBody @Valid Produto produto) {	
		
		Produto produtoAtual = cadastroProduto.buscar(produtoId);		
		
		BeanUtils.copyProperties(produto, produtoAtual, "id");	
						
		return cadastroProduto.salvar(produtoAtual);
	}
	
	@DeleteMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long produtoId) {		
		cadastroProduto.remover(produtoId);
	}		
}

package br.com.facilitecommerce.api.assembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.facilitecommerce.api.model.input.CarrinhoInput;
import br.com.facilitecommerce.domain.model.Carrinho;
import br.com.facilitecommerce.domain.model.ItemCarrinho;
import br.com.facilitecommerce.domain.model.Produto;
import br.com.facilitecommerce.domain.service.CadastroProdutoService;

@Component
public class CarrinhoInputDisassembler {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CadastroProdutoService cadastroProduto;
	
	public Carrinho toDomainObject(CarrinhoInput carrinhoInput) {					
		Carrinho carrinho = new Carrinho();			
		List<ItemCarrinho> itens = new ArrayList<>();
		
		carrinho.setCupom(null);		
		carrinho.setTotalBruto(BigDecimal.ZERO);
		carrinho.setTotalDesconto(BigDecimal.ZERO);
		carrinho.setTotalLiquido(BigDecimal.ZERO);
		carrinho.setItens(itens);
				
		carrinhoInput.getItens().stream()
			.map(item -> {				
				Produto produto = cadastroProduto.buscar(item.getProdutoId());					
				ItemCarrinho itemCarrinho = new ItemCarrinho();
				itemCarrinho.setCarrinho(carrinho);
				itemCarrinho.setProduto(produto);
				itemCarrinho.setQuantidade(item.getQuantidade());
				itemCarrinho.setValorUnitario(produto.getPreco());
				itemCarrinho.calcularValorTotal();				
				
				return itens.add(itemCarrinho);
			})
			.collect(Collectors.toList());
		
		return carrinho;
	}
}

package br.com.facilitecommerce.api.model.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoInput {

	private List<ItemCarrinhoInput> itens; 
	
}

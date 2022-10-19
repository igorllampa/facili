package br.com.facilitecommerce.domain.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<Produto> produtos;
	
	private Cupom cupom;
}

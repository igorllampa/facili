package br.com.facilitecommerce.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrinhoInput {

	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal quantidade;
	
	private Long produtoId;			
}

package br.com.facilitecommerce.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal quantidade;
	
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal valorUnitario;
	
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal valorTotal;

	@ManyToOne
	@JoinColumn(name="produto_id", nullable = false)
	private Produto produto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="carrinho_id", nullable = false)	
	private Carrinho carrinho;
	
	public void calcularValorTotal() {
		BigDecimal valorUnitario = this.getValorUnitario();
		BigDecimal quantidade = this.getQuantidade();

		if (valorUnitario == null) {
			valorUnitario = BigDecimal.ZERO;
		}

		if (quantidade == null) {
			quantidade = BigDecimal.ZERO;
		}
				
		this.setValorTotal(valorUnitario.multiply(quantidade));					
	}	
}

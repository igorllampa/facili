package br.com.facilitecommerce.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
		
	private BigDecimal totalBruto = BigDecimal.ZERO;
	
	private BigDecimal totalDesconto = BigDecimal.ZERO;
	
	private BigDecimal totalLiquido = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="cupom_id", nullable = true)
	private Cupom cupom;
	
	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	@NotNull
	private List<ItemCarrinho> itens = new ArrayList<>();
	
	public void calcularValorTotalBruto() {
		BigDecimal valorTotal = new BigDecimal(0);		
		for (ItemCarrinho item : this.getItens()) {			
			valorTotal = valorTotal.add(item.getValorTotal());			
		}								
		this.setTotalBruto(valorTotal);
		this.setTotalDesconto(BigDecimal.ZERO);
		this.setTotalLiquido(valorTotal);
	}
	
	public void calcularValorTotalDesconto() {
		
		if (cupom == null) {
			this.setTotalDesconto(BigDecimal.ZERO);
		}else {
			this.setTotalDesconto(this.cupom.getValor());
		}			
	}
	
	public void calcularValorTotalLiquido() {
		this.setTotalLiquido(this.getTotalBruto().subtract(this.getTotalDesconto()));
	}
	
	public void calcularTotais() {
		this.calcularValorTotalBruto();
		this.calcularValorTotalDesconto();
		this.calcularValorTotalLiquido();
	}
}

package br.com.facilitecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facilitecommerce.domain.model.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

}

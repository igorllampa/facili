package br.com.facilitecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facilitecommerce.domain.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}

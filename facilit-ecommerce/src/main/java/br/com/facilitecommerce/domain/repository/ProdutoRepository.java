package br.com.facilitecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facilitecommerce.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

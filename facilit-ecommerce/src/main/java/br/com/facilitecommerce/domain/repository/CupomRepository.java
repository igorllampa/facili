package br.com.facilitecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.facilitecommerce.domain.model.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Long> {

	boolean existsByNome(String nome);
}

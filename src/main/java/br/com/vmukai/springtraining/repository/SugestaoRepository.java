package br.com.vmukai.springtraining.repository;

import br.com.vmukai.springtraining.domain.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

}

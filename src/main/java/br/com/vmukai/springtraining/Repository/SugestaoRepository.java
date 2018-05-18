package br.com.vmukai.springtraining.Repository;

import br.com.vmukai.springtraining.Domain.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

}

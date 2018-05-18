package br.com.vmukai.springtraining.Repository;

import br.com.vmukai.springtraining.Domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

}

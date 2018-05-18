package br.com.vmukai.springtraining.repository;

import br.com.vmukai.springtraining.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Optional<Colaborador> findByNome(String nome);

}

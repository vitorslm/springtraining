package br.com.vmukai.springtraining.service;

import br.com.vmukai.springtraining.domain.Sugestao;
import br.com.vmukai.springtraining.repository.SugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SugestaoService {

    @Autowired
    private SugestaoRepository repository;

    public List<Sugestao> findAll(){
        return repository.findAll();
    }

    public Sugestao find(Long id){
        Optional<Sugestao> sugestao = repository.findById(id);
        return sugestao.orElseThrow(() -> new NoSuchElementException("ID não encontrado"));
    }

    public void create(Sugestao sugestao){
        sugestao.setData(LocalDate.now());
        repository.save(sugestao);
    }

    public void update(Long id, Sugestao sugestao){
        sugestao.setId(id);
        repository.save(sugestao);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

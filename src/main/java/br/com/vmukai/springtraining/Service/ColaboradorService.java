package br.com.vmukai.springtraining.Service;

import br.com.vmukai.springtraining.Domain.Colaborador;
import br.com.vmukai.springtraining.Repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public List<Colaborador> findAll(){
        return findAll();
    }

    public Colaborador findById(Long id) throws NoSuchElementException{
        Optional<Colaborador> co = repository.findById(id);
        return co.orElseThrow(() -> new NoSuchElementException("ID não encontrado"));
    }

    public Colaborador findByName(String nome){
        Optional<Colaborador> co = repository.findByNome(nome);
        return  co.orElseThrow(() -> new NoSuchElementException("Nome não encontrado"));
    }

    public void create(Colaborador colaborador){
        repository.save(colaborador);
    }

    public void update(Long id, Colaborador colaborador){
        colaborador.setId(id);
        repository.save(colaborador);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

package br.com.vmukai.springtraining.service;

import br.com.vmukai.springtraining.domain.Colaborador;
import br.com.vmukai.springtraining.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.FileHandler;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public List<Colaborador> findAll(){
        return repository.findAll();
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

    public void updateVariable(Long id, Colaborador colaborador){
        Optional<Colaborador> co = repository.findById(id);
        for(Field f : Colaborador.class.getDeclaredFields()){
            if(colaborador.getEmail() == null){
                co.get().setNome(colaborador.getNome());
                colaborador.setEmail(co.get().getEmail());
            }
        }
        repository.save(colaborador);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

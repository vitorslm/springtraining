package br.com.vmukai.springtraining.controller;

import br.com.vmukai.springtraining.domain.Sugestao;
import br.com.vmukai.springtraining.service.SugestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sugestao")
public class SugestaoController {

    @Autowired
    private SugestaoService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<Sugestao>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sugestao> find(@PathVariable Long id){
        return ResponseEntity.ok().body(service.find(id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Void> insert(@RequestBody Sugestao sugestao){
        service.create(sugestao);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Sugestao sugestao){
        sugestao.setId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

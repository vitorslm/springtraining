package br.com.vmukai.springtraining.controller;

import br.com.vmukai.springtraining.VO.ColaboradorVO;
import br.com.vmukai.springtraining.domain.Colaborador;
import br.com.vmukai.springtraining.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<ColaboradorVO>> findAll(){
        List<Colaborador> list = service.findAll();
        List<ColaboradorVO> listVo = list.stream().map(obj -> new ColaboradorVO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listVo);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Void> insert(@RequestBody Colaborador colaborador){
        service.create(colaborador);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Colaborador colaborador){
        service.update(id, colaborador);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> updateVarible(@PathVariable Long id,@RequestBody Colaborador colaborador){
        service.updateVariable(id, colaborador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

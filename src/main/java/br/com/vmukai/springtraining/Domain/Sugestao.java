package br.com.vmukai.springtraining.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "sugestao")
@Data
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudo_sugestao")
    private String conteudo;

    @Column(name = "data_sugestao")
    private Date data;

    @ManyToOne
    private Colaborador colaborador = new Colaborador();

}

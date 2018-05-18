package br.com.vmukai.springtraining.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @JsonIgnore
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Colaborador colaborador = new Colaborador();

}

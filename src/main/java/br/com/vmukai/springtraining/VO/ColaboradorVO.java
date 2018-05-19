package br.com.vmukai.springtraining.VO;

import br.com.vmukai.springtraining.domain.Colaborador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ColaboradorVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;

    public ColaboradorVO(Colaborador obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}

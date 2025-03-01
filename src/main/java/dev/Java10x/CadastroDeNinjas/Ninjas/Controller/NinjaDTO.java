package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missoes;


}



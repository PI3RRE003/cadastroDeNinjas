package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_Cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NinjaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome_ninja")
        private String nome;

        @Column(name = "imagem_url")
        private String imgUrl;

        @Column(unique = true)
        private String email;

        @Column(name = "idade")
        private int idade;

        @Column(name = "rank")
        private String rank;

        //UM NINJA TEM UMA UNICA MISSAO
        @ManyToOne
        @JoinColumn(name = "missoes_id")//CHAVE ESTRANGEIRA
        private MissoesModel missoes;

}

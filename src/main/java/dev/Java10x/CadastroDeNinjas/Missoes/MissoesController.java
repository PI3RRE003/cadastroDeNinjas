package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

//CONTROLLERS SÃO ROTAS EX: LOCALHOST8080/ ADICIONAR
@RestController
@RequestMapping("missoes")
public class MissoesController {

    //  GET MANDA UMA REQUISIÇÃO MOSTRAR MISSOES
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missões listadas com sucesso";
    }
    //POST MANDAR UMA REQUISIÇÃO PARA CRIAR MISSOES
    @PostMapping("/criar")
    public String criarMissão(){
        return "Missão Criada com sucesso";
    }
    //PUT MANDAR UMA REQUISIÇÃO PARA ALTERAR MISSOES
    @PutMapping("/alterar")
    public  String alterarMissao(){
        return "Missao Alterada com sucesso";
    }
    //DELETE MANDAR UMA REQUISIÇÃO PARA ALTERAR MISSOES
    @DeleteMapping("/deletar")
    public String deletarMissao(){
    return "Missão deletada com sucesso";
    }
}

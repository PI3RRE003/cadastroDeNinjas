package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//CONTROLLERS SÃO ROTAS EX: LOCALHOST8080/ ADICIONAR
@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // GET MANDA UMA REQUISIÇÃO LISTAR MISSOES
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //LISTA MISSOES POR ID
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarMissoesPorId(id);
    }

    //POST MANDAR UMA REQUISIÇÃO PARA CRIAR MISSOES
    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);
    }
    //PUT MANDAR UMA REQUISIÇÃO PARA ALTERAR MISSOES
    @PutMapping("/alterar")
    public  String alterarMissao(){
        return "Missao Alterada com sucesso";
    }

    //DELETE MANDAR UMA REQUISIÇÃO PARA EXCLUIR MISSOES POR ID
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoesPorId(@PathVariable Long id){
         missoesService.deletarMissoesPorId(id);
    }
}

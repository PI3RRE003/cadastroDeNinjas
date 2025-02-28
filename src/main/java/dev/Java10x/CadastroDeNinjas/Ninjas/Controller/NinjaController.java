package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem(ola mundo)";
    }

    //CRIAR NINJA(CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //LISTAR TODOS OS NINJAS(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //MOSTRAR NINJAS POR ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarsNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //ALTERAR DADOS NINJAS(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }
    //DELETAR NINJA(DELETE)
    @DeleteMapping("/deletar/{id}")
        public void deletarNinjasPorId(@PathVariable Long id){
            ninjaService.deletarNinjaPorId(id);
        }
    }



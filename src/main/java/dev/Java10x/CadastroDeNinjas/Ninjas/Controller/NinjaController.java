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

    //MOSTRAR TODOS OS NINJAS(READ)
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
    @PutMapping("/alterarID")
    public String alterarNinjasPorId(){
        return "Alterar Ninja por ID";
    }
    //DELETAR NINJA(DELETE)
    @DeleteMapping("/deletarID")
        public String deletarNinjasPorId(){
            return "Ninja Deletado por ID";
        }
    }



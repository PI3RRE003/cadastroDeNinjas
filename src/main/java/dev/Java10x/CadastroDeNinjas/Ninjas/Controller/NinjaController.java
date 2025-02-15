package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem(ola mundo)";
    }

    //ADICIONAR NINJA(CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //MOSTRAR TODOS OS NINJAS(READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }

    //MOSTRAR NINJAS POR ID (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
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



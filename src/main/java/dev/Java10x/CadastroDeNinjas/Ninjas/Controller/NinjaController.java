package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem(ola mundo)";
    }

    //CRIAR NINJA(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    //LISTAR TODOS OS NINJAS(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //MOSTRAR NINJAS POR ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarsNinjasPorId(@PathVariable Long id){
        NinjaDTO ninjaPorId = ninjaService.listarNinjasPorId(id);
        if (ninjaPorId != null){
            return  ResponseEntity.ok("Ninja encontrado: " + ninjaPorId.getNome() + " ID: " + id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " nao existe nos nossos registros");
        }
    }

    //ALTERAR DADOS NINJAS(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO alterarNinja = ninjaService.atualizarNinja(id, ninjaAtualizado);
            if (alterarNinja != null){
                ninjaService.atualizarNinja(id, ninjaAtualizado);
                return ResponseEntity.ok("Ninja com ID: " + id + " alterado com sucesso" + " Nome: " + alterarNinja.getNome() );
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O ninja com o id: " + id + " não encontrado");
            }


    }
    //DELETAR NINJA(DELETE)
    @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarNinjasPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID" + id + "deletado com sucesso");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O ninja com o id: " + id + " não encontrado");
         }
        }
    }


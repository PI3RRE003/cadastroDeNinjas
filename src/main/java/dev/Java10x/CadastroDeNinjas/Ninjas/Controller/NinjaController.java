package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Rota de boas vindas para quem acessa")
    public String boasVindas(){
        return "Essa e minha primeira mensagem(ola mundo)";
    }

    //CRIAR NINJA(CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no BD")

    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    } )

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

    @Operation(summary = "Lista um ninja por id", description = "Rota lista do ninja por id")

    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    } )

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

    @Operation(summary = "Altera um ninja por id", description = "Rota Altera o ninja por id")

    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    } )

    public ResponseEntity<String> alterarNinjasPorId(
            @Parameter(description = "usuario manda id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
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


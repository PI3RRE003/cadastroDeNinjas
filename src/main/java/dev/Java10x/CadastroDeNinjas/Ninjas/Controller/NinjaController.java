package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasv indas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem(ola mundo)";
    }

}

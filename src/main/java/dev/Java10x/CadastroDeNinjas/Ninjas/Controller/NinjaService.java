package dev.Java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaMapper ninjaMapper;
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaMapper ninjaMapper, NinjaRepository ninjaRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjaRepository = ninjaRepository;
    }

    //LISTANDO TODOS OS MEUS NINJAS
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //LISTANDO NINJAS POR ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //CRIANDO NINJAS
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }


    //DELETANDO NINJAS - TEM QUE SER VOID
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }

    //ATUALIZANDO NINJAS POR ID
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return  ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }



}

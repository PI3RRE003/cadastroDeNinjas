package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService{

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //LISTA TODAS MISSOES
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //LISTA MISSOES POR ID
    public MissoesModel listarMissoesPorId(Long id){
        Optional <MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);

    }

    //CRIANDO MISSOES
    public MissoesModel criarMissao(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    //DELETANDO MISSOES
    public void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }
}

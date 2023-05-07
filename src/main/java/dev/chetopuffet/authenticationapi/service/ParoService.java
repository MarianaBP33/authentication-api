package dev.chetopuffet.authenticationapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.chetopuffet.authenticationapi.model.Paro;
import dev.chetopuffet.authenticationapi.model.dto.ParoDto;
import dev.chetopuffet.authenticationapi.repository.ParoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParoService {

    private final ParoRepository paroRepository;

    public List<ParoDto> getAllParos(){
        var paros = paroRepository.findAllByActiveTrue();
        List<ParoDto> parosLista = new ArrayList<ParoDto>();
        for(Paro paro: paros){
            var paroDto = new ParoDto();
            paroDto.setActive(paro.isActive());
            paroDto.setDescription(paro.getDescription());
            paroDto.setOwnerName(paro.getOwnerName());
            paroDto.setPoints(paro.getPoints());
            parosLista.add(paroDto);
        }
        return parosLista;
    }

    public Paro createParo(String ownerName, String description, Integer points){
        var paroDto = new ParoDto();
        paroDto.setActive(true);
        paroDto.setDescription(description);
        paroDto.setPoints(points);
        paroDto.setOwnerName(ownerName);

        var paro= new Paro();
        paro.setActive(paroDto.getActive());
        paro.setDescription(paroDto.getDescription());
        paro.setOwnerName(paroDto.getOwnerName());
        paro.setPoints(paroDto.getPoints());
    
        return paroRepository.save(paro);
    }
}

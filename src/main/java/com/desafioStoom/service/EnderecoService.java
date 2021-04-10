package com.desafioStoom.service;

import com.desafioStoom.exception.ObjectNotFoundException;
import com.desafioStoom.integration.googleGeocoding.GoogleService;
import com.desafioStoom.integration.googleGeocoding.SaidaGeoCoding;
import com.desafioStoom.repository.EnderecoRepository;
import com.desafioStoom.repository.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class EnderecoService {


    @Autowired
    EnderecoRepository rep;

    @Autowired
    GoogleService googleService;

    public EnderecoEntity insert(EnderecoEntity enderecoEntity) {
        Assert.isNull(enderecoEntity.getId(), "Não foi possível inserir registro");
        insereLocation(enderecoEntity);
        return rep.save(enderecoEntity);
    }

    public EnderecoEntity readEnderecoById(Long id) throws ObjectNotFoundException {
        Optional<EnderecoEntity> optEnd = rep.findById(id);
        if (optEnd.isPresent())
            return optEnd.get();
        throw new ObjectNotFoundException("Endereco não encontrado.");
    }

    public EnderecoEntity update(Long id, EnderecoEntity enderecoEntity){
        Assert.notNull(id, "Não foi possível atualizar registro");

        Optional<EnderecoEntity> optional = rep.findById(id);

        if (optional.isPresent()) {
            insereLocation(enderecoEntity);
            EnderecoEntity db = optional.get();
            db.setStreetName(enderecoEntity.getStreetName());
            db.setNumber(enderecoEntity.getNumber());
            db.setComplement(enderecoEntity.getComplement());
            db.setNeighbourhood(enderecoEntity.getNeighbourhood());
            db.setCity(enderecoEntity.getCity());
            db.setState(enderecoEntity.getState());
            db.setCountry(enderecoEntity.getCountry());
            db.setZipcode(enderecoEntity.getZipcode());
            db.setLatitude(enderecoEntity.getLatitude());
            db.setLongitude(enderecoEntity.getLongitude());
            return rep.save(db);
        }
        throw new ObjectNotFoundException("Endereco não encontrado.");
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }

    public void insereLocation(EnderecoEntity enderecoEntity){
        if(enderecoEntity.getLatitude() == null || enderecoEntity.getLongitude() == null){
            SaidaGeoCoding.Location location = googleService.getLocation(enderecoEntity);
            enderecoEntity.setLatitude(location.getLat());
            enderecoEntity.setLongitude(location.getLng());
        }
    }

}

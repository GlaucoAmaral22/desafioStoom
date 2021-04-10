package com.desafioStoom.integration.googleGeocoding;


import com.desafioStoom.exception.GoogleResponseException;
import com.desafioStoom.repository.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    @Autowired
    GoogleClient googleClient;


    public SaidaGeoCoding.Location getLocation(EnderecoEntity endereco) {
        String key = "AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
        String address = formataEndereco(endereco);
        SaidaGeoCoding saidaGeoCoding = null;
        SaidaGeoCoding.Location location = null;
        try {
            saidaGeoCoding = googleClient.getGeoCoding(address, key).getBody();
            location = saidaGeoCoding.getResults().get(0).getGeometry().getLocation();
        } catch (Exception e) {
            throw new GoogleResponseException(e.getMessage());
        }
        return location;
    }

    public String formataEndereco(EnderecoEntity endereco) {
        String nomeRua = endereco.getStreetName().replace(" ", "+");
        String nomeBairro = endereco.getNeighbourhood().replace(" ", "+");
        String nomeCidade = endereco.getCity().replace(" ", "+");
        String nomeEstado = endereco.getState().replace(" ", "+");
        return nomeRua + "," + endereco.getNumber() + "," + nomeBairro + "," + nomeCidade + "," + nomeEstado;
    }


}



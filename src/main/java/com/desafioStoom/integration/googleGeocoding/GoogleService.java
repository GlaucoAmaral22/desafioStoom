package com.desafioStoom.integration.googleGeocoding;


import com.desafioStoom.exception.GoogleResponseException;
import com.desafioStoom.repository.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleService {

    @Autowired
    GoogleClient googleClient;

    @Value("${google.key}")
    private String googleKey;


    public SaidaGeoCoding.Location getLocation(EnderecoEntity endereco) {
        String address = formataEndereco(endereco);
        SaidaGeoCoding saidaGeoCoding = null;
        SaidaGeoCoding.Location location = null;
        try {
            saidaGeoCoding = googleClient.getGeoCoding(address, googleKey).getBody();
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
        String cep = endereco.getZipcode().replace("-", "+");
        return nomeRua + "," + endereco.getNumber() + "," + nomeBairro + "," + cep + "," + nomeCidade + "," + nomeEstado;
    }


}



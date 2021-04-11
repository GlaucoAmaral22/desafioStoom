package com.desafioStoom.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.desafioStoom.integration.googleGeocoding.GoogleService;
import com.desafioStoom.integration.googleGeocoding.SaidaGeoCoding;
import com.desafioStoom.repository.EnderecoRepository;
import com.desafioStoom.repository.entity.EnderecoEntity;
import com.desafioStoom.templates.EnderecoEntityTemplate;
import com.desafioStoom.templates.LocationTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.desafioStoom.service.EnderecoService.class)
public class EnderecoServiceTest {

    @Autowired
    EnderecoService enderecoService;

    @MockBean
    GoogleService googleService;

    @MockBean
    EnderecoRepository rep;


    @Before
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.desafioStoom.templates");
    }

    @Test
    public void createEnderecoTest() {
        EnderecoEntity enderecoEntity = Fixture.from(EnderecoEntity.class).gimme(EnderecoEntityTemplate.TEMPLATE_VALIDO_ENDERECO);
        EnderecoEntity enderecoEntitySaved = Fixture.from(EnderecoEntity.class).gimme(EnderecoEntityTemplate.TEMPLATE_VALIDO_ENDERECO_SAVED);
        SaidaGeoCoding.Location location = Fixture.from(SaidaGeoCoding.Location.class).gimme(LocationTemplate.TEMPLATE_VALIDO_LOCATION);

        when(googleService.getLocation(any(EnderecoEntity.class))).thenReturn(location);
        when(rep.save(any(EnderecoEntity.class))).thenReturn(enderecoEntitySaved);

        EnderecoEntity enderecoRetorno = enderecoService.insert(enderecoEntity);

        Assert.assertNotNull(enderecoRetorno.getId());
        Assert.assertEquals(enderecoRetorno.getLatitude(), enderecoEntitySaved.getLatitude());
        Assert.assertEquals(enderecoRetorno.getLongitude(), enderecoEntitySaved.getLongitude());
    }

    @Test
    public void ReadEnderecoTest() {

        EnderecoEntity enderecoEntitySaved = Fixture.from(EnderecoEntity.class).gimme(EnderecoEntityTemplate.TEMPLATE_VALIDO_ENDERECO_SAVED);
        Optional<EnderecoEntity> enderecoEntityOptional = Optional.of(enderecoEntitySaved);

        when(rep.findById(1l)).thenReturn(enderecoEntityOptional);

        EnderecoEntity enderecoRetorno = enderecoService.readEnderecoById(1l);

        Assert.assertNotNull(enderecoRetorno);
        Assert.assertNotNull(enderecoRetorno.getId());
    }

    @Test
    public void updateEnderecoTest() {
        EnderecoEntity enderecoEntityToUpdate = Fixture.from(EnderecoEntity.class).gimme(EnderecoEntityTemplate.TEMPLATE_VALIDO_ENDERECO_TO_UPDATE);
        EnderecoEntity enderecoEntityUpdated = Fixture.from(EnderecoEntity.class).gimme(EnderecoEntityTemplate.TEMPLATE_VALIDO_ENDERECO_UPDATED);
        SaidaGeoCoding.Location newLocation = Fixture.from(SaidaGeoCoding.Location.class).gimme(LocationTemplate.TEMPLATE_VALIDO_NEW_LOCATION);


        Optional<EnderecoEntity> enderecoEntityOptional = Optional.of(enderecoEntityUpdated);

        when(rep.findById(1l)).thenReturn(enderecoEntityOptional);
        when(rep.save(any(EnderecoEntity.class))).thenReturn(enderecoEntityUpdated);
        when(googleService.getLocation(any(EnderecoEntity.class))).thenReturn(newLocation);

        EnderecoEntity enderecoAtualizado = enderecoService.update(1l, enderecoEntityToUpdate);

        Assert.assertNotNull(enderecoAtualizado);
        Assert.assertEquals(enderecoAtualizado.getLatitude(), newLocation.getLat());
        Assert.assertEquals(enderecoAtualizado.getLongitude(), newLocation.getLng());
    }

    @Test
    public void deleteEnderecoTest() {

        doNothing().when(rep).deleteById(1l);
        enderecoService.delete(1l);

    }
}

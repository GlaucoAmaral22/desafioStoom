package com.desafioStoom.controller;


import com.desafioStoom.integration.googleGeocoding.GoogleService;
import com.desafioStoom.repository.entity.EnderecoEntity;
import com.desafioStoom.service.EnderecoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    GoogleService googleService;

    @PostMapping()
    public ResponseEntity createEndereco(@Valid @RequestBody EnderecoEntity endereco){

        EnderecoEntity enderecoSalvo = enderecoService.insert(endereco);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoSalvo.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{idEndereco}")
    public ResponseEntity readEndereco(@PathVariable Long idEndereco) throws ObjectNotFoundException {

        EnderecoEntity end = enderecoService.readEnderecoById(idEndereco);

        return ResponseEntity.ok(end);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity updateEndereco(@PathVariable("idEndereco") Long id, @RequestBody EnderecoEntity enderecoRequest){

        EnderecoEntity enderecoEntity = enderecoService.update(id, enderecoRequest);

        return ResponseEntity.ok(enderecoEntity);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity deleteEndereco(@PathVariable("idEndereco") Long id){
        enderecoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

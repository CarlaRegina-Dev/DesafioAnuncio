package com.carla.Anuncio.Controller;

import java.util.Date;
import java.util.List;

import com.carla.Anuncio.DTO.AnuncioDTO;
import com.carla.Anuncio.DTO.FiltroAnuncioDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.carla.Anuncio.Model.AnuncioModel;
import com.carla.Anuncio.Service.AnuncioService;

import javax.validation.Valid;

@RestController
@RequestMapping("/anuncio")
@Api(value = "Anuncio", description = "REST API para Anuncio", tags = { "Anuncio" })
public class AnuncioController {

    @Autowired
    private AnuncioService servico;

    @ApiOperation(value = "Listar todos os anuncios")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnuncioModel>> listaAnuncio() {
        return new ResponseEntity<List<AnuncioModel>>(servico.listaAnuncio(), HttpStatus.OK);
    }

    @ApiOperation(value = "Listar anuncio por filtro")
    @GetMapping(value = "/buscarPorFiltro", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAnuncio(@ModelAttribute FiltroAnuncioDTO filtroAnuncioDTO) {
        return new ResponseEntity<AnuncioDTO>(servico.getAnuncio(filtroAnuncioDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Cria um anuncio")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastrarAnuncio(@RequestBody(required = true) @Valid AnuncioModel anuncio) {
        return new ResponseEntity<AnuncioModel>(servico.cadastrarAnuncio(anuncio), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Atualizar o anuncio")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity atualizarAnuncio(@RequestBody(required = true) @Valid AnuncioModel anuncio) {
        return new ResponseEntity<AnuncioModel>(servico.atualizarAnuncio(anuncio), HttpStatus.OK);
    }

    @ApiOperation(value = "Deletar o anuncio")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> apagarAnuncio(@PathVariable Long id) {
        return new ResponseEntity<Boolean>(servico.apagarAnuncio(id), HttpStatus.OK);
    }
}

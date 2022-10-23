package com.mora.livraria.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mora.livraria.model.entity.Autor;
import com.mora.livraria.model.service.interfaces.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // CRUD...
    @PostMapping
    public ResponseEntity<Autor> salvar(@RequestBody Autor autor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.autorService.salvar(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> pesquisaAutor(@PathVariable Long id) {
        return ResponseEntity.ok(this.autorService.pesquisar(id));
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        return ResponseEntity.ok(this.autorService.listarAutores());
    }

    @PutMapping
    public ResponseEntity<Autor> atualizar(@RequestBody Autor autor) {
        return ResponseEntity.ok(this.autorService.atualizar(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarById(@PathVariable Long id) {
        this.autorService.deletar(id);

        return ResponseEntity.ok().build();
    }

    // Metodos...

}

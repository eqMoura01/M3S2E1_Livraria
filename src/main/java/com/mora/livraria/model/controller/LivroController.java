package com.mora.livraria.model.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

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

import com.mora.livraria.model.entity.Livro;
import com.mora.livraria.model.service.interfaces.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody @Valid Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.livroService.salvar(livro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.livroService.pesquisar(id));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(this.livroService.listarLivros());
    }

    @PutMapping
    public ResponseEntity<Livro> atualizar(@RequestBody Livro livro) {
        return ResponseEntity.ok(this.livroService.atualizar(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.livroService.deletar(id);

        return ResponseEntity.ok().build();
    }

}

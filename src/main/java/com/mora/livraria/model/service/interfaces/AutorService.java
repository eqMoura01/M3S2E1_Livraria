package com.mora.livraria.model.service.interfaces;

import java.util.List;

import com.mora.livraria.model.entity.Autor;

public interface AutorService {
    Autor salvar(Autor autor);

    Autor pesquisar(Long id);

    List<Autor> listarAutores();

    Autor atualizar(Autor autor);

    void deletar(Long id);
}

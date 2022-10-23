package com.mora.livraria.model.service.interfaces;

import java.util.List;

import com.mora.livraria.model.entity.Livro;

public interface LivroService {
    Livro salvar(Livro livro);

    Livro pesquisar(Long id);

    List<Livro> listarLivros();

    Livro atualizar(Livro livro);

    void deletar(Long id);
}

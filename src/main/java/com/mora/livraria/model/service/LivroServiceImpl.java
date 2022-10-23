package com.mora.livraria.model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.livraria.model.entity.Livro;
import com.mora.livraria.model.repository.LivroRepository;
import com.mora.livraria.model.service.interfaces.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Livro salvar(Livro livro) {
        return this.livroRepository.save(livro);
    }

    @Override
    public Livro pesquisar(Long id) {
        Optional<Livro> livroPesquisado = this.livroRepository.findById(id);

        if (livroPesquisado.isEmpty()) {
            throw new EntityNotFoundException("Livro não encontrado!!!");
        }

        return livroPesquisado.get();
    }

    @Override
    public List<Livro> listarLivros() {
        return this.livroRepository.findAll();
    }

    @Override
    public Livro atualizar(Livro livro) {

        Livro livroPesquisado = pesquisar(livro.getId());

        if (Objects.nonNull(livro)) {
            BeanUtils.copyProperties(livro, livroPesquisado, "id");
            this.livroRepository.save(livroPesquisado);
        }

        return null;
    }

    @Override
    public void deletar(Long id) {
        this.livroRepository.deleteById(id);

    }

}

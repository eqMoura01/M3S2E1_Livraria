package com.mora.livraria.model.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.livraria.model.entity.Autor;
import com.mora.livraria.model.repository.AutorRepository;
import com.mora.livraria.model.service.interfaces.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor salvar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    @Override
    public Autor pesquisar(Long id) {
        Optional<Autor> autorPesquisado = this.autorRepository.findById(id);

        if (autorPesquisado.isEmpty()) {
            throw new EntityNotFoundException("Nao foi possivel achar o AUTOR com esse ID!!!");
        }

        return autorPesquisado.get();
    }

    @Override
    public Autor atualizar(Autor autor) {
        Autor autorPesquisado = pesquisar(autor.getId());

        if (Objects.nonNull(autor)) {
            BeanUtils.copyProperties(autor, autorPesquisado, "id");
            this.autorRepository.save(autorPesquisado);
        }

        return null;
    }

    @Override
    public List<Autor> listarAutores() {
        return this.autorRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        this.autorRepository.deleteById(id);

    }

}

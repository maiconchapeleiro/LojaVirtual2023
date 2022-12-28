package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade){
        Cidade cidadeNova = cidadeRepository.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade alterar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public Void excluir(Long id){
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }
}

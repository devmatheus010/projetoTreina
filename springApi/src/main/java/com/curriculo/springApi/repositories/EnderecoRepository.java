package com.curriculo.springApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curriculo.springApi.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}


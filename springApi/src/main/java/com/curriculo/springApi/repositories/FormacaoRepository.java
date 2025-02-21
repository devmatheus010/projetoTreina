package com.curriculo.springApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curriculo.springApi.models.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {

		//Optional<Formacao>findByNome(String nome);
}

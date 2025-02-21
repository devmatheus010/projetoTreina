package com.curriculo.springApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curriculo.springApi.models.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {

}
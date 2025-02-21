package com.curriculo.springApi.dto;

import com.curriculo.springApi.models.Endereco;
import com.curriculo.springApi.models.Experiencia;
import com.curriculo.springApi.models.Formacao;
import com.curriculo.springApi.models.InfoAdicionais;

import java.util.Set;

public record CurriculoRecordDto(Long idCurriculo,
				String nome,
				String telefone,
				String email,
				String foto,
				Endereco endereco,
				InfoAdicionais infoAdicionais,
				Set<Formacao> formacaoes,
				Set<Experiencia> experienca
			) {

}
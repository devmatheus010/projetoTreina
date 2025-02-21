package com.curriculo.springApi.controller;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculo.springApi.models.Endereco;
import com.curriculo.springApi.models.Experiencia;
import com.curriculo.springApi.models.Formacao;
import com.curriculo.springApi.models.Curriculo;
import com.curriculo.springApi.models.InfoAdicionais;
import com.curriculo.springApi.repositories.CurriculoRepository;
import com.curriculo.springApi.repositories.EnderecoRepository;
import com.curriculo.springApi.repositories.ExperienciaRepository;
import com.curriculo.springApi.repositories.FormacaoRepository;


import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
@Getter
@Setter
public class CurriculoController {

	
	private final CurriculoRepository curriculoRepository;

	private final FormacaoRepository formacaoRepository;
	
	private final ExperienciaRepository experienciaRepository;
	
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public CurriculoController(CurriculoRepository curriculoRepository, FormacaoRepository formacaoRepository, ExperienciaRepository experienciaRepository, EnderecoRepository enderecoRepository) {
	this.curriculoRepository = curriculoRepository;
	this.formacaoRepository = formacaoRepository;
	this.experienciaRepository = experienciaRepository;
	this.enderecoRepository = enderecoRepository;
	}
	
	@GetMapping(value = "/buscarCurriculo")
	public List<Curriculo> buscarTudo() {
	return curriculoRepository.findAll();
	}
	
	@PostMapping(value = "/cadastrarCurriculo")
	public Curriculo cadastrarCurriculo(@RequestBody Curriculo curriculo) {
	InfoAdicionais info = curriculo.getInfoAdicionais();
	if (info != null) {
		info.setCurriculo(curriculo);
		}
	Curriculo resposta = curriculoRepository.save(curriculo);
	
	Set<Formacao> formacoes = curriculo.getFormacoes();
	if (formacoes != null) {
		for(Formacao formacao:formacoes) {
		formacao.setCurriculo(curriculo);
		formacaoRepository.save(formacao);
		}
	}
	Set<Experiencia> experiencias = curriculo.getExperiencias();
		if (experiencias != null) {
			for(Experiencia experiencia:experiencias) {
			experiencia.setCurriculo(curriculo);
			experienciaRepository.save(experiencia);
			}
		}
	return resposta;
	}
	
	@PutMapping(value = "/atualizarCurriculo/{id}")
	public Curriculo atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo identidadeNova) {
	Curriculo curriculo = curriculoRepository.findById(id)
	.orElseThrow(() -> new RuntimeException("Currículo não encontrado."));
	Endereco enderecoNovo = identidadeNova.getEndereco();
	Endereco endereco = curriculo.getEndereco();
	if (endereco != null) {
		endereco.setBairro(enderecoNovo.getBairro());
		endereco.setCep(enderecoNovo.getCep());
		endereco = enderecoRepository.save(endereco);
		curriculo.setEndereco(endereco);
	}
	if (identidadeNova.getInfoAdicionais() != null) {
		InfoAdicionais info = curriculo.getInfoAdicionais();
		info.setLinkedin(identidadeNova.getInfoAdicionais().getLinkedin());
		info.setRepositorio(identidadeNova.getInfoAdicionais().getRepositorio());
		curriculo.setInfoAdicionais(info);
		}
	return curriculo;
	
	}
}
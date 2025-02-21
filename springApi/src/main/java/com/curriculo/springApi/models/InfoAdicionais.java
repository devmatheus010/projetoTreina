package com.curriculo.springApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "info_adicionais")
public class InfoAdicionais {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfo;
	
	@Column(nullable = false, length = 512)
	private String linkedin;
	
	@Column(nullable = false, length = 512)
	private String repositorio;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_idCurriculo")
	private Curriculo curriculo;
	
	public Long getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(Long idInfo) {
		this.idInfo = idInfo;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	
}

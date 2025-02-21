package com.curriculo.springApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formacao")
public class Formacao {
	
	@Column(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormacao;
	
	@Column(nullable = false, length = 100)
	private String instituicao;
	
	@Column(nullable = false, length = 255)
	private String curso;
	
	@Column(nullable = false, columnDefinition = "YEAR")
    private int anoInicio;

    @Column(nullable = false, columnDefinition = "YEAR")
    private int anoTermino;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idCurriculo")
    private Curriculo curriculo;
	
	public Long getIdFormacao() {
		return idFormacao;
	}

	public void setIdFormacao(Long idFormacao) {
		this.idFormacao = idFormacao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}

	public int getAnoTermino() {
		return anoTermino;
	}

	public void setAnoTermino(int anoTermino) {
		this.anoTermino = anoTermino;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	
    
}

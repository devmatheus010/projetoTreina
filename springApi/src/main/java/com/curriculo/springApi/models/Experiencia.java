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
@Table(name = "experiencia")
public class Experiencia {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperienca;
	
	@Column(nullable = false, length = 100)
	private String cargo;
	
	@Column(nullable = false, length = 100)
	private String empresa;
	
	@Column(nullable = false, columnDefinition = "YEAR")
	private int anoInicio;
	
	@Column(nullable = false, columnDefinition = "YEAR")
	private int anoTermino;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_idCurriculo")
	private Curriculo curriculo;

	public Long getIdExperienca() {
		return idExperienca;
	}

	public void setIdExperienca(Long idExperienca) {
		this.idExperienca = idExperienca;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
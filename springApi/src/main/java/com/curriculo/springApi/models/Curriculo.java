package com.curriculo.springApi.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "curriculo")
public class Curriculo implements Serializable {
    private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurriculo;
	
	@Column(nullable = false, length = 180)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(15)")
	private String telefone;
	
	@Column(columnDefinition = "VARCHAR(255)")
	private String email;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String foto;
	
	public Long getIdCurriculo() {
		return idCurriculo;
	}

	public void setIdCurriculo(Long idCurriculo) {
		this.idCurriculo = idCurriculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(Set<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public Set<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(Set<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public InfoAdicionais getInfoAdicionais() {
		return infoAdicionais;
	}

	public void setInfoAdicionais(InfoAdicionais infoAdicionais) {
		this.infoAdicionais = infoAdicionais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idEndereco")
    private Endereco endereco;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private Set<Experiencia> experiencias = new HashSet<>();

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private Set<Formacao> formacoes = new HashSet<>();

    @OneToOne(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private InfoAdicionais infoAdicionais;
	
}
package com.perigea.demoSpringProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Long id;
	@Column @JsonProperty("nome")
	private String nome;

	@JsonManagedReference
	@OneToMany(mappedBy = "medico",  cascade = CascadeType.ALL) 
	private List<Paziente> pazienti;
	
	
	public List<Paziente> getPazienti() {
		return pazienti;
	}
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}
	

	public Medico(Long id, String nome, List<Paziente> pazienti) {
		this.id = id;
		this.nome = nome;
		this.pazienti = pazienti;
	}




	public void setPazienti(List<Paziente> pazienti) {
		this.pazienti = pazienti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + "]";
	}
	
}

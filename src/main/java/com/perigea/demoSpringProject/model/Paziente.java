package com.perigea.demoSpringProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Paziente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_paziente")
	private Long id;
	@Column
	private String nome;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="medico")
	private Medico medico;
	
	public Paziente() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Paziente(Long id, String nome, Medico medico) {
		this.id = id;
		this.nome = nome;
		this.medico = medico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
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
		return "Paziente [nome=" + nome + ", medico=" + medico + "]";
	}

	
}

package com.perigea.demoSpringProject.dto;

public class PazienteDTO {

	private Long id;
	private String nome;
	private MedicoDTO medico;
	
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
	
	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}
	
	public MedicoDTO getMedico() {
		return medico;
	}
	
	
	@Override
	public String toString() {
		return "PazienteDTO [id=" + id + ", nome=" + nome + "]";
	}
	
}

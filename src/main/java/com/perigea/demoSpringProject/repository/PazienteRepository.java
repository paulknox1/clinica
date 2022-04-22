package com.perigea.demoSpringProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.perigea.demoSpringProject.model.Paziente;

public interface PazienteRepository extends JpaRepository<Paziente, Long> {

	public List<Paziente> getByNome(String nome);
	public List<Paziente> findAll();
	public Paziente getByMedico(String nome);
	public Paziente save(Paziente paziente);
	public void deleteById(Long id);

	
	@Query(value = "SELECT * FROM paziente as p join medico as m on p.medico = m.id_medico WHERE m.nome=:nome", nativeQuery = true)
	public List<Paziente> getPazientiByNomeMedico(@Param("nome") String nome);

}

package com.perigea.demoSpringProject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.demoSpringProject.model.Medico;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
	public Medico getById(Long id);
	
	public List<Medico> getByNome(String nome);

	@Query(value = "SELECT * FROM MEDICO WHERE nome=:nome", nativeQuery = true)
	public List<Medico> getQueryCustom(@Param("nome") String nome);
	
	public List<Medico> findAll();
	
	public Medico save(Medico m);
	
	/*
	private static List<Medico> database = new ArrayList<>();
	
	@Override
	public List<Medico> getAllMedici() {
		return database;
	}

	@Override
	public void insertMedico(Medico medico) {
		database.add(medico);
		
	}
	*/

}

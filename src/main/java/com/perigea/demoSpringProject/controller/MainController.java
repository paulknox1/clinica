package com.perigea.demoSpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.demoSpringProject.dto.MedicoDTO;
import com.perigea.demoSpringProject.dto.PazienteDTO;
import com.perigea.demoSpringProject.model.Medico;
import com.perigea.demoSpringProject.model.Paziente;
import com.perigea.demoSpringProject.service.MainService;

@RestController
@RequestMapping("/ospedale")
public class MainController {
	@Autowired
	private MainService mainService;
	
	@GetMapping("/getMedicoByNome/{nome2}")
	public List<MedicoDTO> getByNome(@PathVariable("nome2") String nome) {
		List<MedicoDTO> list = mainService.getByNome(nome);
		return list;
	}

	@GetMapping("/	/{nome}")
	public List<MedicoDTO> getNomeQuery(@PathVariable("nome") String nome) {
		List<MedicoDTO> list = mainService.getQueryCustom(nome);
		return list;
	}
	
	@GetMapping("/getMedicoById/{id}")
	public MedicoDTO getMedicoById(@PathVariable("id") Long id) {	
		MedicoDTO medicoDTO = mainService.getMedicoById(id);
		return medicoDTO;
	}
	
	
	@GetMapping("/getAllMedici")
	public  List<MedicoDTO> getAllMedici() {
	    return mainService.getAllMedici();
	 }

	
	@PostMapping("/insertMedico")
	public MedicoDTO insertMedico(@RequestBody Medico nuovoMedico) {
	    return mainService.insertMedico(nuovoMedico);
	}
	
	/*
	@GetMapping(value = "/getMessages")
	public ResponseEntity<MedicoDTO> getMessages() {
	    
	    	MedicoDTO medico = mainService.getByNome(null);
	    	if (medico != null) {
	    		return ResponseEntity.status(200).body(medico);
	    	} else {
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    	}

	  }	*/
	
	
	@GetMapping("/getPazientiByNomeMedico/{nome2}")
	public List<PazienteDTO> getPazientiByNomeMedico(@PathVariable("nome2") String nome) {
		List<PazienteDTO> list = mainService.getPazientiByNomeMedico(nome);
		return list;
	}
	
	
	@GetMapping("/getPazienteByNome/{nome2}")
	public List<PazienteDTO> getPazienteByNome(@PathVariable("nome2") String nome) {
		List<PazienteDTO> list = mainService.getPazienteByNome(nome);
		return list;
	}
	
	@GetMapping("/getAllPazienti")
	public List<PazienteDTO> getAllPazienti() {
		List<PazienteDTO> list = mainService.getAllPazienti();
		return list;
	}
	
	
	@PostMapping("/aggiungiPaziente")
	public ResponseEntity<PazienteDTO> insertPaziente(@RequestBody Paziente nuovoPaziente) {
	    PazienteDTO p = mainService.insertPaziente(nuovoPaziente);
	    if (p != null) {
    		return new ResponseEntity<>(p, HttpStatus.CREATED);
    	} else {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
 
	}
	
	@DeleteMapping("/deletePazienteById/{id}")
	public void deletePazienteById(@PathVariable("id") Long id) {
		mainService.deletePazienteById(id);
	}
	
	
	@PutMapping("/updatePaziente")
	public PazienteDTO updatePaziente(@RequestBody Paziente paziente) {
		return mainService.updatePaziente(paziente);
	}
	
	
}

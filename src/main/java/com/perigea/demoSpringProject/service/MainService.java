package com.perigea.demoSpringProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.demoSpringProject.dto.MedicoDTO;
import com.perigea.demoSpringProject.dto.PazienteDTO;
import com.perigea.demoSpringProject.mapper.MedicoMapper;
import com.perigea.demoSpringProject.mapper.PazienteMapper;
import com.perigea.demoSpringProject.model.Medico;
import com.perigea.demoSpringProject.model.Paziente;
import com.perigea.demoSpringProject.repository.MedicoRepository;
import com.perigea.demoSpringProject.repository.PazienteRepository;

@Service
public class MainService {

	@Autowired
	private PazienteRepository pazienteRepository;
	@Autowired
	private PazienteMapper pazienteMapper;

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private MedicoMapper medicoMapper;

	@Autowired
	private Logger log;

	public List<MedicoDTO> getByNome(String nome) {	
		List<Medico> medici = medicoRepository.getByNome(nome);
		return medicoMapper.medicoListToMedicoDTOList(medici);

	}


	public MedicoDTO getMedicoById(Long id) {	
		Medico medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("doctor not found"));
		MedicoDTO medicoDTO = medicoMapper.map(medico);
		return medicoDTO;

	}


	public List<MedicoDTO> getQueryCustom(String nome) {
		List<Medico> medici = medicoRepository.getQueryCustom(nome);
		return medicoMapper.medicoListToMedicoDTOList(medici);

	}


	public List<MedicoDTO> getAllMedici() {
		List<Medico> lista = medicoRepository.findAll();
		return medicoMapper.medicoListToMedicoDTOList(lista);
	}


	public MedicoDTO insertMedico(Medico nuovoMedico) {
		Medico medico = medicoRepository.save(nuovoMedico);
		return medicoMapper.map(medico);
	}

	public List<PazienteDTO> getPazienteByNome(String nome) {
		List<Paziente> list = pazienteRepository.getByNome(nome);
		return pazienteMapper.pazienteListToPazienteDTOList(list);
	}



	public List<PazienteDTO> getPazientiByNomeMedico(String nome) {
		List<Paziente> pazienti = pazienteRepository.getPazientiByNomeMedico(nome);
		return pazienteMapper.pazienteListToPazienteDTOList(pazienti);
	}


	public PazienteDTO insertPaziente(Paziente nuovoPaziente) {
		Long doctorId = (Long) nuovoPaziente.getMedico().getId();
		log.info(String.valueOf(doctorId));
		Medico medico = medicoRepository.getById(doctorId);
		medico.getPazienti().add(nuovoPaziente);

		pazienteRepository.save(nuovoPaziente);
		return pazienteMapper.map(nuovoPaziente);

	}

	public void deletePazienteById(Long id) {
		pazienteRepository.deleteById(id);
	}



	public List<PazienteDTO> getAllPazienti() {
		List<Paziente> lista = pazienteRepository.findAll();
		return pazienteMapper.pazienteListToPazienteDTOList(lista);
	}


	public PazienteDTO updatePaziente(Paziente paziente) {
		Long id = (Long) paziente.getId();
		Paziente toUpdate = pazienteRepository.getById(id);
		toUpdate.setNome(paziente.getNome());
		toUpdate.setMedico(paziente.getMedico());
		pazienteRepository.save(toUpdate);
		return pazienteMapper.map(toUpdate);
	}


}

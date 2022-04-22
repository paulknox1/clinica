package com.perigea.demoSpringProject.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.perigea.demoSpringProject.dto.MedicoDTO;
import com.perigea.demoSpringProject.model.Medico;


@Mapper(componentModel = "spring")
public interface MedicoMapper {
	
	public MedicoDTO map(Medico medico);
	public List<MedicoDTO> medicoListToMedicoDTOList(List<Medico> list);
}

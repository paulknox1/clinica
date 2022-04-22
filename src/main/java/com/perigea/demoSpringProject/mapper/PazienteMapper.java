package com.perigea.demoSpringProject.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.perigea.demoSpringProject.dto.PazienteDTO;
import com.perigea.demoSpringProject.model.Paziente;


@Mapper(componentModel = "spring")
public interface PazienteMapper {
	public PazienteDTO map(Paziente paziente);
	public List<PazienteDTO> pazienteListToPazienteDTOList(List<Paziente> list);
}

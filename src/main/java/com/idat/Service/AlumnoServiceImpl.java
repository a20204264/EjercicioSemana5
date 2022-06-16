package com.idat.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Modelo.Alumno;
import com.idat.Repository.AlumnoRepository;
import com.idat.dto.AlumnoDTORequest;
import com.idat.dto.AlumnoDTOResponse;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository repository;
	

	@Override
	public void guardarAlumno(AlumnoDTORequest alumno) {
		Alumno a = new Alumno();
		
		a.setNombre(alumno.getNomalumno());
		a.setApellidos(alumno.getApealumnos());
		a.setDocumento(alumno.getDocalumno());
		a.setTelefono(alumno.getTelefalumno());
		a.setCorreo(alumno.getCorreoalumno());
		
		repository.save(a);
		
	}

	@Override
	public void actualizarAlumno(AlumnoDTORequest alumno) {
Alumno a = new Alumno();
		
		a.setNombre(alumno.getNomalumno());
		a.setApellidos(alumno.getApealumnos());
		a.setDocumento(alumno.getDocalumno());
		a.setTelefono(alumno.getTelefalumno());
		a.setCorreo(alumno.getCorreoalumno());
		
		repository.saveAndFlush(a);
		
	}

	@Override
	public void eliminarAlumno(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<AlumnoDTOResponse> listarAlumnos() {
		List<AlumnoDTOResponse> listar = new ArrayList<>();
		AlumnoDTOResponse dto = null;
		List<Alumno> a= repository.findAll();
		
		for(Alumno alumno: a) {
			dto = new AlumnoDTOResponse();
			
			dto.setNomalumno(alumno.getNombre());
			dto.setApealumnos(alumno.getApellidos());
			dto.setDocalumno(alumno.getDocumento());
			dto.setCorreoalumno(alumno.getCorreo());
			dto.setTelefalumno(alumno.getTelefono());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public AlumnoDTOResponse obtenerAlumnoiId(Integer id) {
		
		Alumno alumno = repository.findById(id).orElse(null);
		AlumnoDTOResponse dto = new AlumnoDTOResponse();
		
		dto = new AlumnoDTOResponse();
		
		dto.setId(alumno.getIdalumno());
		dto.setNomalumno(alumno.getNombre());
		dto.setApealumnos(alumno.getApellidos());
		dto.setDocalumno(alumno.getDocumento());
		dto.setCorreoalumno(alumno.getCorreo());
		dto.setTelefalumno(alumno.getTelefono());
		
		
		return dto;
	}
	
	

}

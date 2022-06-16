package com.idat.Service;

import java.util.List;

import com.idat.dto.AlumnoDTORequest;
import com.idat.dto.AlumnoDTOResponse;

public interface AlumnoService {
	
	void guardarAlumno(AlumnoDTORequest alumno);
	void actualizarAlumno(AlumnoDTORequest alumno);
	void eliminarAlumno(Integer id);
	List<AlumnoDTOResponse> listarAlumnos();
	AlumnoDTOResponse obtenerAlumnoiId(Integer id);

}

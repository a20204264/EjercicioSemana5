package com.idat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.Service.AlumnoService;
import com.idat.dto.AlumnoDTORequest;
import com.idat.dto.AlumnoDTOResponse;

@Controller
@RequestMapping("/alumno/v1")
public class AlumnoController {
	
	@Autowired
	private AlumnoService service;
	
	
	//LISTAR TODO:
	@RequestMapping("listar")
	public ResponseEntity<List<AlumnoDTOResponse>> listar(){
		
		return new ResponseEntity<List<AlumnoDTOResponse>>(service.listarAlumnos(),HttpStatus.OK);
		
	}
	
	
	//OBTENER POR ID:
	@GetMapping
	public @ResponseBody AlumnoDTOResponse ObtenerAlumnoId(@PathVariable Integer id) {
		return service.obtenerAlumnoiId(id);
	}
	
	//ELIMINAR ALUMNO:
	@RequestMapping(path="/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		AlumnoDTOResponse alumno = service.obtenerAlumnoiId(id);
		if(alumno != null) {
			service.eliminarAlumno(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	//GUARDAR ALUMNO:
	@RequestMapping(path="/guardar", method= RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody AlumnoDTORequest alumno){
		service.guardarAlumno(alumno);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	
	//ACTUALIZAR ALUMNO:
	public ResponseEntity<Void> actualizar(@RequestBody AlumnoDTORequest alumno){
		AlumnoDTOResponse alumnos = service.obtenerAlumnoiId(alumno.getId());
		
		if(alumnos !=null) {
			service.actualizarAlumno(alumno);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	
	//LISTAR POR ID:
	
	public ResponseEntity<AlumnoDTOResponse> obtenerId(@PathVariable Integer id){
		AlumnoDTOResponse alumnos = service.obtenerAlumnoiId(id);
		
		if(alumnos != null) {
			return new ResponseEntity<AlumnoDTOResponse>(service.obtenerAlumnoiId(id), HttpStatus.OK);
			
		}
		return new ResponseEntity<AlumnoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

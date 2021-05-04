package isst.eacta.app.web;


import isst.eacta.app.modelo.AlumnoNotaAsignatura;
import isst.eacta.app.repositorio.AlumnoNotaAsignaturaRepo;
import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.repositorio.AsignaturasRepo;
import isst.eacta.app.modelo.Usuario;
import isst.eacta.app.repositorio.UsuarioRepo;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/notas")
public class AlumnoNotaAsignaturaRest {
	
	@Autowired
	private AlumnoNotaAsignaturaRepo notasRepo;
	
	@Autowired 
	private UsuarioRepo usuarioRepo;
	
	@Autowired
	private AsignaturasRepo asigRepo;
	
	
	@GetMapping
	public ResponseEntity<List<AlumnoNotaAsignatura>> getAllNotas() {
        List<AlumnoNotaAsignatura> notas = notasRepo.findAll();
        return ResponseEntity.ok(notas);
    } 
	
	@GetMapping("/{id}")
    public ResponseEntity<AlumnoNotaAsignatura> getByNotaId(@PathVariable Long id) {
        return ResponseEntity.ok(notasRepo.findById(id).orElse(null));
    }
	
	@GetMapping("/alumnos/{usuario}")
	public ResponseEntity<List<AlumnoNotaAsignatura>> getAsignaturasbyAlumno(@PathVariable Long usuario) {
		Usuario user = usuarioRepo.findById(usuario).orElse(null);
		List<AlumnoNotaAsignatura> asignaturas = notasRepo.findAsignaturasbyAlumno(user);
		return ResponseEntity.ok(asignaturas);
    }
	
	@GetMapping("/asignaturas/{asignatura}")
	public ResponseEntity<List<AlumnoNotaAsignatura>> getAlumnosbyAsignatura(@PathVariable Long asignatura) {
		Asignaturas asig = asigRepo.findById(asignatura).orElse(null); 
		List<AlumnoNotaAsignatura> alumnos = notasRepo.findAlumnosbyAsignatura(asig);
		return ResponseEntity.ok(alumnos);
    }
	
	@GetMapping("/get/alumno/{idAlumno}/{idAsignatura}")
	public ResponseEntity<AlumnoNotaAsignatura> getnota(@PathVariable Long idAlumno, @PathVariable Long idAsignatura) {
		Asignaturas asig = asigRepo.findById(idAsignatura).orElse(null);
		Usuario user = usuarioRepo.findById(idAlumno).orElse(null);
		return ResponseEntity.ok(notasRepo.findNota(user, asig));
    }
	
	@PostMapping
    public void save(@RequestBody @Valid AlumnoNotaAsignatura nota) {
        notasRepo.save(nota);
    }
	
	/*@PutMapping("/put/alumno/{idAlumno}/{idAsignatura}")
	public ResponseEntity<AlumnoNotaAsignatura> updateNota(@PathVariable(value = "idAlumno") Long usuarioId, 
	  @PathVariable(value = "idAsignatura") Long asigId,
	  @Valid @RequestBody AlumnoNotaAsignatura newNota){
		Usuario user = usuarioRepo.findById(usuarioId).orElse(null);
		Asignaturas asig = asigRepo.findById(asigId).orElse(null); 
		AlumnoNotaAsignatura oldNota = notasRepo.findNota(user, asig);
	 oldNota.setNota(newNota.getNota());
	 //final AlumnoNotaAsignatura updatedNota = notasRepo.save(oldNota);
	 //return ResponseEntity.ok(updatedNota);
	}*/
	
	@PutMapping("/put/alumno/{idAlumno}/{idAsignatura}/{nota}")
	public ResponseEntity<AlumnoNotaAsignatura> updateNota(@PathVariable(value = "idAlumno") Long usuarioId, 
	  @PathVariable(value = "idAsignatura") Long asigId,
	  @PathVariable(value = "nota") Double nota){
		Usuario user = usuarioRepo.findById(usuarioId).orElse(null);
		Asignaturas asig = asigRepo.findById(asigId).orElse(null); 
		AlumnoNotaAsignatura oldNota = notasRepo.findNota(user, asig);	
	 oldNota.setNota(nota);
	 final AlumnoNotaAsignatura updatedNota = notasRepo.save(oldNota);
	 return ResponseEntity.ok(updatedNota);
	}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        notasRepo.deleteById(id);
    }

}

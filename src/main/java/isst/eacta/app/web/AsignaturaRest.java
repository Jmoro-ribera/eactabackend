package isst.eacta.app.web;

import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.repositorio.AsignaturasRepo;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaRest {
	
	@Autowired
	private AsignaturasRepo asigRepo;
	
	@GetMapping
	public ResponseEntity<List<Asignaturas>> getAllAsignaturas() {
        List<Asignaturas> asig = asigRepo.findAll();
        return ResponseEntity.ok(asig);
    }
 
	@GetMapping("/{id}")
    public ResponseEntity<Asignaturas> getByAsignaturaId(@PathVariable Long id) {
        return ResponseEntity.ok(asigRepo.findById(id).orElse(null));
    }
	
	@PostMapping
    public void save(@RequestBody @Valid Asignaturas asignaturas) {
        asigRepo.save(asignaturas);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Asignaturas> updateAsignatura(@PathVariable(value = "id") Long asigId,
	  @Valid @RequestBody Asignaturas newasig) throws ResourceNotFoundException {
		Asignaturas oldasig = asigRepo.findById(asigId)
	 .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + asigId));
	 oldasig.setNombreAsignaturas(newasig.getNombreAsignaturas());
	 final Asignaturas updatedAsig = asigRepo.save(oldasig);
	 return ResponseEntity.ok(updatedAsig);
	}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
    	asigRepo.deleteById(id);
    }

}

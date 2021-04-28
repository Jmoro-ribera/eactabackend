package isst.eacta.app.web;

import isst.eacta.app.modelo.Funcionalidad;
import isst.eacta.app.repositorio.FuncionalidadRepo;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/funcionalidad")
public class FuncionalidadRest {
	
	@Autowired
	private FuncionalidadRepo funcRepo;
	
	@GetMapping
	public ResponseEntity<List<Funcionalidad>> getAllFuncionalidades() {
        List<Funcionalidad> funciones = funcRepo.findAll();
        return ResponseEntity.ok(funciones);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Funcionalidad> getByFuncionalidadId(@PathVariable Long id) {
        return ResponseEntity.ok(funcRepo.findById(id).orElse(null));
    }
	
	@PostMapping
    public void save(@RequestBody @Valid Funcionalidad func) {
        funcRepo.save(func);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionalidad> updateFunc(@PathVariable(value = "id") Long funcId,
	  @Valid @RequestBody Funcionalidad newFunc) throws ResourceNotFoundException {
	 Funcionalidad oldFunc = funcRepo.findById(funcId)
	 .orElseThrow(() -> new ResourceNotFoundException("Functionality not found for this id :: " + funcId));
	 oldFunc.setNombreFuncionalidad(newFunc.getNombreFuncionalidad());
	 final Funcionalidad updatedFunc = funcRepo.save(oldFunc);
	 return ResponseEntity.ok(updatedFunc);
	}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        funcRepo.deleteById(id);
    }

}

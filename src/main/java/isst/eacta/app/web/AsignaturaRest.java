package isst.eacta.app.web;

import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.repositorio.AsignaturasRepo;
import isst.eacta.app.servicio.ImageService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaRest {
	
	@Autowired
	private AsignaturasRepo asigRepo;
	
	@Autowired
	private ImageService imageService;
	
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
	
	@PutMapping("/{id}") // Actualiza la firma
	public ResponseEntity<Asignaturas> updateAsignatura(@PathVariable(value = "id") Long asigId,
	  @Valid @RequestBody List<Integer> newasig) throws ResourceNotFoundException {
		Asignaturas oldasig = asigRepo.findById(asigId)
	 .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + asigId));
	 int size = newasig.size();
	 switch(size){
	    case 1 :
	    	oldasig.setFirmado1(newasig.get(0));
	        break;
	    
	    case 2 :
	    	oldasig.setFirmado1(newasig.get(0));
	    	oldasig.setFirmado2(newasig.get(1));
	       break;
	    
	    case 3 :
	    	oldasig.setFirmado1(newasig.get(0));
	    	oldasig.setFirmado2(newasig.get(1));
	    	oldasig.setFirmado3(newasig.get(2));	    	
	       break;   
	
	    default :
	    	oldasig.setFirmado1(null);
	    	oldasig.setFirmado2(null);
	    	oldasig.setFirmado3(null);	      
	 }
	 final Asignaturas updatedAsig = asigRepo.save(oldasig);
	 return ResponseEntity.ok(updatedAsig);
	}
	
	@PostMapping("/{id}/image")
	public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
		String type = "asignatura";
	    imageService.saveImageFile(type, Long.valueOf(id), file);

	    return "redirect:/recipe/" + id + "/show";
	}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
    	asigRepo.deleteById(id);
    }

}

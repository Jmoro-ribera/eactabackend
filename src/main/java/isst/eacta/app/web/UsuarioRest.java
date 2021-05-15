package isst.eacta.app.web;

import isst.eacta.app.modelo.Usuario;

import isst.eacta.app.repositorio.UsuarioRepo;
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
@RequestMapping("/api/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioRepo usuarioRepo;
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        return ResponseEntity.ok(usuarios);
    }
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Usuario> getByUsuarioEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioRepo.findUserByMail(email));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> getByUsuarioId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioRepo.findById(id).orElse(null));
    }
	
	@PostMapping
    public void save(@RequestBody @Valid Usuario usuario) {
        usuarioRepo.save(usuario);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long userId,
	  @Valid @RequestBody Usuario newUser) throws ResourceNotFoundException {
	 Usuario oldUser = usuarioRepo.findById(userId)
	 .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	 oldUser.setNombre(newUser.getNombre());
	 oldUser.setApellidos(newUser.getApellidos());
	 oldUser.setEmail(newUser.getEmail());
	 oldUser.setIdRol(newUser.getIdRol());
	 final Usuario updatedUser = usuarioRepo.save(oldUser);
	 return ResponseEntity.ok(updatedUser);
	}
	
	@PostMapping("/{id}/image")
	public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){
		
		String type = "tribunal";
	    imageService.saveImageFile(type, Long.valueOf(id), file);

	    return "redirect:/recipe/" + id + "/show";
	}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuarioRepo.deleteById(id);
    }
	

}

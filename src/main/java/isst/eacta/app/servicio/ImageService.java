package isst.eacta.app.servicio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.modelo.Usuario;
import isst.eacta.app.repositorio.AsignaturasRepo;
import isst.eacta.app.repositorio.UsuarioRepo;

@Service
public class ImageService {
	
	@Autowired
	private UsuarioRepo userRepo;
	
	@Autowired
	private AsignaturasRepo asigRepo;
	
	@Transactional
	public void saveImageFile(String type, Long id, MultipartFile file) {
		if(type == "asignatura") {
			try {
			    Asignaturas asig = asigRepo.findById(id).get();
		
			    Byte[] byteObjects = new Byte[file.getBytes().length];
		
			    int i = 0;
		
			    for (byte b : file.getBytes()){
			        byteObjects[i++] = b;
			    }
		
			    asig.setAsigImage(byteObjects);
		
			    asigRepo.save(asig);
			}catch (IOException e) {
			    //todo handle better
			    System.out.println("Error occurred: "+ e);
		
			    e.printStackTrace();
			}
		}
		else if(type == "tribunal") {
			try {
			    Usuario user = userRepo.findById(id).get();
		
			    Byte[] byteObjects = new Byte[file.getBytes().length];
		
			    int i = 0;
		
			    for (byte b : file.getBytes()){
			        byteObjects[i++] = b;
			    }
		
			    user.setUserImage(byteObjects);
		
			    userRepo.save(user);
			}catch (IOException e) {
			    //todo handle better
			    System.out.println("Error occurred: "+ e);
		
			    e.printStackTrace();
			}
		}
	}
}

package isst.eacta.app;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import isst.eacta.app.modelo.AlumnoNotaAsignatura;
import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.modelo.Funcionalidad;
import isst.eacta.app.modelo.Rol;
import isst.eacta.app.modelo.Usuario;
import isst.eacta.app.repositorio.AlumnoNotaAsignaturaRepo;
import isst.eacta.app.repositorio.AsignaturasRepo;
import isst.eacta.app.repositorio.FuncionalidadRepo;
import isst.eacta.app.repositorio.RolRepo;
import isst.eacta.app.repositorio.UsuarioRepo;
import isst.eacta.app.servicio.ImageService;

@SpringBootApplication
public class EactaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EactaApplication.class, args);
	}

}

@Component
@Transactional
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private RolRepo rolRepo;
	
	@Autowired
	private AsignaturasRepo asigRepo;
	
	@Autowired
	private UsuarioRepo userRepo;
	
	@Autowired
	private FuncionalidadRepo funcRepo;
	
	@Autowired
	private AlumnoNotaAsignaturaRepo notasRepo;

	@Override
	public void run(String... args) throws Exception {
		
		// Funcionalidades
		
		//List<String> funcs = new ArrayList<String>();
		//funcs.add("Ver Actas");
		//funcs.add("Subir Notas");
		//funcs.add("Firmar Actas");
		//funcs.add("Generar Expediente");
		
		Funcionalidad func1 = new Funcionalidad();
		func1.setNombreFuncionalidad("Ver Actas");
		funcRepo.save(func1);
		
		Funcionalidad func2 = new Funcionalidad();
		func2.setNombreFuncionalidad("Subir Notas");
		funcRepo.save(func2);
		
		Funcionalidad func3 = new Funcionalidad();
		func3.setNombreFuncionalidad("Firmar Actas");
		funcRepo.save(func3);
		
		Funcionalidad func4 = new Funcionalidad();
		func4.setNombreFuncionalidad("Generar Expediente");
		funcRepo.save(func4);
		
		// Roles
		
		Rol rol1 = new Rol();
		rol1.setNombreRol("Alumno");
		rolRepo.save(rol1);
		
		Rol rol2 = new Rol();
		rol2.setNombreRol("Tribunal");
		rol2.addfunc(func2);
		rol2.addfunc(func1);
		rol2.addfunc(func3);
		rolRepo.save(rol2);
		
		Rol rol3 = new Rol();
		rol3.setNombreRol("Secretaría");
		rol3.addfunc(func4);
		rol3.addfunc(func1);
		rolRepo.save(rol3);
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("emf");
		//EntityManager em = emf.createEntityManager();
		//em.getTransaction().begin();
		//em.persist(rol1);
		//em.persist(rol2);
		//em.persist(rol3);
		//em.getTransaction().commit();
		
		// Asignaturas
		
		Asignaturas asig1 = new Asignaturas();
		asig1.setNombreAsignaturas("Ingeniería de Servicios y Sistemas Telemáticos");
		asig1.setSiglas("ISST");
		asig1.setFirmado1(null);
		asig1.setFirmado2(null);
		asig1.setFirmado3(null);
		asig1.setAsigImage(null);
		asigRepo.save(asig1);
		
		Asignaturas asig2 = new Asignaturas();
		asig2.setNombreAsignaturas("Redes de Comunicaciones Móviles");
		asig2.setSiglas("RCMO");
		asig2.setFirmado1(null);
		asig2.setFirmado2(null);
		asig2.setFirmado3(null);
		asig2.setAsigImage(null);
		asigRepo.save(asig2);
		
		Asignaturas asig3 = new Asignaturas();
		asig3.setNombreAsignaturas("Redes y Servicios de Radio");
		asig3.setSiglas("RSRD");
		asig3.setFirmado1(null);
		asig3.setFirmado2(null);
		asig3.setFirmado3(null);
		asig3.setAsigImage(null);
		asigRepo.save(asig3);
		
		// Usuarios
		
		Usuario user1 = new Usuario();
		user1.setNombre("Javier");
		user1.setApellidos("Moro Ribera");
		user1.setPassword("JavierM98");
		user1.setEmail("javier.morori@alumnos.upm.es");
		user1.setIdRol(rol1);
		user1.setUserImage(null);
		userRepo.save(user1);
		
		Usuario user2 = new Usuario();
		user2.setNombre("Christian");
		user2.setApellidos("Santiago Moreno");
		user2.setPassword("ChristianS97");
		user2.setEmail("christian.santiago.moreno@alumnos.upm.es");
		user2.setIdRol(rol2);
		user2.addAsignaturas(asig1);
		user2.addAsignaturas(asig2);
		user2.setUserImage(null);
		//ClassPathResource cPR1 = new ClassPathResource("attachment.pdf");
		//byte[] user2img = Files.readAllBytes(cPR1.getFile().toPath());
		//user2.setUserImage(user2img);
		userRepo.save(user2);
		
		Usuario user3 = new Usuario();
		user3.setNombre("Elvira");
		user3.setApellidos("Sanchez Moreno");
		user3.setPassword("ElviraS98");
		user3.setEmail("elvira.sanchez.moreno@alumnos.upm.es");
		user3.setIdRol(rol2);
		user3.addAsignaturas(asig1);
		user3.addAsignaturas(asig3);
		user3.setUserImage(null);
		userRepo.save(user3);
		
		Usuario user4 = new Usuario();
		user4.setNombre("Pablo");
		user4.setApellidos("Chico");
		user4.setPassword("PabloC98");
		user4.setEmail("pablo.chico@alumnos.upm.es");
		user4.setIdRol(rol1);
		user4.setUserImage(null);
		userRepo.save(user4);
		
		//EntityManager em2 = emf.createEntityManager();
		//em2.getTransaction().begin();
		//em2.persist(user1);
		//em2.persist(user2);
		//em2.persist(user3);
		//em2.persist(user4);
		//em2.getTransaction().commit();
		
		// Alumno Has Nota Asignatura
		
		AlumnoNotaAsignatura nota1 = new AlumnoNotaAsignatura();
		nota1.setUsuario(user1);
		nota1.setAsignatura(asig1);
		nota1.setNota(null);
		notasRepo.save(nota1);
		
		AlumnoNotaAsignatura nota2 = new AlumnoNotaAsignatura();
		nota2.setUsuario(user1);
		nota2.setAsignatura(asig2);
		nota2.setNota(null);
		notasRepo.save(nota2);
		
		AlumnoNotaAsignatura nota3 = new AlumnoNotaAsignatura();
		nota3.setUsuario(user4);
		nota3.setAsignatura(asig2);
		nota3.setNota(null);
		notasRepo.save(nota3);
		
		AlumnoNotaAsignatura nota4 = new AlumnoNotaAsignatura();
		nota4.setUsuario(user4);
		nota4.setAsignatura(asig3);
		nota4.setNota(null);
		notasRepo.save(nota3);
		
	}
}




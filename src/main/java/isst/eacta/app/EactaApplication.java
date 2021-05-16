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

/*
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
		
		Asignaturas asig4 = new Asignaturas();
		asig4.setNombreAsignaturas("Ingeniería Web");
		asig4.setSiglas("IWEB");
		asig4.setFirmado1(null);
		asig4.setFirmado2(null);
		asig4.setFirmado3(null);
		asig4.setAsigImage(null);
		asigRepo.save(asig4);
		
		Asignaturas asig5 = new Asignaturas();
		asig5.setNombreAsignaturas("Seguridad en sistemas y redes de telecomunicación");
		asig5.setSiglas("SEGU");
		asig5.setFirmado1(null);
		asig5.setFirmado2(null);
		asig5.setFirmado3(null);
		asig5.setAsigImage(null);
		asigRepo.save(asig5);
		
		Asignaturas asig6 = new Asignaturas();
		asig6.setNombreAsignaturas("Dimensionado y operación de redes");
		asig6.setSiglas("DORE");
		asig6.setFirmado1(null);
		asig6.setFirmado2(null);
		asig6.setFirmado3(null);
		asig6.setAsigImage(null);
		asigRepo.save(asig6);
		
		Asignaturas asig7 = new Asignaturas();
		asig7.setNombreAsignaturas("Redes corporativas");
		asig7.setSiglas("RECO");
		asig7.setFirmado1(null);
		asig7.setFirmado2(null);
		asig7.setFirmado3(null);
		asig7.setAsigImage(null);
		asigRepo.save(asig7);
		
		Asignaturas asig8 = new Asignaturas();
		asig8.setNombreAsignaturas("Centro de Datos y provisión de Servicios");
		asig8.setSiglas("CDPS");
		asig8.setFirmado1(null);
		asig8.setFirmado2(null);
		asig8.setFirmado3(null);
		asig8.setAsigImage(null);
		asigRepo.save(asig8);
		
		// Usuarios
		
		Usuario user1 = new Usuario();
		user1.setNombre("Javier");
		user1.setApellidos("Moro Ribera");
		user1.setPassword("JavierM98");
		user1.setEmail("javier.morori@alumnos.upm.es");
		user1.setIdRol(rol2);
		user1.addAsignaturas(asig8);
		user1.addAsignaturas(asig6);
		user1.addAsignaturas(asig3);
		user1.addAsignaturas(asig5);
		user1.addAsignaturas(asig4);
		user1.addAsignaturas(asig2);
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
		user2.addAsignaturas(asig8);
		user2.addAsignaturas(asig7);
		user2.addAsignaturas(asig5);
		user2.addAsignaturas(asig3);
		user2.setUserImage(null);
		//ClassPathResource cPR1 = new ClassPathResource("attachment.pdf");
		//byte[] user2img = Files.readAllBytes(cPR1.getFile().toPath());
		//user2.setUserImage(user2img);
		userRepo.save(user2);
		
		Usuario user3 = new Usuario();
		user3.setNombre("Elvira");
		user3.setApellidos("Moreno Sanchez");
		user3.setPassword("ElviraS99");
		user3.setEmail("e.msanchez@alumnos.upm.es");
		user3.setIdRol(rol2);
		user3.addAsignaturas(asig1);
		user3.addAsignaturas(asig3);
		user3.addAsignaturas(asig6);
		user3.addAsignaturas(asig4);
		user3.addAsignaturas(asig5);
		user3.addAsignaturas(asig7);
		user3.setUserImage(null);
		userRepo.save(user3);
		
		Usuario user4 = new Usuario();
		user4.setNombre("Andrés");
		user4.setApellidos("Zambrana Valle");
		user4.setPassword("AndresZ99");
		user4.setEmail("a.zambrana@alumnos.upm.es");
		user4.setIdRol(rol2);
		user4.addAsignaturas(asig4);
		user4.addAsignaturas(asig2);
		user4.addAsignaturas(asig7);
		user4.addAsignaturas(asig8);
		user4.addAsignaturas(asig1);
		user4.addAsignaturas(asig6);
		user4.setUserImage(null);
		userRepo.save(user4);
		
		//secretario
		Usuario user5 = new Usuario();
		user5.setNombre("Alejandro");
		user5.setApellidos("Chico Moreno");
		user5.setPassword("AlejandroC99");
		user5.setEmail("alejandro.chico.moreno@alumnos.upm.es");
		user5.setIdRol(rol3);
		user5.setUserImage(null);
		userRepo.save(user5);
		
		//alumno prueba
		Usuario user6 = new Usuario();
		user6.setNombre("Pablo");
		user6.setApellidos("Ruiz Ruiz");
		user6.setPassword(null);
		user6.setEmail("p.rruiz@alumnos.upm.es");
		user6.setIdRol(rol1);
		user6.addAsignaturas(asig1);
		user6.addAsignaturas(asig2);
		user6.addAsignaturas(asig3);
		user6.addAsignaturas(asig4);
		user6.addAsignaturas(asig5);
		user6.addAsignaturas(asig6);
		user6.addAsignaturas(asig7);
		user6.addAsignaturas(asig8);
		user6.setUserImage(null);
		userRepo.save(user6);
		
		//alumnos
		Usuario user7 = new Usuario();
		user7.setNombre("Noelia");
		user7.setApellidos("Paredes Ruiz");
		user7.setPassword(null);
		user7.setEmail("noelia@alumnos.upm.es");
		user7.setIdRol(rol1);
		user7.addAsignaturas(asig1);
		user7.addAsignaturas(asig2);
		user7.addAsignaturas(asig3);
		user7.addAsignaturas(asig4);
		user7.setUserImage(null);
		userRepo.save(user7);
		
		Usuario user8 = new Usuario();
		user8.setNombre("Clara");
		user8.setApellidos("Rodriguez Moreno");
		user8.setPassword(null);
		user8.setEmail("clara@alumnos.upm.es");
		user8.setIdRol(rol1);
		user8.addAsignaturas(asig4);
		user8.addAsignaturas(asig5);
		user8.addAsignaturas(asig7);
		user8.setUserImage(null);
		userRepo.save(user8);
		
		Usuario user9 = new Usuario();
		user9.setNombre("Juan");
		user9.setApellidos("Rodriguez Moreno");
		user9.setPassword(null);
		user9.setEmail("juan@alumnos.upm.es");
		user9.setIdRol(rol1);
		user9.addAsignaturas(asig1);
		user9.addAsignaturas(asig2);
		user9.addAsignaturas(asig7);
		user9.addAsignaturas(asig8);
		user9.setUserImage(null);
		userRepo.save(user9);
		
		Usuario user10 = new Usuario();
		user10.setNombre("Alejandra");
		user10.setApellidos("Ortega Ruiz");
		user10.setPassword(null);
		user10.setEmail("alejandra@alumnos.upm.es");
		user10.setIdRol(rol1);
		user10.addAsignaturas(asig1);
		user10.addAsignaturas(asig2);
		user10.setUserImage(null);
		userRepo.save(user10);
		
		Usuario user11 = new Usuario();
		user11.setNombre("Miguel");
		user11.setApellidos("Ríos García");
		user11.setPassword(null);
		user11.setEmail("miguel@alumnos.upm.es");
		user11.setIdRol(rol1);
		user11.addAsignaturas(asig1);
		user11.addAsignaturas(asig2);
		user11.addAsignaturas(asig3);
		user11.addAsignaturas(asig6);
		user11.setUserImage(null);
		userRepo.save(user11);
		
		Usuario user12 = new Usuario();
		user12.setNombre("Darío");
		user12.setApellidos("Robles García");
		user12.setPassword(null);
		user12.setEmail("dario@alumnos.upm.es");
		user12.setIdRol(rol1);
		user12.addAsignaturas(asig1);
		user12.addAsignaturas(asig2);
		user12.addAsignaturas(asig8);
		user12.setUserImage(null);
		userRepo.save(user12);
		
		Usuario user13 = new Usuario();
		user13.setNombre("Estefanía");
		user13.setApellidos("Rubio Pascal");
		user13.setPassword(null);
		user13.setEmail("estefania@alumnos.upm.es");
		user13.setIdRol(rol1);
		user13.addAsignaturas(asig4);
		user13.addAsignaturas(asig5);
		user13.addAsignaturas(asig7);
		user13.addAsignaturas(asig8);
		user13.setUserImage(null);
		userRepo.save(user13);
		
		Usuario user14 = new Usuario();
		user14.setNombre("Leandro");
		user14.setApellidos("Sánchez Ruiz");
		user14.setPassword(null);
		user14.setEmail("leandro@alumnos.upm.es");
		user14.setIdRol(rol1);
		user14.addAsignaturas(asig4);
		user14.addAsignaturas(asig5);
		user14.addAsignaturas(asig7);
		user14.setUserImage(null);
		userRepo.save(user14);

		Usuario user15 = new Usuario();
		user15.setNombre("Rubén");
		user15.setApellidos("Moro Zambrana");
		user15.setPassword(null);
		user15.setEmail("ruben@alumnos.upm.es");
		user15.setIdRol(rol1);
		user15.addAsignaturas(asig1);
		user15.addAsignaturas(asig3);
		user15.addAsignaturas(asig8);
		user15.setUserImage(null);
		userRepo.save(user15);
		
				
		//EntityManager em2 = emf.createEntityManager();
		//em2.getTransaction().begin();
		//em2.persist(user1);
		//em2.persist(user2);
		//em2.persist(user3);
		//em2.persist(user4);
		//em2.getTransaction().commit();
		
		// Alumno Has Nota Asignatura
		
		AlumnoNotaAsignatura nota1 = new AlumnoNotaAsignatura();
		nota1.setUsuario(user6);
		nota1.setAsignatura(asig1);
		nota1.setNota(null);
		notasRepo.save(nota1);
		
		AlumnoNotaAsignatura nota2 = new AlumnoNotaAsignatura();
		nota2.setUsuario(user6);
		nota2.setAsignatura(asig2);
		nota2.setNota(null);
		notasRepo.save(nota2);
		
		AlumnoNotaAsignatura nota3 = new AlumnoNotaAsignatura();
		nota3.setUsuario(user6);
		nota3.setAsignatura(asig3);
		nota3.setNota(null);
		notasRepo.save(nota3);
		
		AlumnoNotaAsignatura nota4 = new AlumnoNotaAsignatura();
		nota4.setUsuario(user6);
		nota4.setAsignatura(asig4);
		nota4.setNota(null);
		notasRepo.save(nota4);
		
		AlumnoNotaAsignatura nota5 = new AlumnoNotaAsignatura();
		nota5.setUsuario(user6);
		nota5.setAsignatura(asig5);
		nota5.setNota(null);
		notasRepo.save(nota5);
		
		AlumnoNotaAsignatura nota6 = new AlumnoNotaAsignatura();
		nota6.setUsuario(user6);
		nota6.setAsignatura(asig6);
		nota6.setNota(null);
		notasRepo.save(nota6);
		
		AlumnoNotaAsignatura nota7 = new AlumnoNotaAsignatura();
		nota7.setUsuario(user6);
		nota7.setAsignatura(asig7);
		nota7.setNota(null);
		notasRepo.save(nota7);
		
		AlumnoNotaAsignatura nota8 = new AlumnoNotaAsignatura();
		nota8.setUsuario(user6);
		nota8.setAsignatura(asig8);
		nota8.setNota(null);
		notasRepo.save(nota8);
		
		AlumnoNotaAsignatura nota9 = new AlumnoNotaAsignatura();
		nota9.setUsuario(user7);
		nota9.setAsignatura(asig1);
		nota9.setNota(null);
		notasRepo.save(nota9);
		
		AlumnoNotaAsignatura nota10 = new AlumnoNotaAsignatura();
		nota10.setUsuario(user7);
		nota10.setAsignatura(asig2);
		nota10.setNota(null);
		notasRepo.save(nota10);
		
		AlumnoNotaAsignatura nota11 = new AlumnoNotaAsignatura();
		nota11.setUsuario(user7);
		nota11.setAsignatura(asig3);
		nota11.setNota(null);
		notasRepo.save(nota11);
		
		AlumnoNotaAsignatura nota12 = new AlumnoNotaAsignatura();
		nota12.setUsuario(user7);
		nota12.setAsignatura(asig4);
		nota12.setNota(null);
		notasRepo.save(nota12);
		
		AlumnoNotaAsignatura nota13 = new AlumnoNotaAsignatura();
		nota13.setUsuario(user8);
		nota13.setAsignatura(asig4);
		nota13.setNota(null);
		notasRepo.save(nota13);
		
		AlumnoNotaAsignatura nota14 = new AlumnoNotaAsignatura();
		nota14.setUsuario(user8);
		nota14.setAsignatura(asig5);
		nota14.setNota(null);
		notasRepo.save(nota14);
		
		AlumnoNotaAsignatura nota15 = new AlumnoNotaAsignatura();
		nota15.setUsuario(user8);
		nota15.setAsignatura(asig7);
		nota15.setNota(null);
		notasRepo.save(nota15);
		
		AlumnoNotaAsignatura nota16 = new AlumnoNotaAsignatura();
		nota16.setUsuario(user9);
		nota16.setAsignatura(asig1);
		nota16.setNota(null);
		notasRepo.save(nota16);
		
		AlumnoNotaAsignatura nota17 = new AlumnoNotaAsignatura();
		nota17.setUsuario(user9);
		nota17.setAsignatura(asig2);
		nota17.setNota(null);
		notasRepo.save(nota17);
		
		AlumnoNotaAsignatura nota18 = new AlumnoNotaAsignatura();
		nota18.setUsuario(user9);
		nota18.setAsignatura(asig7);
		nota18.setNota(null);
		notasRepo.save(nota18);
		
		AlumnoNotaAsignatura nota19 = new AlumnoNotaAsignatura();
		nota19.setUsuario(user9);
		nota19.setAsignatura(asig8);
		nota19.setNota(null);
		notasRepo.save(nota19);
		
		AlumnoNotaAsignatura nota20 = new AlumnoNotaAsignatura();
		nota20.setUsuario(user10);
		nota20.setAsignatura(asig1);
		nota20.setNota(null);
		notasRepo.save(nota20);
		
		AlumnoNotaAsignatura nota21 = new AlumnoNotaAsignatura();
		nota21.setUsuario(user10);
		nota21.setAsignatura(asig2);
		nota21.setNota(null);
		notasRepo.save(nota21);
		
		AlumnoNotaAsignatura nota22 = new AlumnoNotaAsignatura();
		nota22.setUsuario(user11);
		nota22.setAsignatura(asig1);
		nota22.setNota(null);
		notasRepo.save(nota22);
		
		AlumnoNotaAsignatura nota23 = new AlumnoNotaAsignatura();
		nota23.setUsuario(user11);
		nota23.setAsignatura(asig2);
		nota23.setNota(null);
		notasRepo.save(nota23);
		
		AlumnoNotaAsignatura nota24 = new AlumnoNotaAsignatura();
		nota24.setUsuario(user11);
		nota24.setAsignatura(asig3);
		nota24.setNota(null);
		notasRepo.save(nota24);
		
		AlumnoNotaAsignatura nota25 = new AlumnoNotaAsignatura();
		nota25.setUsuario(user11);
		nota25.setAsignatura(asig6);
		nota25.setNota(null);
		notasRepo.save(nota25);
		
		AlumnoNotaAsignatura nota26 = new AlumnoNotaAsignatura();
		nota26.setUsuario(user12);
		nota26.setAsignatura(asig1);
		nota26.setNota(null);
		notasRepo.save(nota26);
		
		AlumnoNotaAsignatura nota27 = new AlumnoNotaAsignatura();
		nota27.setUsuario(user12);
		nota27.setAsignatura(asig2);
		nota27.setNota(null);
		notasRepo.save(nota27);
		
		AlumnoNotaAsignatura nota28 = new AlumnoNotaAsignatura();
		nota28.setUsuario(user12);
		nota28.setAsignatura(asig8);
		nota28.setNota(null);
		notasRepo.save(nota28);

		AlumnoNotaAsignatura nota29 = new AlumnoNotaAsignatura();
		nota29.setUsuario(user13);
		nota29.setAsignatura(asig4);
		nota29.setNota(null);
		notasRepo.save(nota29);
		
		AlumnoNotaAsignatura nota30 = new AlumnoNotaAsignatura();
		nota30.setUsuario(user13);
		nota30.setAsignatura(asig5);
		nota30.setNota(null);
		notasRepo.save(nota30);
		
		AlumnoNotaAsignatura nota31 = new AlumnoNotaAsignatura();
		nota31.setUsuario(user13);
		nota31.setAsignatura(asig6);
		nota31.setNota(null);
		notasRepo.save(nota31);
		
		AlumnoNotaAsignatura nota32 = new AlumnoNotaAsignatura();
		nota32.setUsuario(user13);
		nota32.setAsignatura(asig8);
		nota32.setNota(null);
		notasRepo.save(nota32);
		
		AlumnoNotaAsignatura nota33 = new AlumnoNotaAsignatura();
		nota33.setUsuario(user14);
		nota33.setAsignatura(asig4);
		nota33.setNota(null);
		notasRepo.save(nota33);
		
		
		AlumnoNotaAsignatura nota34 = new AlumnoNotaAsignatura();
		nota34.setUsuario(user14);
		nota34.setAsignatura(asig5);
		nota34.setNota(null);
		notasRepo.save(nota34);
		
		AlumnoNotaAsignatura nota35 = new AlumnoNotaAsignatura();
		nota35.setUsuario(user14);
		nota35.setAsignatura(asig7);
		nota35.setNota(null);
		notasRepo.save(nota35);
		
		AlumnoNotaAsignatura nota36 = new AlumnoNotaAsignatura();
		nota36.setUsuario(user15);
		nota36.setAsignatura(asig1);
		nota36.setNota(null);
		notasRepo.save(nota36);
		
		AlumnoNotaAsignatura nota37 = new AlumnoNotaAsignatura();
		nota37.setUsuario(user15);
		nota37.setAsignatura(asig3);
		nota37.setNota(null);
		notasRepo.save(nota37);
		
		AlumnoNotaAsignatura nota38 = new AlumnoNotaAsignatura();
		nota38.setUsuario(user15);
		nota38.setAsignatura(asig8);
		nota38.setNota(null);
		notasRepo.save(nota38);
		
	}
}

*/
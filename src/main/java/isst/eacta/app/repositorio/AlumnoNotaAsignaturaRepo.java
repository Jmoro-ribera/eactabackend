package isst.eacta.app.repositorio;

import isst.eacta.app.modelo.AlumnoNotaAsignatura;
import isst.eacta.app.modelo.Asignaturas;
import isst.eacta.app.modelo.Usuario;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoNotaAsignaturaRepo extends JpaRepository<AlumnoNotaAsignatura, Long> {
	@Query("FROM AlumnoNotaAsignatura a WHERE a.usuario = :usuario AND a.asignatura = :asignatura")
	AlumnoNotaAsignatura findNota(@Param("usuario") Usuario user, @Param("asignatura") Asignaturas asignatura);
	
	@Query("FROM AlumnoNotaAsignatura a WHERE a.asignatura = :asignatura")
	List<AlumnoNotaAsignatura> findAlumnosbyAsignatura(@Param("asignatura") Asignaturas asignatura);
	
	@Query("FROM AlumnoNotaAsignatura a WHERE a.usuario = :usuario")
	List<AlumnoNotaAsignatura> findAsignaturasbyAlumno(@Param("usuario") Usuario usuario);
	
}

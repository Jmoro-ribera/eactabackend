package isst.eacta.app.repositorio;

import isst.eacta.app.modelo.Funcionalidad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionalidadRepo extends JpaRepository<Funcionalidad, Long> {
	//@Query("FROM Usuario u WHERE u.nombre = :name")
	//List<Usuario> findUsersByName(@Param("name") String name);
	
}

package isst.eacta.app.repositorio;

import isst.eacta.app.modelo.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	
	@Query("FROM Usuario u WHERE u.email = :email")
	Usuario findUserByMail(@Param("email") String email);
	
}

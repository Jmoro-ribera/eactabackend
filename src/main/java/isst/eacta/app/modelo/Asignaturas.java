package isst.eacta.app.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ASIGNATURAS")
public class Asignaturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String siglas;
    
    private String nombreAsignaturas;
    
    @JsonBackReference
    @ManyToMany(mappedBy = "asignaturas")
    private List<Usuario> usuarios;
    
    @JsonBackReference
    @OneToMany(mappedBy = "asignatura")
    private List<AlumnoNotaAsignatura> asignaturaNotaAlumno;

    public Asignaturas() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreAsignaturas() {
		return nombreAsignaturas;
	}

	public void setNombreAsignaturas(String nombreAsignaturas) {
		this.nombreAsignaturas = nombreAsignaturas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<AlumnoNotaAsignatura> getAsignaturaNotaAlumno() {
		return asignaturaNotaAlumno;
	}

	public void setAsignaturaNotaAlumno(List<AlumnoNotaAsignatura> asignaturaNotaAlumno) {
		this.asignaturaNotaAlumno = asignaturaNotaAlumno;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
 
    
    
}



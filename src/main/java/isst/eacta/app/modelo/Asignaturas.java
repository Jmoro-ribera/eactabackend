package isst.eacta.app.modelo;

import java.util.List;

import javax.persistence.Column;
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
    
    private Integer firmado1;
    
    private Integer firmado2;
    
    private Integer firmado3;
    
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

	public Integer getFirmado1() {
		return firmado1;
	}

	public void setFirmado1(Integer firmado1) {
		this.firmado1 = firmado1;
	}

	public Integer getFirmado2() {
		return firmado2;
	}

	public void setFirmado2(Integer firmado2) {
		this.firmado2 = firmado2;
	}

	public Integer getFirmado3() {
		return firmado3;
	}

	public void setFirmado3(Integer firmado3) {
		this.firmado3 = firmado3;
	}
    
}



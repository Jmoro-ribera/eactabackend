package isst.eacta.app.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ALUMNO_NOTA_ASIGNATURA")
public class AlumnoNotaAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ALUMNO_ID")
    private Usuario usuario;
    
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "ASIGNATURA_ID")
    private Asignaturas asignatura;

    private Double nota;

    public AlumnoNotaAsignatura(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Asignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
    
    
    
}

package isst.eacta.app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;
    
    private String password;
    
    @Lob
    private Byte[] userImage;
    
    //private Boolean login;
   
	@ManyToOne(optional = true, fetch = FetchType.EAGER) 
	  @JoinColumn(name = "ROL_ID") 
	  private Rol idRol;
    //private int idRol;
	  
	  @JsonManagedReference
	  @JoinTable(
		        name = "rel_usuario_asignatura",
		        joinColumns = @JoinColumn(name = "FK_USUARIO", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="FK_ASIGNATURA", nullable = false)
		    )
		    @ManyToMany(cascade = CascadeType.ALL)
		    private List<Asignaturas> asignaturas;
		   
		    public void addAsignaturas(Asignaturas asignaturass){
		        if(this.asignaturas == null){
		            this.asignaturas = new ArrayList<>();
		        }
		        
		        this.asignaturas.add(asignaturass);
		    }
	
    @JsonBackReference
    @OneToMany(mappedBy = "usuario")
    private List<AlumnoNotaAsignatura> alumnoNotaAsignatura;
    
    public Usuario() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public List<Asignaturas> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignaturas> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<AlumnoNotaAsignatura> getAlumnoNotaAsignatura() {
		return alumnoNotaAsignatura;
	}

	public void setAlumnoNotaAsignatura(List<AlumnoNotaAsignatura> alumnoNotaAsignatura) {
		this.alumnoNotaAsignatura = alumnoNotaAsignatura;
	}
	
	  public Byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(Byte[] userImage) {
		this.userImage = userImage;
	}
    
}


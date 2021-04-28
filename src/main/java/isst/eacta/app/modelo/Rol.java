package isst.eacta.app.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombreRol;
    
    @JsonManagedReference
    @JoinTable(
            name = "rel_rol_funcinalidad",
            joinColumns = @JoinColumn(name = "FK_ROL", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_FUNCIONALIDAD", nullable = false)
        )
        @ManyToMany(cascade = CascadeType.ALL)
        private List<Funcionalidad> funcionalidades;
       
        public void addfunc(Funcionalidad funcionalidadess){
            if(this.funcionalidades == null){
                this.funcionalidades = new ArrayList<>();
            }
            
            this.funcionalidades.add(funcionalidadess);    
        }

    public Rol() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
       
    
        
}

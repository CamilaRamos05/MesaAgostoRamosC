package ar.edu.unju.fi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String email;
	private String dni;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, String email, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getDni() { return dni; }
	public void setDni(String dni) { this.dni = dni; }
}

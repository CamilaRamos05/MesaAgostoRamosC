package ar.edu.unju.fi.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private LocalDateTime fecha;
	private String lugar;
	private Double precio;
	private Integer capacidad;
	private String tipoEvento;
	
	public Evento() {}
	
	public Evento(String nombre, String descripcion, LocalDateTime fecha, String lugar, Double precio, Integer capacidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.lugar = lugar;
		this.precio = precio;
		this.capacidad = capacidad;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	
	public LocalDateTime getFecha() { return fecha; }
	public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
	
	public String getLugar() { return lugar; }
	public void setLugar(String lugar) { this.lugar = lugar; }
	
	public Double getPrecio() { return precio; }
	public void setPrecio(Double precio) { this.precio = precio; }
	
	public Integer getCapacidad() { return capacidad; }
	public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
	
	public String getTipoEvento() { return tipoEvento; }
	public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
}

package ar.edu.unju.fi.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long clienteId;
	private Long eventoId;
	private Integer cantidadTickets;
	private Double total;
	private LocalDateTime fechaCompra;
	
	public Compra() {}
	
	public Compra(Long clienteId, Long eventoId, Integer cantidadTickets, Double total) {
		this.clienteId = clienteId;
		this.eventoId = eventoId;
		this.cantidadTickets = cantidadTickets;
		this.total = total;
		this.fechaCompra = LocalDateTime.now();
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public Long getClienteId() { return clienteId; }
	public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
	
	public Long getEventoId() { return eventoId; }
	public void setEventoId(Long eventoId) { this.eventoId = eventoId; }
	
	public Integer getCantidadTickets() { return cantidadTickets; }
	public void setCantidadTickets(Integer cantidadTickets) { this.cantidadTickets = cantidadTickets; }
	
	public Double getTotal() { return total; }
	public void setTotal(Double total) { this.total = total; }
	
	public LocalDateTime getFechaCompra() { return fechaCompra; }
	public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}

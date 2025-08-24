package ar.edu.unju.fi.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Evento;
import ar.edu.unju.fi.model.TipoEvento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	List<Evento> findByFechaAfterOrderByFechaAsc(LocalDateTime fecha);
	
	List<Evento> findByNombreContainingIgnoreCase(String nombre);
	
	Optional<Evento> findByNombre(String nombre);
	
	@Query("SELECT e FROM Evento e WHERE e.fecha > :fecha AND e.capacidad > " + 
		   "(SELECT COALESCE(SUM(c.cantidadTickets), 0) FROM Compra c WHERE c.evento = e)")
	List<Evento> findEventosDisponibles(@Param("fecha") LocalDateTime fecha);
	
	@Query("SELECT COALESCE(SUM(c.cantidadTickets), 0) FROM Compra c WHERE c.evento.id = :eventoId")
	Integer getTicketsVendidos(@Param("eventoId") Long eventoId);
	
	@Query("SELECT e.nombre, COALESCE(SUM(c.total), 0) FROM Evento e LEFT JOIN e.compras c GROUP BY e.id, e.nombre ORDER BY SUM(c.total) DESC")
	List<Object[]> getRecaudacionPorEvento();
	
	List<Evento> findByTipoEventoAndFechaAfterOrderByFechaAsc(TipoEvento tipoEvento, LocalDateTime fecha);
	
	@Query("SELECT e.tipoEvento, COALESCE(SUM(c.total), 0) FROM Evento e LEFT JOIN e.compras c GROUP BY e.tipoEvento ORDER BY SUM(c.total) DESC")
	List<Object[]> getRecaudacionPorTipoEvento();
}

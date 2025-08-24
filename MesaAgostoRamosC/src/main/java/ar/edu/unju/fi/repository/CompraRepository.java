package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	List<Compra> findByClienteOrderByFechaCompraDesc(Long clienteId);
	
	List<Compra> findByEventoOrderByFechaCompraDesc(Long eventoId);
	
	@Query("SELECT COALESCE(SUM(c.cantidadTickets), 0) FROM Compra c WHERE c.evento.id = :eventoId")
	Integer countTicketsVendidosPorEvento(@Param("eventoId") Long eventoId);
	
	@Query("SELECT e.nombre, COALESCE(SUM(c.total), 0) FROM Compra c JOIN c.evento e GROUP BY e.id, e.nombre ORDER BY SUM(c.total) DESC")
	List<Object[]> findRecaudacionPorEvento();
}

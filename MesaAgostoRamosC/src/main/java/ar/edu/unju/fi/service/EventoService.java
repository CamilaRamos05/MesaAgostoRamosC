package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.exception.EventoNoEncontradoException;
import ar.edu.unju.fi.exception.InvalidCapacityException;
import ar.edu.unju.fi.model.Evento;
import ar.edu.unju.fi.model.TipoEvento;
import ar.edu.unju.fi.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public List<Evento> listarEventos() {
		return eventoRepository.findByFechaAfterOrderByFechaAsc(LocalDateTime.now());
	}
	
	public List<Evento> listarEventosConPrecios() {
		return eventoRepository.findAll();
	}
	
	public List<Evento> listarEventosDisponibles() {
		return eventoRepository.findEventosDisponibles(LocalDateTime.now());
	}
	
	public List<Evento> listarEventosPorTipo(TipoEvento tipoEvento) {
		return eventoRepository.findByTipoEventoAndFechaAfterOrderByFechaAsc(tipoEvento, LocalDateTime.now());
	}
	
	@Transactional
	public Evento guardarEvento(Evento evento) {
		if (evento.getCapacidad() < 0) {
			throw new InvalidCapacityException("La capacidad no puede ser negativa.");
		}
		
		if (evento.getCapacidadInicial() == null) {
			evento.setCapacidadInicial(evento.getCapacidad());
		}
		
		if (evento.getId() != null) {
			Evento eventoExistente = obtenerEventoPorId(evento.getId());
			if (evento.getCapacidad() < eventoExistente.getCapacidad()) {
				int ticketsVendidos = eventoRepository.getTicketsVendidos(evento.getId());
				if (evento.getCapacidad() < ticketsVendidos) {
					throw new InvalidCapacityException("No se puede reducir la capacidad por debajo de los tickets vendidos");
				}
			}
		}
		return eventoRepository.save(evento);
	}
	
	@Transactional
	public Evento obtenerEventoPorId(Long id) {
		return eventoRepository.findById(id).orElse(null);
	}
	
	@Transactional
	public void eliminar(Long id) {
		eventoRepository.deleteById(id);
	}
	
	public int obtenerTicketsDisponibles(Long eventoId) {
		Evento evento = obtenerEventoPorId(eventoId);
		int ticketsVendidos = eventoRepository.getTicketsVendidos(eventoId);
		return evento.getCapacidad() - ticketsVendidos;
	}
	
	public Map<String, Double> obtenerRecaudacionPorEvento() {
		List<Object[]> resultados = eventoRepository.getRecaudacionPorEvento();
		Map<String, Double> recaudacion = new HashMap<>();
		
		for (Object[] resultado : resultados) {
			String nombreEvento = (String) resultado[0];
			Double total = (Double) resultado[1];
			recaudacion.put(nombreEvento, total);
		}
		
		return recaudacion;
	}
	
	public Map<TipoEvento, Double> obtenerRecaudacionPorTipoEvento() {
		List<Object[]> resultados = eventoRepository.getRecaudacionPorTipoEvento();
		Map<TipoEvento, Double> recaudacion = new HashMap<>();
		
		for (Object[] resultado : resultados) {
			TipoEvento tipo = (TipoEvento) resultado[0];
			Double total = (Double) resultado[1];
			recaudacion.put(tipo, total);
		}
		
		return recaudacion;
	}
	
	public List<Evento> buscarEventosPorNombre(String nombre) {
		return eventoRepository.findByNombreContainingIgnoreCase(nombre);
	}
}

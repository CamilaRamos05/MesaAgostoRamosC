package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Evento;
import ar.edu.unju.fi.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	public List<Evento> listarEventos() {
		return eventoRepository.findAll();
	}
	
	public Optional<Evento> obtenerEventoPorId(Long id) {
		return eventoRepository.findById(id);
	}
	
	public Evento guardarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public void eliminarEvento(Long id) {
		eventoRepository.deleteById(id);
	}
	
	public List<Evento> listarEventosDisponibles() {
		return listarEventos();
	}
	
	public int obtenerTicketsDisponibles(Long eventoId) {
		return 0;
	}
}

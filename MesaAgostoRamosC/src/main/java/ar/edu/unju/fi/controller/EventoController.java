package ar.edu.unju.fi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.model.Evento;
import ar.edu.unju.fi.service.EventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping("")
	public String listarEventos(Model model) {
		List<Evento> eventos = eventoService.listarEventos();
		model.addAttribute("eventos", eventos);
		return "eventos/lista";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioNuevo(Model model) {
		return "eventos/form";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(Long id, Model model) {
		return "eventos/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEvento(Long id) {
		return "redirect:/eventos";
	}
}

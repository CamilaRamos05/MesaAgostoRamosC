package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}

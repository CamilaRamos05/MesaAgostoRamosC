package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByEmail(String email);
	
	Optional<Cliente> findByDni(String dni);
	
	@Query("SELECT DISTINCT c FROM Cliente c JOIN FETCH c.compras")
	List<Cliente> findClientesConCompras();
}

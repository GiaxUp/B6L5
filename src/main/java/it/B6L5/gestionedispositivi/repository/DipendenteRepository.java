package it.B6L5.gestionedispositivi.repository;

import org.springframework.data.repository.CrudRepository;

import it.B6L5.gestionedispositivi.model.Dipendente;

public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {

	public Dipendente findByEmail(String email);

	public boolean existsByEmail(String email);
}

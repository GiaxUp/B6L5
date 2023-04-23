package it.B6L5.gestionedispositivi.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import it.B6L5.gestionedispositivi.model.Dispositivo;
import it.B6L5.gestionedispositivi.repository.DispositivoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {

	@Autowired
	DispositivoRepository repo;
	@Autowired
	@Qualifier("CustomDispositivo")
	private ObjectProvider<Dispositivo> customDispositivoProvider;

	public Dispositivo createDispositivo(Dispositivo D) {
		repo.save(D);
		return D;

	}

	public List<Dispositivo> getAllDispositivi() {
		return (List<Dispositivo>) repo.findAll();
	}

	public Dispositivo getDispositivo(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Il dispositivo non esiste.");
		}
		return repo.findById(id).get();
	}

	public String updateDispositivo(Dispositivo dip) {
		if (!repo.existsById(dip.getId())) {
			throw new EntityExistsException("Il dispositivo non esiste.");
		}
		repo.save(dip);
		return "Dispositivo aggiornato.";
	}

	public String updateDispositivoInManutenzione(Dispositivo dip) {
		dip.setInmanutenzione(true);
		if (!repo.existsById(dip.getId())) {
			throw new EntityExistsException("Il dispositivo non esiste.");
		}
		repo.save(dip);
		return "Dispositivo aggiornato.";
	}

	public String updateDispositivoFineManutenzione(Dispositivo dip) {
		dip.setInmanutenzione(false);
		if (!repo.existsById(dip.getId())) {
			throw new EntityExistsException("Il dispositivo non esiste.");
		}
		repo.save(dip);
		return "Dispositivo aggiornato.";
	}

	public String updateDispositivoDismesso(Dispositivo dip) {
		dip.setDismesso(true);
		if (!repo.existsById(dip.getId())) {
			throw new EntityExistsException("Il dispositivo non esiste.");
		}
		repo.save(dip);
		return "Dispositivo aggiornato.";
	}

	public String removeDispositivo(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Il dispositivo non esiste.");
		}
		repo.deleteById(id);
		return "Dispositivo eliminato.";
	}

}

package it.B6L5.gestionedispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.B6L5.gestionedispositivi.model.Dipendente;
import it.B6L5.gestionedispositivi.service.DipendenteService;

@RestController
@RequestMapping("/dipendenti")

public class DipendenteController {

	@Autowired
	DipendenteService service;

	@GetMapping
	public ResponseEntity<List<Dipendente>> getAll() {
		return new ResponseEntity<List<Dipendente>>(service.getAllDipendenti(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDipendenti(@PathVariable Long id) {
		return new ResponseEntity<Dipendente>(service.getDipendente(id), HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<?> createDipendenti(@RequestBody Dipendente dipendente) {
		return new ResponseEntity<>(service.createDipendente(dipendente), HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDipendenti(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeDipendente(id), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<?> updateUtente(@RequestBody Dipendente dipendente) {
		return new ResponseEntity<>(service.updateDipendente(dipendente), HttpStatus.CREATED);

	}
}

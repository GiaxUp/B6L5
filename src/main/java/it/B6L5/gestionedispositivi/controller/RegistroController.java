package it.B6L5.gestionedispositivi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.B6L5.gestionedispositivi.model.Registro;
import it.B6L5.gestionedispositivi.service.RegistroService;

@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	RegistroService service;

	@GetMapping
	public ResponseEntity<List<Registro>> getAll() {
		return new ResponseEntity<List<Registro>>(service.getAllElement(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDipendenti(@PathVariable Long id) {
		return new ResponseEntity<Registro>(service.getElement(id), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDipendenti(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeRegistrazione(id), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<?> updateUtente(@RequestBody Registro reg) {
		return new ResponseEntity<>(service.updateRegistrazione(reg), HttpStatus.CREATED);

	}

}

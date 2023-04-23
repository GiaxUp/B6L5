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

import it.B6L5.gestionedispositivi.model.Dispositivo;
import it.B6L5.gestionedispositivi.service.DispositivoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

@Autowired DispositivoService service;
	
	@GetMapping
	public ResponseEntity<List<Dispositivo>> getAll () {
		return new ResponseEntity<List<Dispositivo>>(service.getAllDispositivi(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDispositivo(@PathVariable Long id) {
		return new ResponseEntity<Dispositivo>(service.getDispositivo(id), HttpStatus.CREATED);
	}
	
	
	@PostMapping
	public ResponseEntity<?> createDispositivo(@RequestBody Dispositivo disp){
		return new ResponseEntity<>(service.createDispositivo(disp), HttpStatus.CREATED);
	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDispositivo(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeDispositivo(id), HttpStatus.OK);

	}
	
	@PutMapping
	public ResponseEntity<?> updateUtente(@RequestBody Dispositivo disp){
		return new ResponseEntity<>(service.updateDispositivo(disp), HttpStatus.CREATED);
		
	}
}

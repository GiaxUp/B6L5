package it.B6L5.gestionedispositivi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "registro")
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnoreProperties("dispositivo")
	@JoinColumn(name = "id_dispositivo")
	@ManyToOne
	private Dispositivo dispositivi;
	@ManyToOne
	@JsonIgnoreProperties("dipendente")
	@JoinColumn(name = "id_dipendente")
	private Dipendente dipendente;

	public Registro(Dispositivo dispositivi, Dipendente dipendente) {
		super();
		this.dispositivi = dispositivi;
		this.dipendente = dipendente;
	}

}

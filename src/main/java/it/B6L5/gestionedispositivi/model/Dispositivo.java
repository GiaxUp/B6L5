package it.B6L5.gestionedispositivi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "dispositivi")
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDispositivo tipodispositivo;
	@Column
	private Boolean disponibile;
	@Column
	private Boolean assegnato;
	@Column
	private Boolean inmanutenzione;
	@Column
	private Boolean dismesso;

	public Dispositivo(TipoDispositivo tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
		this.assegnato = false;
		this.inmanutenzione = false;
		this.dismesso = false;
		this.disponibile = true;
	}
}

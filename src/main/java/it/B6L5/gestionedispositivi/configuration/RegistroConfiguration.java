package it.B6L5.gestionedispositivi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.B6L5.gestionedispositivi.model.Dipendente;
import it.B6L5.gestionedispositivi.model.Dispositivo;
import it.B6L5.gestionedispositivi.model.Registro;

@Configuration
public class RegistroConfiguration {

	@Bean("NuovaRegistrazione")
	@Scope("prototype")
	public Registro nuovaRegistrazione() {
		return new Registro();
	}

	@Bean("ParamRegistrazione")
	@Scope("prototype")
	public Registro paramRegistrazione(Dipendente dipe, Dispositivo disp) {
		Registro R = new Registro();
		R.setDipendente(dipe);
		R.setDispositivi(disp);
		return R;
	}

}

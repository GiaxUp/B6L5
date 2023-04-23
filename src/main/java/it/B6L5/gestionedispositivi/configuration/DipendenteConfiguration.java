package it.B6L5.gestionedispositivi.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.B6L5.gestionedispositivi.model.Dipendente;

@Configuration
public class DipendenteConfiguration {

	@Bean("FakeDipendente")
	@Scope("prototype")
	public Dipendente fakeUtente() {
		Faker fake = Faker.instance(Locale.of("it"));
		Dipendente D = new Dipendente();
		D.setNome(fake.name().firstName());
		D.setCognome(fake.name().lastName());
		D.setUsername(D.getNome() + D.getCognome() + fake.number().randomDigit());
		D.setEmail(D.getNome() + "." + D.getCognome() + "@example.com");
		return D;
	}

	@Bean("CustomDipendente")
	@Scope("prototype")
	public Dipendente customDipendente() {
		return new Dipendente();
	}

	@Bean("ParamsDipendente")
	@Scope("prototype")
	public Dipendente paramsDipendente(String username, String nome, String cognome, String email) {
		return new Dipendente(username, nome, cognome, email);
	}

}

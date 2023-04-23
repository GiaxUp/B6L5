package it.B6L5.gestionedispositivi.auth.service;

import it.B6L5.gestionedispositivi.auth.payload.LoginDto;
import it.B6L5.gestionedispositivi.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}

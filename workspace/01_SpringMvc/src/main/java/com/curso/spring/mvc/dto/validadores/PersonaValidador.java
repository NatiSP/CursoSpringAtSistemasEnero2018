package com.curso.spring.mvc.dto.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.curso.spring.mvc.dto.Persona;

public class PersonaValidador implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Persona.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Persona persona = (Persona) arg0;
		if(persona.getNombre().equals("Homer")) {
			System.out.println("Club no homers");
			arg1.rejectValue("nombre", "formulario.persona.error.nombre", "Club no homers");
			//arg1.reject("nombre", "Mihmihmih");
		}
	}

	
}

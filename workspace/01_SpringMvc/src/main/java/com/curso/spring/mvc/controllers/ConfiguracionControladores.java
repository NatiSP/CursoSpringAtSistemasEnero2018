package com.curso.spring.mvc.controllers;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.curso.spring.mvc.dto.validadores.PersonaValidador;

/**
 * Permite que todos los controladores tengan una configuración común
 * 
 * @author ngutierrez.rodriguez
 *
 */
@ControllerAdvice("com.curso.spring.mvc.controllers")
// @SessionAttributes("generos")
public class ConfiguracionControladores {

	@ModelAttribute("generos")
	public String[] generos() {
		return new String[] { "M", "F" };
	}

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(new PersonaValidador());
	}
}

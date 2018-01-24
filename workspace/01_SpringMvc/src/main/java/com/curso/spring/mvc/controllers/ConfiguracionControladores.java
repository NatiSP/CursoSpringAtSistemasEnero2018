package com.curso.spring.mvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Permite que todos los controladores tengan una configuraci�n com�n
 * @author ngutierrez.rodriguez
 *
 */
@ControllerAdvice("com.curso.spring.mvc.controllers")
//@SessionAttributes("generos")
public class ConfiguracionControladores {

	@ModelAttribute("generos")
	public String[] generos() {
		return new String[] {"M","F"};
	}
}

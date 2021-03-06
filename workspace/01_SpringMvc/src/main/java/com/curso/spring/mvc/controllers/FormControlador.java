package com.curso.spring.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.spring.mvc.dto.Persona;

@Controller
@RequestMapping("/formulario")
public class FormControlador {
	
	@ModelAttribute
	public Persona persona() {
		return new Persona();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String iniciarFormulario(Model model) {
		//model.addAttribute("generos", new String[] {"M","F"});
		return "formulario";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String procesarFormulario(@Valid @ModelAttribute Persona persona, Errors errores) {
		
		
		return "formulario";
	}
}

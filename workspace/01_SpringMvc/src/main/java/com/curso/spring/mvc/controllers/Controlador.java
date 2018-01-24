package com.curso.spring.mvc.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import com.curso.spring.mvc.dto.Persona;
import com.curso.spring.mvc.services.Servicio;

@Controller
@RequestMapping("/saludo")
public class Controlador {
	
	@Autowired
	@Qualifier("miVista")
	private View miVista;
	
	@Autowired
	private Servicio servicio;
	
	/**
	 * Metodo que busca un mensaje de bienvenida por su id y lo completa con la informacion del objeto Persona que recibe por parametro
	 * @param model
	 * @param persona
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/bienvenida/{id}", method = RequestMethod.GET)
	public String bienvenida(Map<String, Object> model, Persona persona, @PathVariable int id) {
		model.put("saludo", "Hola");
		return "miVista";
	}

	/**
	 * Metodo que busca un mensaje de despedida para retornarlo
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/despedida", method = RequestMethod.GET)
	public View despedida(Model model, @RequestParam int id) {
		model.addAttribute("saludo", "Adios");
		return miVista;
	}
	
	/**
	 * Metodo que recibiendo una persona en formato JSON, le cambia el nombre y retorna en formato XML
	 * @param persona
	 * @param nombreNuevo
	 * @return
	 */
	@RequestMapping(path="/cambioDeNombre", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	@ResponseBody public Persona cambiarElNombreALaPersona(@RequestBody Persona persona, @RequestParam String nombreNuevo) {
		persona.setNombre(nombreNuevo);
		return persona;
	}
}

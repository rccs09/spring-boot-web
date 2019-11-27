package com.rccs.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesPathController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Recibir parametros del path (@PathVariable)");
		return "variables/index";
	}
	
	/* En la URL se llamaria de la siguiente manera: http://localhost:8080/variables/string/hola */
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parametros del path (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en el @PathVariable es : "+texto);
		
		return "variables/ver";
	}
	
	/* En la URL se llamaria de la siguiente manera: http://localhost:8080/variables/string/hola */
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parametros del path (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en el @PathVariable es : "+texto 
						   + ", y el numero enviado por el path es: " + numero);
		
		return "variables/ver";
	}
}

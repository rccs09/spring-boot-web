package com.rccs.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String homeRedirect() {
		return "redirect:/app/index";
	}
	
	@GetMapping("/ext")
	public String homeRedExternal() {
		return "redirect:https://www.google.com";
	}
	
	@GetMapping("/fwd")
	public String homeRedFordward() {
		return "forward:/app/index";
	}
	
	/* NOTAS: 
	 * 1.- Redirect: redirecciona a una pantalla reiniciando el request y cargando la ruta indicada
	 * 				 por lo tanto la URL SI cambia
	 * 2.- Fordward: Carga la pagina sin reiniciar el request, sin recargar la pagina, realiza un dispacher dentro del mismo request hacia la ruta indicada
	 * 				 por lo tanto la URL NO cambia
	 * 
	 * */
}

package com.rccs.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rccs.springboot.web.app.model.User;

@Controller
/* para definir un path general para el controlador*/
@RequestMapping("/app")
public class IndexController {
	
	@Value("${text.indexController.index.titulo}")
	private String textIndex;
	
	@Value("${text.indexController.profile.titulo}")
	private String textProfile;
	
	@Value("${text.indexController.list.titulo}")
	private String textList;
	
	@GetMapping({"/index","/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textIndex);
		return "index";
	}
	
	
	@RequestMapping({"/profile"})
	public String profile(Model model) {
		User u = new User();
		u.setName("Roberto");
		u.setLastName("Cadena");
		u.setMail("correo@corre.com");
		model.addAttribute("user", u);
		model.addAttribute("titulo", textProfile);
		return "profile";
	}
	
	@RequestMapping({"/list"})
	public String list(Model model) {
		User u = new User();
		u.setName("Roberto");
		u.setLastName("Cadena");
		u.setMail("correo@corre.com");
		model.addAttribute("titulo", textList);
		return "list";
	}

	/* Al usar ModelAttribute: 
	 * -> "users" sera el nombre del atributo
	 * -> este atributo estará disponible desde todos los metodos del controlador
	 *  */
	@ModelAttribute("users")
	public List<User> fillList(){
		List<User> lista = new ArrayList<User>();
		lista.add(new User("Roberto", "Cadena", "mail1@mail.com"));
		lista.add(new User("Joaquin", "Cadena", "mail2@mail.com"));
		lista.add(new User("Mateo", "Cadena", "mail3@mail.com"));
		lista.add(new User("Lorena", "Garcia", "mail4@mail.com"));
		return lista;
	}
}


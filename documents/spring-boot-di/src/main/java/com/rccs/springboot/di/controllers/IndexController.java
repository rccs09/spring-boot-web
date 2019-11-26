package com.rccs.springboot.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rccs.springboot.di.models.services.Iservicio;
import com.rccs.springboot.di.models.services.MiServicio;

@Controller
public class IndexController {
	@Autowired
	@Qualifier("miservicioSimple")
	private Iservicio servicio;
	
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		model.addAttribute("objeto", servicio.operacion());
		return "/index";
	}
}

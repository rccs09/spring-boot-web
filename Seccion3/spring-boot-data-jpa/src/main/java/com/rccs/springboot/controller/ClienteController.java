package com.rccs.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rccs.springboot.model.dao.IclienteDao;
import com.rccs.springboot.model.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteDaoJpaImpl")
	private IclienteDao iclienteDao; 
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", iclienteDao.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de cliente");
		Cliente c = new Cliente();
		model.put("cliente", c);
		
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Cliente c) {
		iclienteDao.save(c);
		return "redirect:listar";
	}
	 
	
}

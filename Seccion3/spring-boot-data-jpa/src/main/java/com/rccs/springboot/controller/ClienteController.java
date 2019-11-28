package com.rccs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rccs.springboot.model.dao.IclienteDao;

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
}

package com.rccs.springboot.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rccs.springboot.model.entity.Cliente;
import com.rccs.springboot.model.service.IClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteService clienteservice; 
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteservice.findAll());
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
	public String guardar(@Valid @ModelAttribute("cliente") Cliente c, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		clienteservice.save(c);
		return "redirect:listar";
	}
	 
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id")Long id, Map<String, Object> model) {
		Cliente cliente = null;
		if(id>0) {
			cliente = clienteservice.findById(id);
		}else {
			return "redirect:listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		System.out.println("waaaaaaaaaaaaaaaaaaaa");
		if(id>0) {
			clienteservice.delete(id);
		}
		System.out.println("222222222222222");
		return "redirect:/listar";
	}
}

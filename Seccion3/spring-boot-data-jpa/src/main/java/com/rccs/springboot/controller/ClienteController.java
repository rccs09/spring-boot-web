package com.rccs.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rccs.springboot.model.entity.Cliente;
import com.rccs.springboot.model.service.IClienteService;
import com.rccs.springboot.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteservice; 
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Cliente> clientes = clienteservice.findAll(pageRequest);
		PageRender<Cliente> pgCliente = new PageRender<Cliente>("/listar", clientes);
		
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pgCliente);
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
	public String guardar(@Valid @ModelAttribute("cliente") Cliente c, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static//uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytesFoto = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytesFoto);
				c.setFoto(foto.getOriginalFilename());
				flash.addAttribute("info", "Foto cargada correctamente '"+ foto.getOriginalFilename()+ "'");
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		String mensajeFlash = c.getId()!=null ? "Cliente editado con exito" : "Cliente creado con exito";
		
		clienteservice.save(c);
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	 
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id")Long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = null;
		if(id>0) {
			cliente = clienteservice.findById(id);
			if(cliente ==null) {
				flash.addFlashAttribute("error", "No se encontró un cliente con el id a editar");
				return "redirect:listar";
			}
		}else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero");
			return "redirect:listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		System.out.println("waaaaaaaaaaaaaaaaaaaa");
		if(id>0) {
			clienteservice.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con exito");
		}
		
		return "redirect:/listar";
	}
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Map<String, Object> map, RedirectAttributes flash) {
		Cliente cliente = clienteservice.findById(id);
		if(cliente==null) {
			flash.addAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		map.put("cliente", cliente);
		map.put("titulo", "Detalle deli cliente: "+cliente.getNombre());
		return "ver";
	}
}

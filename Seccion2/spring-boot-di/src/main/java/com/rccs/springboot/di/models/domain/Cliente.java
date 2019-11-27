package com.rccs.springboot.di.models.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cliente implements Serializable{
	private static final long serialVersionUID = 4554581141665880180L;

	@Value("${cliente.nombre}")
	private String nombre;
	
	@Value("${cliente.apellido}")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

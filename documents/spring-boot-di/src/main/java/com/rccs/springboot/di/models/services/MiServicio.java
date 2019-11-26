package com.rccs.springboot.di.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miservicioSimple")
@Primary
public class MiServicio implements Iservicio{

	@Override
	public String operacion() {
		return "Ejecutando algu proceso desde el servivcio simple";
	}
	
}

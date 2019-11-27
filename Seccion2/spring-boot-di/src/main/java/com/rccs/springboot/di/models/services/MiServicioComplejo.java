package com.rccs.springboot.di.models.services;

//@Component("miservicioComplejo")
public class MiServicioComplejo implements Iservicio{

	@Override
	public String operacion() {
		return "Ejecutando algu proceso desde el servivcio complejo";
	}
	
}

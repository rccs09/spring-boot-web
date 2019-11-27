package com.rccs.springboot.di.models.services;

//@Component("miservicioSimple")
//@Primary
public class MiServicio implements Iservicio{

	@Override
	public String operacion() {
		return "Ejecutando algu proceso desde el servivcio simple";
	}
	
}

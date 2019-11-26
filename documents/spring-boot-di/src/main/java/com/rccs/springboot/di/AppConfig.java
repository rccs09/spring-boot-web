package com.rccs.springboot.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.rccs.springboot.di.models.services.Iservicio;
import com.rccs.springboot.di.models.services.MiServicio;
import com.rccs.springboot.di.models.services.MiServicioComplejo;

@Configuration
public class AppConfig {
	
	@Bean("miservicioSimple")
	@Primary
	public Iservicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miservicioComplejo")
	public Iservicio registrarMiServicioComplejo() {
		return new MiServicioComplejo(); 
	}
}

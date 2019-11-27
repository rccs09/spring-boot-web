package com.rccs.springboot.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.rccs.springboot.di.models.domain.ItemFactura;
import com.rccs.springboot.di.models.domain.Producto;
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
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto p1 = new Producto("Camara sony", 100.00);
		Producto p2 = new Producto("Bicicleta biaky", 200.00);
		
		ItemFactura ifa1 = new ItemFactura(p1, 2);
		ItemFactura ifa2 = new ItemFactura(p2, 4);
		 return Arrays.asList(ifa1, ifa2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto p1 = new Producto("Monitor LG 24 pulgadas", 250.00);
		Producto p2 = new Producto("Notebook asus", 500.00);
		Producto p3 = new Producto("Impresora HP color", 400.00);
		Producto p4 = new Producto("Escritorio oficina", 100.00);
		
		ItemFactura ifa1 = new ItemFactura(p1, 2);
		ItemFactura ifa2 = new ItemFactura(p2, 4);
		ItemFactura ifa3 = new ItemFactura(p3, 1);
		ItemFactura ifa4 = new ItemFactura(p4, 4);
		
		 return Arrays.asList(ifa1, ifa2, ifa3, ifa4);
	}
}

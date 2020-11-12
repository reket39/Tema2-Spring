package com.springweb.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springweb.di.app.models.domain.ItemFactura;
import com.springweb.di.app.models.domain.Producto;
import com.springweb.di.app.models.service.IServicio;
import com.springweb.di.app.models.service.MyServicio;
import com.springweb.di.app.models.service.MyServicioComplejo;

@Configuration
public class AppConfig {
	
	@Bean("miServicioSimple")
	public IServicio registrarMyServicio() {
		return new MyServicio();
	}
	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMyServicioComplejo() {
		return new MyServicioComplejo();
	}
	
	@Bean("itemFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("camara sony", 100 );
		Producto producto2 = new Producto("bicicleta kpop", 150 );
		
		ItemFactura linea1 = new ItemFactura(producto1 , 2);
		ItemFactura linea2 = new ItemFactura(producto2 , 4);
		
		return Arrays.asList(linea1, linea2);
		
	}
	@Bean("itemFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor LG CD 24", 250 );
		Producto producto2 = new Producto("Notebook Asus", 300 );
		Producto producto3 = new Producto("Impresora Hp", 30 );
		Producto producto4 = new Producto("Escritorio Oficina", 500 );
		
		ItemFactura linea1 = new ItemFactura(producto1 , 2);
		ItemFactura linea2 = new ItemFactura(producto2 , 4);
		ItemFactura linea3 = new ItemFactura(producto3 , 1);
		ItemFactura linea4 = new ItemFactura(producto4 , 3);
		
		return Arrays.asList(linea1, linea2 , linea3 , linea4);
		
	}

}

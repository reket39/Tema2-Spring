package com.springweb.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springweb.di.app.models.service.IServicio;


@Controller
public class IndexController {
    
	@Autowired
	private IServicio servicio;
	//usamos inyeccion de dependencia e interfaces para el mantenimiento de aplicaciones 
	//en aplicaciones medianas y grandes
	//Maneja peticiones httprequest y logica de negocio
	
	@GetMapping({"/index" ,"" , "/"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
		
	}
}

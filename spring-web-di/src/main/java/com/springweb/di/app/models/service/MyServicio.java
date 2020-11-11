package com.springweb.di.app.models.service;


import org.springframework.stereotype.Service;

@Service("myServicioSimple")
public class MyServicio implements IServicio{

	//bussignes service facade(fachada)
	
	@Override
	public String operacion() {
		// TODO Auto-generated method stub
		return "ejecutando algun proceso importante....";
	}
}

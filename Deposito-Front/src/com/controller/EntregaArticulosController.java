package com.controller;
import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
 
@Controller
public class EntregaArticulosController{
	
	@RequestMapping(value = "/entrega-articulos")
	public ModelAndView entregaArticulos() throws NamingException, JsonProcessingException {
		ModelAndView model = new ModelAndView();
		model.setViewName("administracionEntregaArticulos/entregaArticulos");
		return model;
	}
}
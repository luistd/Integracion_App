package com.controller;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class SolicitudCompraController{
	
	@RequestMapping(value = "/recibir-solicitud-compra")
	@ResponseBody
	public HttpResponse recibirSolicitudCompra(@RequestParam String solicitud) throws URISyntaxException{		
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_ACCEPTED, "Ok");
		System.out.println("Parametro recibido: "+solicitud);
		return response;
	}
}
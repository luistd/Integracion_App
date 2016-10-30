package com.controller;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.facade.implementacion.Facade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vo.SolicitudCompraVO;
 
@Controller
public class SolicitudCompraController{
	
	@RequestMapping(value = "/solicitudes-articulos-pendientes")
	public ModelAndView altaSolicitudCompra() throws NamingException, URISyntaxException, UnsupportedOperationException, IOException {
		ModelAndView model = new ModelAndView();
		model.setViewName("administracionSolicitudCompra/solicitudesArticulosPendientes");
		model.addObject("solicitudesArticulosPendientes", Facade.getInstance().obtenerSolicitudesArticulosPendientes());
		return model;
	}
	
	@RequestMapping(value = "/guardar-solicitud-compra", method = RequestMethod.POST)
	@ResponseBody
	public Boolean guardarSolicitudCompra(@RequestBody SolicitudCompraVO articulo, BindingResult result) throws NamingException {
		try{
			//Facade.getInstance().guardarSolicitudCompra(articulo);
			enviarMensajeFabrica(articulo);			
		}catch(Exception e){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private String enviarMensajeFabrica(SolicitudCompraVO solicitud) throws URISyntaxException, UnsupportedOperationException, IOException{		
		String url = "http://localhost:8080/Fabrica-Front/recibir-solicitud-compra";
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(solicitud);

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("solicitud", jsonInString));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		
		System.out.println("Respuesta recibida de la fabrica : " + response.getStatusLine().getReasonPhrase());
		return response.getStatusLine().getReasonPhrase();
	}
}
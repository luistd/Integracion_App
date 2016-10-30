package com.mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.facade.implementacion.Facade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vo.SolicitudArticulosVO;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "java:/myJmsTest/MyQueue"
        )
})
public class ConsumidorSolicitudArticulos implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
            	System.out.println(String.format("Se recibio una solicitud de articulo: '%s'", textMessage.getText()));
            	
            	ObjectMapper mapper = new ObjectMapper();
            	SolicitudArticulosVO solicitudVO = mapper.readValue(textMessage.getText(), SolicitudArticulosVO.class);
            	Facade.getInstance().guardarSolicitudArticulos(solicitudVO);            	
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
package com.mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.facade.implementacion.Facade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vo.RecepcionCompraVO;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(
                propertyName = "destination",
                propertyValue = "java:/myJmsTest/MyQueue"
        )
})
public class ConsumidorRecepcionCompra implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
            	System.out.println(String.format("Se recibio una Recepcion de Compra: '%s'", textMessage.getText()));
            	
            	ObjectMapper mapper = new ObjectMapper();
            	RecepcionCompraVO recepcionCompraVO = mapper.readValue(textMessage.getText(), RecepcionCompraVO.class);
            	Facade.getInstance().guardarRecepcionCompra(recepcionCompraVO);            	
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
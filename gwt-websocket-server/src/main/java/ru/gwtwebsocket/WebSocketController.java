package ru.gwtwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.ServerAddInfoImpl;
import ru.gwtwebsocket.dto.client.ServerInfoImpl;

import java.util.Date;

/**
 * Created by Kos on 23.07.2015.
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/say")
    public void say(ClientInfoImpl clientInfoImpl) {
        int a = clientInfoImpl.getA();
        int b = clientInfoImpl.getB();
        String problem = a  + "+" + b;
        int result = a + b;
        sendResult(new ServerInfoImpl(problem, result, new ServerAddInfoImpl(new Date())));
    }

    private void sendResult(ServerInfoImpl serverInfoImpl) {
        messagingTemplate.convertAndSend("/topic/info", serverInfoImpl);
    }
}

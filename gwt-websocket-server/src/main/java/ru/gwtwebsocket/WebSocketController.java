package ru.gwtwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.gwtwebsocket.dto.client.ClientInfo;
import ru.gwtwebsocket.dto.client.ServerAddInfo;
import ru.gwtwebsocket.dto.client.ServerInfo;

import java.util.Date;

/**
 * Created by ���������� on 23.07.2015.
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/say")
    public void say(ClientInfo clientInfo) {
        int a = clientInfo.getA();
        int b = clientInfo.getB();
        String problem = a  + "+" + b;
        int result = a + b;
        sendResult(new ServerInfo(problem, result, new ServerAddInfo(new Date())));
    }

    private void sendResult(ServerInfo serverInfo) {
        messagingTemplate.convertAndSend("/topic/info", serverInfo);
    }
}

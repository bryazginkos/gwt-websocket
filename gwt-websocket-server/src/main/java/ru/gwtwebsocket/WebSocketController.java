package ru.gwtwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.gwtwebsocket.json.ClientInfo;
import ru.gwtwebsocket.json.ServerInfo;

/**
 * Created by Константин on 23.07.2015.
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
        sendResult(new ServerInfo(problem, result));
    }

    private void sendResult(ServerInfo serverInfo) {
        messagingTemplate.convertAndSend("/topic/info", serverInfo);
    }
}

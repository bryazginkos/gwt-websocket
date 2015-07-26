package ru.gwtwebsocket.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

import ru.gwtwebsocket.dto.client.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ClientInfoInterface;
import ru.gwtwebsocket.dto.client.json.ServerInfoInterface;
import ru.gwtwebsocket.dto.client.json.converter.Converter;

/**
 * Created by Константин on 25.07.2015.
 */
public class WSComponent {

    private static boolean loadedLib = false;

    private JavaScriptObject stompClient;
    private final Converter converter;

    public WSComponent() {
        super();
        converter = new Converter();
        if (!loadedLib) {
            loadScrpipts();
        }
    }

    public static void loadScrpipts() {
        ScriptInjector.fromUrl("stomp.js").inject();
        ScriptInjector.fromUrl("sockjs-0.3.4.js").inject();
        loadedLib = true;
    }

    private void handleAnswer(String answer) {
        ServerInfoInterface serverInfoInterface = converter.deserialize(answer);
        System.out.println(serverInfoInterface);
    }


    public native void connect() /*-{
        var socket = new SockJS('http://127.0.0.1:8080/websocketservice');
        stompClient = Stomp.over(socket);
        var obj = this;
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/info', function(answer){
                obj.@ru.gwtwebsocket.client.WSComponent::handleAnswer(Ljava/lang/String;)(answer.body);
            });
        });
    }-*/;

    private native void send(String json) /*-{
        stompClient.send("/app/say", {}, json);
    }-*/;

    private String convertToJSON(ClientInfo clientInfo) {
        return converter.serialize(clientInfo);
    }

    public void send(ClientInfo clientInfo) {
        String json = convertToJSON(clientInfo);
        send(json);
    }
}

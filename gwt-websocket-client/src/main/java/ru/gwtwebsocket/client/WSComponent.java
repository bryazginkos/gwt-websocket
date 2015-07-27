package ru.gwtwebsocket.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.json.ServerInfoClient;
import ru.gwtwebsocket.dto.client.json.converter.Converter;

/**
 * Created by Константин on 25.07.2015.
 */
public class WSComponent {

    private static boolean loadedLib = false;

    private JavaScriptObject stompClient;
    private final Converter converter;

    private final String url;
    private final String subscribeUrl;
    private final WSCallback<ServerInfoClient> callback;

    public WSComponent(String url, String subscribeUrl, WSCallback<ServerInfoClient> callback) {
        super();
        this.url = url;
        this.subscribeUrl = subscribeUrl;
        this.callback = callback;
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
        ServerInfoClient serverInfoClient = converter.deserialize(answer);
        callback.onMessage(serverInfoClient);
    }


    public native void connect() /*-{
        var obj = this;
        var socket = new SockJS(obj.@ru.gwtwebsocket.client.WSComponent::url);
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe(obj.@ru.gwtwebsocket.client.WSComponent::subscribeUrl, function(answer){
                obj.@ru.gwtwebsocket.client.WSComponent::handleAnswer(Ljava/lang/String;)(answer.body);
            });
        });
    }-*/;

    private native void send(String json) /*-{
        stompClient.send("/app/say", {}, json);
    }-*/;

    private String convertToJSON(ClientInfoImpl clientInfoImpl) {
        return converter.serialize(clientInfoImpl);
    }

    public void send(ClientInfoImpl clientInfoImpl) {
        String json = convertToJSON(clientInfoImpl);
        send(json);
    }
}

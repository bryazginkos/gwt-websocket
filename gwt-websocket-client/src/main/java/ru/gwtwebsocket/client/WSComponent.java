package ru.gwtwebsocket.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

import ru.gwtwebsocket.dto.client.json.converter.Converter;

/**
 * Created by Константин on 25.07.2015.
 */
public class WSComponent<S, G> {

    private static boolean loadedLib = false;

    private JavaScriptObject stompClient;
    private final Converter<S>  sConverter;
    private final Converter<G>  gConverter;

    private final WSConfiguration<S, G> configuration;

    private final String url;
    private final String subscribeUrl;

    public WSComponent(WSConfiguration<S, G> configuration) {
        super();
        WSConfigurationValidator.validate(configuration);
        this.configuration = configuration;
        this.url = configuration.getUrl();
        this.subscribeUrl = configuration.getSubscribeUrl();
        sConverter = new Converter<>(configuration.getSClass());
        gConverter = new Converter<>(configuration.getGClass());
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
        G ans = gConverter.deserialize(answer);
        configuration.getCallback().onMessage(ans);
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

    private String convertToJSON(S s) {
        return sConverter.serialize(s);
    }

    public void send(S s) {
        String json = convertToJSON(s);
        send(json);
    }
}

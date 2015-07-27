package ru.gwtwebsocket.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.json.ServerInfoClient;

/**
 * Created by ���������� on 24.07.2015.
 */
public class WSModule implements EntryPoint {

    public void onModuleLoad() {
        Button buttonConn = new Button("Connect");
        Button buttonSend = new Button("Send");
        final WSComponent wsComponent = new WSComponent("http://127.0.0.1:8080/websocketservice",
                "/topic/info",
                new WSCallback<ServerInfoClient>() {
                    @Override
                    public void onMessage(ServerInfoClient serverInfo) {
                        String msg = serverInfo.getProblem() + "=" + serverInfo.getResult();
                        msg += " " + serverInfo.getServerAddInfo().getTime();
                        Window.alert(msg);
                    }
                });
        RootPanel.get().add(buttonConn);
        RootPanel.get().add(buttonSend);

        buttonConn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                wsComponent.connect();
            }
        });

        buttonSend.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                wsComponent.send(new ClientInfoImpl(3,2));
            }
        });
    }
}

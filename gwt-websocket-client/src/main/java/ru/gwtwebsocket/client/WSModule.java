package ru.gwtwebsocket.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.json.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ServerInfo;

/**
 * Created by Константин on 24.07.2015.
 */
public class WSModule implements EntryPoint {

    public void onModuleLoad() {
        Button buttonConn = new Button("Connect");
        Button buttonSend = new Button("Send");
        WSConfiguration<ClientInfo, ServerInfo> wsConfiguration = new WSConfiguration<>();
        wsConfiguration.setUrl("http://127.0.0.1:8080/websocketservice");
        wsConfiguration.setGiClass(ServerInfo.class);
        wsConfiguration.setSiClass(ClientInfo.class);
        wsConfiguration.setSubscribeUrl("/topic/info");
        wsConfiguration.setCallback(new WSCallback<ServerInfo>() {
            @Override
            public void onMessage(ServerInfo serverInfo) {
                String msg = serverInfo.getProblem() + "=" + serverInfo.getResult();
                msg += " " + serverInfo.getServerAddInfo().getTime();
                Window.alert(msg);
            }
        });
        final WSComponent<ClientInfo, ServerInfo> wsComponent = new WSComponent<>(wsConfiguration);
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

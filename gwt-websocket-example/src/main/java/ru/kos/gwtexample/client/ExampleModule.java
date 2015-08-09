package ru.kos.gwtexample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ru.gwtwebsocket.dto.client.ClientInfo;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.ServerInfo;
import ru.kosdev.gwtwebsocket.client.WSCallback;
import ru.kosdev.gwtwebsocket.client.WSComponent;
import ru.kosdev.gwtwebsocket.client.WSConfiguration;


/**
 * Created by ���������� on 27.07.2015.
 */
public class ExampleModule implements EntryPoint {
    public void onModuleLoad() {
        Button buttonConn = new Button("Connect");
        Button buttonSend = new Button("Send");

        WSConfiguration<ClientInfo, ServerInfo> wsConfiguration = new WSConfiguration<ClientInfo, ServerInfo>()
                .withUrl("http://127.0.0.1:8080/websocketservice")
                .withSubscribeUrl("/topic/info")
                .withGClass(ServerInfo.class)
                .withSClass(ClientInfo.class)
                .withAutoBeanFactory(GWT.<DtoFactory>create(DtoFactory.class))
                .withCallback(new WSCallback<ServerInfo>() {
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
                wsComponent.send(new ClientInfoImpl(3,2), "/app/say");
            }
        });
    }
}

package ru.kos.gwtexample.client;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import ru.gwtwebsocket.dto.client.ClientInfo;
import ru.gwtwebsocket.dto.client.ServerAddInfo;
import ru.gwtwebsocket.dto.client.ServerInfo;

/**
 * Created by Константин on 26.07.2015.
 */
public interface DtoFactory extends AutoBeanFactory {

    AutoBean<ClientInfo> clientInfoClient();
    AutoBean<ServerInfo> serverInfoClient();
    AutoBean<ServerAddInfo> serverAddInfoClient();

}

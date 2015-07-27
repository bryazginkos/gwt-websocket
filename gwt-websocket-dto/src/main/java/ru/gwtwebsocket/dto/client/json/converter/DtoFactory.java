package ru.gwtwebsocket.dto.client.json.converter;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import ru.gwtwebsocket.dto.client.json.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ServerAddInfoClient;
import ru.gwtwebsocket.dto.client.json.ServerInfo;

/**
 * Created by Константин on 26.07.2015.
 */
public interface DtoFactory extends AutoBeanFactory {

    AutoBean<ClientInfo> clientInfoClient();
    AutoBean<ServerInfo> serverInfoClient();
    AutoBean<ServerAddInfoClient> serverAddInfoClient();

}

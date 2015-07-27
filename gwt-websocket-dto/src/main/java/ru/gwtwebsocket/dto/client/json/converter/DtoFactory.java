package ru.gwtwebsocket.dto.client.json.converter;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import ru.gwtwebsocket.dto.client.json.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ServerAddInfoClient;
import ru.gwtwebsocket.dto.client.json.ServerInfoClient;

/**
 * Created by Константин on 26.07.2015.
 */
public interface DtoFactory extends AutoBeanFactory {

    AutoBean<ClientInfo> clientInfoClient();
    AutoBean<ServerInfoClient> serverInfoClient();
    AutoBean<ServerAddInfoClient> serverAddInfoClient();

}

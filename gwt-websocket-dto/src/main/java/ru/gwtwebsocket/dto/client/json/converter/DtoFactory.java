package ru.gwtwebsocket.dto.client.json.converter;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import ru.gwtwebsocket.dto.client.json.ClientInfoInterface;
import ru.gwtwebsocket.dto.client.json.ServerInfoInterface;

/**
 * Created by Константин on 26.07.2015.
 */
public interface DtoFactory extends AutoBeanFactory {

    AutoBean<ClientInfoInterface> clientInfoInterface();
    AutoBean<ServerInfoInterface> serverInfoInterface();

}

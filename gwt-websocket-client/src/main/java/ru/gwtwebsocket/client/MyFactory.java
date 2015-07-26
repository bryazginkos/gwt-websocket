package ru.gwtwebsocket.client;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import ru.gwtwebsocket.dto.client.ClientInfo;

/**
 * Created by Константин on 26.07.2015.
 */
public interface MyFactory extends AutoBeanFactory {
    AutoBean<ClientInfo> clientInfo();
}

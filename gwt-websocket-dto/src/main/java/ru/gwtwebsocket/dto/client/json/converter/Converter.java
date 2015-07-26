package ru.gwtwebsocket.dto.client.json.converter;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import ru.gwtwebsocket.dto.client.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ClientInfoInterface;
import ru.gwtwebsocket.dto.client.json.ServerInfoInterface;

/**
 * Created by Константин on 26.07.2015.
 */
public class Converter {

    private DtoFactory dtoFactory;

    public Converter() {
        dtoFactory = GWT.create(DtoFactory.class);
    }

    public String serialize(ClientInfo clientInfo) {
        AutoBean<ClientInfoInterface> bean = dtoFactory.create(ClientInfoInterface.class, clientInfo);
        return AutoBeanCodex.encode(bean).getPayload();
    }

    public ServerInfoInterface deserialize(String json) {
        AutoBean<ServerInfoInterface> bean = AutoBeanCodex.decode(dtoFactory, ServerInfoInterface.class, json);
        return bean.as();
    }

}

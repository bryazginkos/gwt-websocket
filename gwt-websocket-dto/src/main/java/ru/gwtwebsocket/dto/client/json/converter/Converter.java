package ru.gwtwebsocket.dto.client.json.converter;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.json.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ServerInfo;

/**
 * Created by Константин on 26.07.2015.
 */
public class Converter {

    private DtoFactory dtoFactory;

    public Converter() {
        dtoFactory = GWT.create(DtoFactory.class);
    }

    public String serialize(ClientInfoImpl clientInfoImpl) {
        AutoBean<ClientInfo> bean = dtoFactory.create(ClientInfo.class, clientInfoImpl);
        return AutoBeanCodex.encode(bean).getPayload();
    }

    public ServerInfo deserialize(String json) {
        AutoBean<ServerInfo> bean = AutoBeanCodex.decode(dtoFactory, ServerInfo.class, json);
        return bean.as();
    }

}

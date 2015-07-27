package ru.gwtwebsocket.dto.client.json.converter;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import ru.gwtwebsocket.dto.client.ClientInfoImpl;
import ru.gwtwebsocket.dto.client.json.ClientInfo;
import ru.gwtwebsocket.dto.client.json.ServerInfoClient;

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

    public ServerInfoClient deserialize(String json) {
        AutoBean<ServerInfoClient> bean = AutoBeanCodex.decode(dtoFactory, ServerInfoClient.class, json);
        return bean.as();
    }

}

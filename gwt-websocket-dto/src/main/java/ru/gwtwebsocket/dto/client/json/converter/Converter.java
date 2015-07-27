package ru.gwtwebsocket.dto.client.json.converter;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

/**
 * Created by Константин on 26.07.2015.
 */
public class Converter<I> {

    private Class<I> iClass;

    private DtoFactory dtoFactory;

    public Converter(Class<I> iClass) {
        dtoFactory = GWT.create(DtoFactory.class); //todo optimize
        this.iClass = iClass;
    }

    public String serialize(I data) {
        AutoBean<I> bean = dtoFactory.create(iClass, data);
        return AutoBeanCodex.encode(bean).getPayload();
    }

    public I deserialize(String json) {
        AutoBean<I> bean = AutoBeanCodex.decode(dtoFactory, iClass, json);
        return bean.as();
    }

}

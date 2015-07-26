package ru.gwtwebsocket.dto.client;

import ru.gwtwebsocket.dto.client.json.ClientInfoClient;

/**
 * Created by Константин on 23.07.2015.
 */
public class ClientInfo implements ClientInfoClient {

    private Integer a;
    private Integer b;

    public ClientInfo(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public ClientInfo() {
    }

    @Override
    public Integer getA() {
        return a;
    }

    @Override
    public void setA(Integer a) {
        this.a = a;
    }

    @Override
    public Integer getB() {
        return b;
    }

    @Override
    public void setB(Integer b) {
        this.b = b;
    }
}

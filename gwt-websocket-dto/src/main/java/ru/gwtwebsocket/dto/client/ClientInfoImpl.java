package ru.gwtwebsocket.dto.client;

/**
 * Created by Kos on 23.07.2015.
 */
public class ClientInfoImpl implements ClientInfo {

    private Integer a;
    private Integer b;

    public ClientInfoImpl(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public ClientInfoImpl() {
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

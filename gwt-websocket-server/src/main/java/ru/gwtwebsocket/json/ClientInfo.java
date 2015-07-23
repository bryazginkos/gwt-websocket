package ru.gwtwebsocket.json;

/**
 * Created by Константин on 23.07.2015.
 */
public class ClientInfo {

    private Integer a;
    private Integer b;

    public ClientInfo(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public ClientInfo() {
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}

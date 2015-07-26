package ru.gwtwebsocket.dto.client.json;

/**
 * Created by Константин on 26.07.2015.
 */
public interface ServerInfoClient {
    public Integer getResult();

    public void setResult(Integer result);

    public String getProblem();

    public void setProblem(String problem);
}

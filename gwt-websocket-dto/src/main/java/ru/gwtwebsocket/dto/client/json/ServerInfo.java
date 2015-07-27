package ru.gwtwebsocket.dto.client.json;

/**
 * Created by Константин on 26.07.2015.
 */
public interface ServerInfo {
    public Integer getResult();

    public void setResult(Integer result);

    public String getProblem();

    public void setProblem(String problem);

    public ServerAddInfoClient getServerAddInfo();

    public void setServerAddInfo(ServerAddInfoClient serverAddInfo);
}

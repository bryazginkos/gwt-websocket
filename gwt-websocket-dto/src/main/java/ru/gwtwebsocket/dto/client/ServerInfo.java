package ru.gwtwebsocket.dto.client;

/**
 * Created by Kos on 26.07.2015.
 */
public interface ServerInfo {
    public Integer getResult();

    public void setResult(Integer result);

    public String getProblem();

    public void setProblem(String problem);

    public ServerAddInfo getServerAddInfo();

    public void setServerAddInfo(ServerAddInfo serverAddInfo);
}

package ru.gwtwebsocket.dto.client;

import ru.gwtwebsocket.dto.client.json.ServerAddInfo;
import ru.gwtwebsocket.dto.client.json.ServerInfo;

/**
 * Created by Константин on 23.07.2015.
 */
public class ServerInfoImpl implements ServerInfo {

    private String problem;
    private Integer result;
    private ServerAddInfo serverAddInfo;

    public ServerInfoImpl(String problem, Integer result, ServerAddInfo serverAddInfo) {
        this.problem = problem;
        this.result = result;
        this.serverAddInfo = serverAddInfo;
    }

    public ServerInfoImpl() {
    }

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String getProblem() {
        return problem;
    }

    @Override
    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public ServerAddInfo getServerAddInfo() {
        return serverAddInfo;
    }

    @Override
    public void setServerAddInfo(ServerAddInfo serverAddInfo) {
        this.serverAddInfo = serverAddInfo;
    }
}

package ru.gwtwebsocket.dto.client;

import ru.gwtwebsocket.dto.client.json.ServerInfoInterface;

/**
 * Created by Константин on 23.07.2015.
 */
public class ServerInfo implements ServerInfoInterface {

    private String problem;
    private Integer result;

    public ServerInfo(String problem, Integer result) {
        this.problem = problem;
        this.result = result;
    }

    public ServerInfo() {
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
}

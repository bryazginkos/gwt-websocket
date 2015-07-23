package ru.gwtwebsocket.json;

/**
 * Created by Константин on 23.07.2015.
 */
public class ServerInfo {

    private String problem;
    private Integer result;

    public ServerInfo(String problem, Integer result) {
        this.problem = problem;
        this.result = result;
    }

    public ServerInfo() {
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}

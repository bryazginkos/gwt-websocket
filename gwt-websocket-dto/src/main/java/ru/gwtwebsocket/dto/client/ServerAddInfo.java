package ru.gwtwebsocket.dto.client;

import ru.gwtwebsocket.dto.client.json.ServerAddInfoClient;

import java.util.Date;

/**
 * Created by Константин on 26.07.2015.
 */
public class ServerAddInfo implements ServerAddInfoClient {
    private Date time;

    public ServerAddInfo(Date time) {
        this.time = time;
    }

    public ServerAddInfo() {
    }

    @Override
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }
}

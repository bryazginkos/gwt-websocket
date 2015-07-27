package ru.gwtwebsocket.dto.client;

import java.util.Date;

/**
 * Created by Константин on 26.07.2015.
 */
public class ServerAddInfoImpl implements ServerAddInfo {
    private Date time;

    public ServerAddInfoImpl(Date time) {
        this.time = time;
    }

    public ServerAddInfoImpl() {
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

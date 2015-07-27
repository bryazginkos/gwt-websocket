package ru.gwtwebsocket.client;

/**
 * Created by Константин on 27.07.2015.
 */
public class WSConfiguration<SI, GI> {

    private Class<SI> siClass;
    private Class<GI> giClass;

    private String url;
    private String subscribeUrl;

    private WSCallback<GI> callback;

    public WSConfiguration() {
    }

    public Class<SI> getSiClass() {
        return siClass;
    }

    public void setSiClass(Class<SI> siClass) {
        this.siClass = siClass;
    }

    public Class<GI> getGiClass() {
        return giClass;
    }

    public void setGiClass(Class<GI> giClass) {
        this.giClass = giClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubscribeUrl() {
        return subscribeUrl;
    }

    public void setSubscribeUrl(String subscribeUrl) {
        this.subscribeUrl = subscribeUrl;
    }

    public WSCallback<GI> getCallback() {
        return callback;
    }

    public void setCallback(WSCallback<GI> callback) {
        this.callback = callback;
    }
}

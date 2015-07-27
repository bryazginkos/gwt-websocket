package ru.gwtwebsocket.client;

/**
 * Created by Константин on 27.07.2015.
 */
public class WSConfiguration<S, G> {

    private Class<S> siClass;
    private Class<G> giClass;

    private String url;
    private String subscribeUrl;

    private WSCallback<G> callback;

    public WSConfiguration() {
    }

    public Class<S> getSiClass() {
        return siClass;
    }

    public void setSiClass(Class<S> siClass) {
        this.siClass = siClass;
    }

    public Class<G> getGiClass() {
        return giClass;
    }

    public void setGiClass(Class<G> giClass) {
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

    public WSCallback<G> getCallback() {
        return callback;
    }

    public void setCallback(WSCallback<G> callback) {
        this.callback = callback;
    }
}

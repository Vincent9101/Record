package com.vincent.mvpcustomadvertisement.data.network.model;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：14:40
 */
// the request body
public class AdvertisementRequest {
    private String url;

    @Override
    public String
    toString() {
        return "AdvertisementRequest{" +
                "url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementRequest that = (AdvertisementRequest) o;

        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    public AdvertisementRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AdvertisementRequest() {
    }
    /**
     * to request for advertisement
     */
}

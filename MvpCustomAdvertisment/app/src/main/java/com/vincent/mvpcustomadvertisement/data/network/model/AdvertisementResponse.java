package com.vincent.mvpcustomadvertisement.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IDEA on 2019/3/17
 * User: Vincent
 * Time：13:49
 */
public class AdvertisementResponse {
    @Expose
    @SerializedName("video")
    private List<ResponseVideo> videoList;
    @Expose
    @SerializedName("img")
    private List<ResponseImage> imgList;

    public List<ResponseVideo> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<ResponseVideo> videoList) {
        this.videoList = videoList;
    }

    public List<ResponseImage> getImgList() {
        return imgList;
    }

    public void setImgList(List<ResponseImage> imgList) {
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return "AdvertisementResponse{" +
                "videoList=" + videoList +
                ", imgList=" + imgList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertisementResponse that = (AdvertisementResponse) o;

        if (videoList != null ? !videoList.equals(that.videoList) : that.videoList != null) return false;
        return imgList != null ? imgList.equals(that.imgList) : that.imgList == null;
    }

    @Override
    public int hashCode() {
        int result = videoList != null ? videoList.hashCode() : 0;
        result = 31 * result + (imgList != null ? imgList.hashCode() : 0);
        return result;
    }


    public static class ResponseImage implements ResponseFile {
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("position")
        private String position;

        @Expose
        @SerializedName("type")
        private String type;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ResponseImage{" +
                    "url='" + url + '\'' +
                    ", position='" + position + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ResponseImage that = (ResponseImage) o;

            if (url != null ? !url.equals(that.url) : that.url != null) return false;
            if (position != null ? !position.equals(that.position) : that.position != null) return false;
            return type != null ? type.equals(that.type) : that.type == null;
        }

        @Override
        public int hashCode() {
            int result = url != null ? url.hashCode() : 0;
            result = 31 * result + (position != null ? position.hashCode() : 0);
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }
    }

    public static class ResponseVideo implements ResponseFile {
        @Expose
        @SerializedName("url")
        private String url;
        @Expose
        @SerializedName("frequency")
        private int frequency;

        @Expose
        @SerializedName("type")
        private String type;

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String
        toString() {
            return "ResponseVideo{" +
                    "url='" + url + '\'' +
                    ", frequency=" + frequency +
                    ", type='" + type + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ResponseVideo that = (ResponseVideo) o;

            if (frequency != that.frequency) return false;
            if (url != null ? !url.equals(that.url) : that.url != null) return false;
            return type != null ? type.equals(that.type) : that.type == null;
        }

        @Override
        public int hashCode() {
            int result = url != null ? url.hashCode() : 0;
            result = 31 * result + frequency;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }
    }

    private static interface ResponseFile {
    }
}

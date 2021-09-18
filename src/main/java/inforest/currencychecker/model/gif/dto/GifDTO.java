package inforest.currencychecker.model.gif.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifDTO {

    private String url;

    private ImageInfoDTO images;

    public ImageInfoDTO getImage() {
        return images;
    }

    public GifDTO() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

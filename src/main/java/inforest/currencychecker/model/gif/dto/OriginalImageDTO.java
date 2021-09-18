package inforest.currencychecker.model.gif.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginalImageDTO {

    private String url;

    public String getUrl() {
        return url;
    }

    public OriginalImageDTO() {}
}

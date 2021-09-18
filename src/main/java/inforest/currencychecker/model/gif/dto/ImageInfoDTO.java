package inforest.currencychecker.model.gif.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageInfoDTO {

    private OriginalImageDTO original;

    public OriginalImageDTO getOriginal() {
        return original;
    }

    public ImageInfoDTO() {}
}

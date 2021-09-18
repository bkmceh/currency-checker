package inforest.currencychecker.model.gif.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperGifInfo {

    @JsonAlias("data")
    private List<GifDTO> data;

    public WrapperGifInfo() {}

    public List<GifDTO> getData() {
        return data;
    }

    public void setData(List<GifDTO> data) {
        this.data = data;
    }
}

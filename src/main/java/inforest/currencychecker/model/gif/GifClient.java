package inforest.currencychecker.model.gif;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import feign.RequestLine;
import inforest.currencychecker.model.gif.dto.WrapperGifInfo;

public interface GifClient {
    @RequestLine("GET")
    JsonValueFormat getJson();

    @RequestLine("GET")
    WrapperGifInfo getGifs();

}




//    @RequestLine("GET /{isbn}")
//    GifInfoDTO getGifs(@Param("isbn") String isbn);

//    @RequestLine("GET")
//    GifInfoDTO getGifs();



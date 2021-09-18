package inforest.currencychecker.service;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import inforest.currencychecker.model.gif.GifClient;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;

@Service
public class GifService {

    @Value("${address.gif}")
    private String URL;

    @Value("${limit.gif}")
    private String gifNum;

    public byte[] getGif(final String searchQuery) {
        byte[] data;
        GifClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(GifClient.class, URL + "&q=" + searchQuery);
        int random = new Random().nextInt(Integer.parseInt(gifNum));
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {
            String gifUrl = client.getGifs().getData().get(random).getImage().getOriginal().getUrl();
            CloseableHttpResponse response = closeableHttpClient.execute(new HttpGet(gifUrl));
            data = response.getEntity().getContent().readAllBytes();
        } catch (IndexOutOfBoundsException | IOException e) {
            throw new ParseException("Unable to get gif");
        }
        return data;
    }
}

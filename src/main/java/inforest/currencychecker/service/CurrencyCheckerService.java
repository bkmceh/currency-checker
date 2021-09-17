package inforest.currencychecker.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyCheckerService {

    private final GifService gifService;

    private final ExchangeService exchangeService;

    @Autowired
    public CurrencyCheckerService(GifService gifService, ExchangeService exchangeService) {
        this.gifService = gifService;
        this.exchangeService = exchangeService;
    }

    public byte[] getSpiderGif() throws IOException {
        byte[] data;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(new HttpGet("https://media0.giphy.com/media/IgtOuXZ6dnuTu/giphy.gif?cid=dccf2bedlbq202c4dj9evqekdnm3866gdc0r6iline0cvniy&rid=giphy.gif&ct=g"));
            data = response.getEntity().getContent().readAllBytes();
        }
        return data;
    }


    public byte[] checkCurrency(final String currencyCode) {
        if (exchangeService.isRateHigher(currencyCode)) {
            return gifService.getGifThroughAPI("rich");
        } else {
            return gifService.getGifThroughAPI("broke");
        }
    }
}

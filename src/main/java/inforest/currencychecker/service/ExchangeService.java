package inforest.currencychecker.service;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import inforest.currencychecker.model.exchange.ExchangeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeService {

    @Value("${address.exchange.latest}")
    private String latestURL;

    @Value("${address.exchange.historical.begin}")
    private String historicalURLBegin;

    @Value("${address.exchange.historical.end}")
    private String historicalURLEnd;

    public boolean isRateHigher(final String code) {
        return getCurrentValue(code) > getYesterdayValue(code);
    }

    private Double getCurrentValue(final String code) {
        ExchangeClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ExchangeClient.class, latestURL + "&base=" + code);
        return client.getValue().getRates().getRUB();
    }

    private Double getYesterdayValue(final String code) {
        String historicalURL = createHistoricalURL();
        ExchangeClient client = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(ExchangeClient.class, historicalURL + "&base=" + code);
        return client.getValue().getRates().getRUB();
    }

    private String createHistoricalURL() {
        LocalDateTime time = LocalDateTime.now().minusDays(1);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(time);
        return historicalURLBegin + date + historicalURLEnd;
    }
}

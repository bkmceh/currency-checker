package inforest.currencychecker.service;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import inforest.currencychecker.model.exchange.ExchangeClient;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ExchangeService {

    @Value("${address.exchange.latest}")
    private String latestURL;

    @Value("${address.exchange.historical}")
    private String historicalURL;

    public boolean isRateHigher(final String code) {
        return getCurrentValue(code) > getYesterdayValue(code);
    }

    private Double getCurrentValue(final String code) {
        try {
            ExchangeClient client = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(ExchangeClient.class, latestURL + "&base=" + code);
            return client.getValue().getRates().getRUB();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "Unable to get currency with code: " + code, e);
        }
    }

    private Double getYesterdayValue(final String code) {
        String historicalURL = createHistoricalURL();
        try {
            ExchangeClient client = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new GsonEncoder())
                    .decoder(new GsonDecoder())
                    .target(ExchangeClient.class, historicalURL + "&base=" + code);
            return client.getValue().getRates().getRUB();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "Unable to get currency with code: " + code, e);
        }
    }

    private String createHistoricalURL() {
        LocalDateTime time = LocalDateTime.now().minusDays(1);
        String date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(time);
        return String.format(historicalURL, date);
    }
}

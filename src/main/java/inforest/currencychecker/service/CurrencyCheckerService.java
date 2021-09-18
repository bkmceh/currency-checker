package inforest.currencychecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyCheckerService {

    private final GifService gifService;

    private final ExchangeService exchangeService;

    @Value("${currency.code}")
    private String currencyCodeDefault;

    @Autowired
    public CurrencyCheckerService(GifService gifService, ExchangeService exchangeService) {
        this.gifService = gifService;
        this.exchangeService = exchangeService;
    }

    public byte[] checkCurrency(final String currencyCode) {
        if (currencyCode == null) {
            return exchangeService.isRateHigher(currencyCodeDefault)
                    ? gifService.getGif("rich")
                    : gifService.getGif("broke");
        } else {
            return exchangeService.isRateHigher(currencyCode)
                    ? gifService.getGif("rich")
                    : gifService.getGif("broke");
        }
    }
}

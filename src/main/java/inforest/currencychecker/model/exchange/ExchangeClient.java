package inforest.currencychecker.model.exchange;

import feign.RequestLine;
import inforest.currencychecker.model.exchange.dto.WrapperExchangeInfo;

public interface ExchangeClient {
    @RequestLine("GET")
    WrapperExchangeInfo getValue();
}


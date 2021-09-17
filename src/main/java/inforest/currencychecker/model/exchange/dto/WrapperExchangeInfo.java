package inforest.currencychecker.model.exchange.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WrapperExchangeInfo {

    private RatesInfo rates;

    public WrapperExchangeInfo() {}

    public RatesInfo getRates() {
        return rates;
    }
}

package inforest.currencychecker.model.exchange.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesInfo {

    private Double RUB;

    public RatesInfo() {}

    public Double getRUB() {
        return RUB;
    }
}

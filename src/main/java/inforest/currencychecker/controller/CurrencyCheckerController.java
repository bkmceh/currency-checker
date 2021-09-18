package inforest.currencychecker.controller;

import inforest.currencychecker.service.CurrencyCheckerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class CurrencyCheckerController {

    private final CurrencyCheckerService currencyCheckerService;

    public CurrencyCheckerController(CurrencyCheckerService currencyCheckerService) {
        this.currencyCheckerService = currencyCheckerService;
    }

    @GetMapping(value = {"/{code}"},
            produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getResult(@PathVariable("code") String code) {
        return currencyCheckerService.checkCurrency(code);
    }

    @GetMapping(value = "", produces = MediaType.IMAGE_GIF_VALUE)
    public byte[] getResult() {
        return currencyCheckerService.checkCurrency(null);
    }
}

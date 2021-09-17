package inforest.currencychecker.controller;

import inforest.currencychecker.service.CurrencyCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class CurrencyCheckerController {

    @Value("${currency.code}")
    private String currencyCode;

    private final CurrencyCheckerService currencyCheckerService;

    @Autowired
    public CurrencyCheckerController(CurrencyCheckerService currencyCheckerService) {
        this.currencyCheckerService = currencyCheckerService;
    }

    @GetMapping(value ={ "", "/{code}"},
            produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getResult(@PathVariable(required = false) String code) {
        return code == null
                ? ResponseEntity.ok(currencyCheckerService.checkCurrency(currencyCode))
                : ResponseEntity.ok(currencyCheckerService.checkCurrency(code));
    }
}

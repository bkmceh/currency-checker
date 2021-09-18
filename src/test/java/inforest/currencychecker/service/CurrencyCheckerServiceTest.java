package inforest.currencychecker.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Configuration
@RunWith(SpringRunner.class)
public class CurrencyCheckerServiceTest {

    @MockBean
    private ExchangeService exchangeService;

    @MockBean
    private GifService gifService;

    @Test
    public void checkGifRichWhenValueIsHigherThanYesterday() {
        CurrencyCheckerService service = new CurrencyCheckerService(gifService, exchangeService);
        Mockito.when(exchangeService.isRateHigher(ArgumentMatchers.anyString())).thenReturn(true);
        service.checkCurrency("code");
        Mockito.verify(gifService, Mockito.times(1)).getGif("rich");
    }

    @Test
    public void checkGifBrokeWhenValueIsLowerThanYesterday() {
        CurrencyCheckerService service = new CurrencyCheckerService(gifService, exchangeService);
        Mockito.when(exchangeService.isRateHigher(ArgumentMatchers.anyString())).thenReturn(false);
        service.checkCurrency("code");
        Mockito.verify(gifService, Mockito.times(1)).getGif("broke");
    }
}

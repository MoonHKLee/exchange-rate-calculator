package lee.moonhyuk.exchangeratecalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateServiceTest {

    private final RateApiCallService rateApiCallService = new DummyRateApiCall();
    private final ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl(rateApiCallService);

    @Test
    void getExchangeRate() {
        //when
        String exchangeRate = exchangeRateService.getExchangeRate("USDKRW");

        //then
        assertThat(exchangeRate).isEqualTo("1,234.56");
    }
}
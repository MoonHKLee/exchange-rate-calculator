package lee.moonhyuk.exchangeratecalculator;

import org.springframework.http.ResponseEntity;


public interface RateApiCallService {
    ResponseEntity<String> getExchangeRateFromApi(String exchangeRateKey);
}

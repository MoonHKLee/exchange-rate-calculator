package lee.moonhyuk.exchangeratecalculator.service;

import org.springframework.http.ResponseEntity;


public interface RateApiCallService {
    ResponseEntity<String> getExchangeRateFromApi(String exchangeRateKey);
}

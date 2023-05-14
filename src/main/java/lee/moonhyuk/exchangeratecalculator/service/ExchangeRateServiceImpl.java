package lee.moonhyuk.exchangeratecalculator.service;

import lee.moonhyuk.exchangeratecalculator.util.ExchangeRateFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final RateApiCallService rateApiCallServiceImpl;

    public String getExchangeRate(String exchangeRateKey) {
        ResponseEntity<String> response = rateApiCallServiceImpl.getExchangeRateFromApi(exchangeRateKey);

        if (response.getStatusCode().is2xxSuccessful()) {
            String responseData = response.getBody();
            ExchangeRateFormatter rateFormatter = new ExchangeRateFormatter(responseData);
            return rateFormatter.getExchangeRate(exchangeRateKey);
        }
        return "API 호출에 실패했습니다.";
    }
}
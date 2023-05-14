package lee.moonhyuk.exchangeratecalculator;

import org.springframework.http.ResponseEntity;

public class DummyRateApiCall implements RateApiCallService {
    @Override
    public ResponseEntity<String> getExchangeRateFromApi(String exchangeRateKey) {
        String json =
                """
                {
                    "success" : true,
                    "quotes" : {
                        "USDKRW" : 1234.5678,
                        "USDJPY" : 2345.6789,
                        "USDPHP" : 3456.7890
                    }
                }
                """;
        return ResponseEntity.ok(json);
    }
}

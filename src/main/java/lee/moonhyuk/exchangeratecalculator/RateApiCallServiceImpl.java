package lee.moonhyuk.exchangeratecalculator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class RateApiCallServiceImpl implements RateApiCallService {

    private final RestTemplate restTemplate;

    @Value("${rate.apiUrl}")
    private final String apiUrl;

    @Value("${rate.accessKey}")
    private final String accessKey;

    @Override
    public ResponseEntity<String> getExchangeRateFromApi(String exchangeRateKey) {
        return restTemplate.exchange(apiUrl + "?access_key=" + accessKey,
                HttpMethod.GET, null, String.class);
    }
}

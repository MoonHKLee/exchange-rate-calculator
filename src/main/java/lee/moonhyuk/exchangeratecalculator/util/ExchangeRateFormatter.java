package lee.moonhyuk.exchangeratecalculator.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ExchangeRateFormatter {
    private final String json;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ExchangeRateFormatter(String json) {
        this.json = json;
    }

    public String getExchangeRate(String key) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            double exchangeRate = jsonNode.get("quotes").get(key).asDouble();
            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            return decimalFormat.format(exchangeRate);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("존재하지 않는 값입니다.");
        }
    }
}

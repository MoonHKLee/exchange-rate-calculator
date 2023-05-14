package lee.moonhyuk.exchangeratecalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExchangeRateFormatterTest {

    @Test
    @DisplayName("가져온 환율 정보를 천단위마다 쉼표, 소수점 둘째자리까지 표시한다.")
    void test() {
        //given
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

        //when
        ExchangeRateFormatter exchangeRateFormatter = new ExchangeRateFormatter(json);
        String exchangeRate = exchangeRateFormatter.getExchangeRate("USDKRW");

        //then
        assertThat(exchangeRate).isEqualTo("1,234.56");
    }
}

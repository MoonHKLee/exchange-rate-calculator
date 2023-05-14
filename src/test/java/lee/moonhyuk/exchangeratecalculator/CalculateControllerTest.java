package lee.moonhyuk.exchangeratecalculator;

import lee.moonhyuk.exchangeratecalculator.service.ExchangeRateServiceImpl;
import lee.moonhyuk.exchangeratecalculator.ui.CalculateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@WebMvcTest(CalculateController.class)
class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeRateServiceImpl exchangeRateService;

    @Test
    void getIndexPage_shouldReturnIndexPageWithExchangeRate() throws Exception {
        // Given
        String expectedExchangeRate = "1,234.56";
        String exchangeRateKey = "USDKRW";
        when(exchangeRateService.getExchangeRate(exchangeRateKey)).thenReturn(expectedExchangeRate);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/").param("exchangeRateKey", exchangeRateKey))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attribute(exchangeRateKey, "1,234.56"));

        verify(exchangeRateService).getExchangeRate(exchangeRateKey);
    }
}

package lee.moonhyuk.exchangeratecalculator.ui;

import lee.moonhyuk.exchangeratecalculator.service.ExchangeRateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CalculateController {

    private final ExchangeRateServiceImpl exchangeRateService;
    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam(value = "exchangeRateKey", defaultValue = "USDKRW") String exchangeRateKey) {
        String result = exchangeRateService.getExchangeRate(exchangeRateKey);
        model.addAttribute("rate", result + " KRW/USD");
        return "index";
    }

    @GetMapping("/exchangeRate")
    @ResponseBody
    public String getExchangeRate(@RequestParam(value = "exchangeRateKey", defaultValue = "USDKRW") String exchangeRateKey) {
        return exchangeRateService.getExchangeRate(exchangeRateKey);
    }

}

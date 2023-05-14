package lee.moonhyuk.exchangeratecalculator.ui;

import lee.moonhyuk.exchangeratecalculator.service.ExchangeRateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CalculateController {

    private final ExchangeRateServiceImpl exchangeRateService;
    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam("exchangeRateKey") String exchangeRateKey) {
        String result = exchangeRateService.getExchangeRate(exchangeRateKey);
        model.addAttribute("USDKRW", result);
        return "index";
    }

}

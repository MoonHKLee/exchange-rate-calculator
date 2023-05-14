package lee.moonhyuk.exchangeratecalculator.ui;

import lee.moonhyuk.exchangeratecalculator.ExchangeRateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CalculateController {

    private final ExchangeRateServiceImpl exchangeRateService;
    @GetMapping("/")
    public String getIndexPage(Model model) {
        String usdkrw = exchangeRateService.getExchangeRate("USDKRW");
        model.addAttribute("USDKRW", usdkrw);
        return "index";
    }

}

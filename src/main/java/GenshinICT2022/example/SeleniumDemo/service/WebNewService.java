package GenshinICT2022.example.SeleniumDemo.service;

import GenshinICT2022.example.SeleniumDemo.crawler.VnExpressCrawler;
import GenshinICT2022.example.SeleniumDemo.model.VnExpressNew;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@NoArgsConstructor
public class WebNewService {

    private final ScheduledExecutorService scheduler = Executors
            .newScheduledThreadPool(1);

    @Getter
    private List<VnExpressNew> newList = new ArrayList<>();

    @PostConstruct
    private void init() {
        scheduler.scheduleAtFixedRate(
                () -> newList = VnExpressCrawler.crawSearchPage("https://e.vnexpress.net/search?q=Hoi+An"), 0, 1, TimeUnit.DAYS);
    }
}

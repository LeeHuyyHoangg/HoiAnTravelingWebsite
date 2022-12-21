package GenshinICT2022.example.SeleniumDemo;

import GenshinICT2022.example.SeleniumDemo.crawler.VnExpressCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SeleniumDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","H:\\School\\WebProgramming\\SeleniumDemo\\src\\main\\resources\\chromedriver.exe");

		SpringApplication.run(SeleniumDemoApplication.class, args);

//		VnExpressCrawler.crawSearchPage("https://e.vnexpress.net/search?q=Hoi+An");
	}

}

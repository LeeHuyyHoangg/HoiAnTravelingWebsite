package GenshinICT2022.example.SeleniumDemo.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FacebookCrawler {
    private static String classBaiVietFacebook = "div[class='du4w35lb k4urcfbm l9j0dhe7 sjgh65i0']";
    private static String classTextTrongBaiFacebook = "div[class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql ii04i59q']";
    private static String classImageTrongBaiFacebook = "div[class='pmk7jnqg kr520xx4']";

    public static void crawPublicGroup(String link) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(link);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(classBaiVietFacebook)));
        System.out.println(driver.getTitle());

        ((JavascriptExecutor)driver).executeScript("scroll(0, 750);");

        Thread.sleep(2000);

        List<WebElement> elementList = driver.findElements(By.cssSelector(classBaiVietFacebook));
        for (WebElement element: elementList) {
            System.out.println("Info:");
            System.out.println(element);
            List<WebElement> textList = element.findElements(By.cssSelector(classTextTrongBaiFacebook));
            for(WebElement text : textList){
                text.findElements(By.cssSelector("div")).forEach(c -> System.out.println(c.getText()));
            }

            System.out.println("Images Link");
            List<WebElement> images = element.findElements(By.cssSelector(classImageTrongBaiFacebook));

            for (WebElement image: images) {
                System.out.println(image.findElement(By.cssSelector("img")).getAttribute("src"));
            }
            System.out.println();
        }
    }
}

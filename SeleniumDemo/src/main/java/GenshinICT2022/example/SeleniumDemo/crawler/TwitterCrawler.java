package GenshinICT2022.example.SeleniumDemo.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TwitterCrawler {

    private static String classBaiVietTwitter = "div[class='css-1dbjc4n r-16y2uox r-1wbh5a2 r-1ny4l3l']";
    private static String classTextTrongBaiTwitter = "span[class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']";
    private static String classImageTrongBaiTwitter = "img[alt='Image']";

    public static void crawPerson(String link){
        try {
            WebDriver driver = new ChromeDriver();
            driver.get(link);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(classBaiVietTwitter)));
            System.out.println(driver.getTitle());

            List<WebElement> elementList = driver.findElements(By.cssSelector(classBaiVietTwitter));
            for (WebElement element : elementList) {
                System.out.println("Info:");
                System.out.println(element);
                List<WebElement> textList = element.findElements(By.cssSelector(classTextTrongBaiTwitter));
                for (WebElement text : textList) {
                    System.out.println(text.getText());
                }

                System.out.println("Images Link");
                List<WebElement> images = element.findElements(By.cssSelector(classImageTrongBaiTwitter));
                for (WebElement image : images) {
                    System.out.println(image.getAttribute("src"));
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

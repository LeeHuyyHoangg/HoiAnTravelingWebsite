package GenshinICT2022.example.SeleniumDemo.crawler;

import GenshinICT2022.example.SeleniumDemo.model.VnExpressNew;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VnExpressCrawler {
    private static String classNewVnExpress = "div[class='item_list_folder']";
    private static String classTitleVnExpress = "h4[class='title_news_site']";
    private static String classDescriptionVnExpress = "div[class='lead_news_site']";
    private static String classTimeVnExpress = "div[class='timer_post']";
    private static SimpleDateFormat timeFormatVnExpress = new SimpleDateFormat("MMMM d, yyyy | KK:mm a");

    public static List<VnExpressNew> crawSearchPage(String link){
        try {
            ChromeDriver driver = new ChromeDriver();
            driver.get(link);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(classNewVnExpress)));
            System.out.println(driver.getTitle());

            List<VnExpressNew> result = new ArrayList<>();
            List<WebElement> elementList = driver.findElements(By.cssSelector(classNewVnExpress));
            for (WebElement element : elementList) {
                try {
                    VnExpressNew news = new VnExpressNew();

                    //link hình ảnh
                    news.setImageLink(element.findElement(By.cssSelector("img")).getAttribute("src"));

                    //tiêu đề bài viết
                    news.setTitle(element.findElement(By.cssSelector(classTitleVnExpress)).getText());

                    //mô tả bài viết
                    news.setDescription(element.findElement(By.cssSelector(classDescriptionVnExpress)).getText());

                    //link bài viết
                    news.setLink(element.findElement(By.cssSelector(classTitleVnExpress)).findElement(By.cssSelector("a")).getAttribute("href"));

                    //thời gian bài viết
                    String date = element.findElement(By.cssSelector(classTimeVnExpress)).getText();
                    news.setDate(timeFormatVnExpress.parse(date));

                    System.out.println(new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(news));
                    result.add(news);
                } catch(Exception exception) {
                    exception.printStackTrace();
                }

            }

            driver.close();
            return result;
        } catch(Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

//    private static Date vnExpressDateToDate(String vnExpressDate) throws ParseException {
//        Date date = timeFormatVnExpress.parse(vnExpressDate);
//        return date;
//    }
}

package Section13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenlinksBasic {

    public static void main(String[] args) throws MalformedURLException, IOException {

        WebDriver driver = new ChromeDriver();
        // broken URL
        // Step 1 - IS to get all urls tied up to the links using Selenium
        // Java methods will call URL's and gets you the status code
        // if status code >400 then that url is not working-> link which tied to url is
        // broken
        // a[href*="soapui"]'
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String url= driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCode = conn.getResponseCode();
        System.out.println(respCode);
        driver.quit();
    }
}
package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendars {

    static String url = "https://www.path2usa.com/travel-companion";

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(5000);

        // Scroll the Page

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1200)");

        // Click on the Date field

        Thread.sleep(3000);

        WebElement Date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));

        // js.executeScript("arguments[0].scrollIntoView(true);", Date);

        Date.click();

        // WebElement month =
        // driver.findElement(By.xpath("//div[@class='flatpickr-month']"));

        while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("August"))

        {

            Thread.sleep(2000);

            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();

        }

        int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

        for (int i = 0; i < count; i++)

        {

            Thread.sleep(2000);

            String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

            if (text.equalsIgnoreCase("26"))

            {

                driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();

                System.out.println("The select day is:" + text);

                break;

            }

        }

        String date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");

        System.out.println("The select date is:" + date);

    }

}
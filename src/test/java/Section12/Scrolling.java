package Section12;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Scrolling {

    static int sum;

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000L);

        // js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,500)");

        List<WebElement> numbers = driver.findElements(By.xpath("//table[@id='product']//td[4]"));

        for (int i = 0; i < numbers.size(); i++)

        {

            System.out.println(numbers.get(i).getText());

            sum = sum + Integer.parseInt(numbers.get(i).getText());
        }

        System.out.println(sum);

        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText());

        Assert.assertEquals(sum, total);

    }

}
package Section7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class End2End {
  
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();

        // Open the URL in the browser
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Select trip type
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Select origin station
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // Select destination station
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))).click();

        // Select date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        // Check if it is disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("It's disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        // Click on Senior Citizen Discount checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Select the number of passengers
        driver.findElement(By.id("divpaxinfo")).click();
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Verify the number of passengers
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Click on the Search button
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // Close the browser
        driver.quit();
    }
}
package Section9;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.quit();
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (WebElement product : products) {
            String[] name = product.getText().split("-");
            String formattedName = name[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                product.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])")).click();
            }
        }
    }
}

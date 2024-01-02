package Section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class IdentifyingLinks {

    public static void main(String[] args) throws InterruptedException {

        // Create a new WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("http://qaclickacademy.com/practice.php");

        // 1. Count the number of links on the page
        int numberOfLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("Number of links on the page: " + numberOfLinks);

        // 2. Count the number of links in the footer section
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int numberOfFooterLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Number of links in the footer section: " + numberOfFooterLinks);

        // 3. Count the number of links in the first column of the footer section
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int numberOfColumnLinks = columnDriver.findElements(By.tagName("a")).size();
        System.out.println("Number of links in the first column of the footer section: " + numberOfColumnLinks);

        // 4. Click on each link in the first column and check if the pages are opening
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }

        // Switch to each opened tab and print the title of the page
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }

        // Close the WebDriver instance
        driver.quit();
    }

}

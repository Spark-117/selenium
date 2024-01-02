package Liberimap;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wasAniceTry {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://liberimap.com/");
        // driver.manage().window().maximize();

        /*
         * String clickOnAccept = Keys.chord(Keys.CONTROL, Keys.ENTER);
         * driver.findElement(By.xpath("//button[normalize-space()='Accept']")).sendKeys
         * (clickOnAccept);
         * System.out.println("Accepted");
         * // driver.switchTo().alert().accept();
         * 
         * WebDriver newWindow = new ChromeDriver();
         * 
         * // Navigate to the same webpage with the automatic alert
         * newWindow.get("https://liberimap.com/");
         * 
         * String clickOnDecline = Keys.chord(Keys.CONTROL, Keys.ENTER);
         * newWindow.findElement(By.xpath("//button[normalize-space()='Decline']")).
         * sendKeys(clickOnDecline);
         * System.out.println("Declined");
         * 
         * // Close the new window
         * newWindow.quit();
         * 
         * // Locator of the word slider
         * By wordElementLocator = By.cssSelector("#slider-container");
         * 
         * // Loop to continuously capture the text of each word
         * int wordCount= 0;
         * while (wordCount < 5) {
         * // Get the list of all elements that represent words on the slider
         * List<WebElement> wordElements = driver.findElements(wordElementLocator);
         * 
         * wordElements.stream()
         * .map(WebElement::getText)
         * .forEach(wordText -> System.out.println("Word: " + wordText));
         * 
         * wordCount += wordElements.size();
         * // Wait for a certain period before checking for words again
         * try {
         * Thread.sleep(4500);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }
         */

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,4000)");

        WebElement faqSection = driver.findElement(By.xpath("//div[@class='w-full max-w-3xl mt-10']"));

        List<WebElement> spørsmåls = faqSection.findElements(By.xpath("//div[@class='p-3']"));

        List<WebElement> answerElements = new ArrayList<>();

        spørsmåls.forEach(spørsmål -> {

            WebElement spørsmålButtons = spørsmål.findElement(By.cssSelector(".faq-caret"));

            Actions actions = new Actions(driver);
            actions.moveToElement(spørsmålButtons).click().perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(".//div[contains(@class, 'faq-answer-container')]//p[contains(@class, 'text-dc-500')]")));
            
                answerElements.add(answerElement);

            System.out.println("Answer: " + answerElement.getText());  

        });

    }

}

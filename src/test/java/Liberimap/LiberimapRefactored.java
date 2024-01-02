package Liberimap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class LiberimapRefactored {

    private static final Duration IMPLICIT_WAIT_DURATION = Duration.ofSeconds(5);
    private static final long WORD_SLIDER_WAIT_TIME = 4500;

    private final WebDriver driver;

    public LiberimapRefactored() {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_DURATION);
    }

    public static void main(String[] args) {
        LiberimapRefactored liberimap = new LiberimapRefactored();
        liberimap.acceptCookies();
        liberimap.handleWordSlider();
        liberimap.scrollDown();
        liberimap.processFAQs();
        liberimap.contactUs();
        liberimap.quit();
    }

    private void acceptCookies() {
        driver.get("https://liberimap.com/");
        String clickOnAccept = Keys.chord(Keys.CONTROL, Keys.ENTER);
        driver.findElement(By.xpath("//button[normalize-space()='Accept']")).sendKeys(clickOnAccept);
        System.out.println("Accepted");
    }

    private void handleWordSlider() {
        By wordElementLocator = By.cssSelector("#slider-container");
        int wordCount = 0;
        while (wordCount < 5) {
            List<WebElement> wordElements = driver.findElements(wordElementLocator);
            wordElements.stream().map(WebElement::getText)
                    .forEach(wordText -> System.out.println("Word: " + wordText));
            wordCount += wordElements.size();
            sleep(WORD_SLIDER_WAIT_TIME);
        }
    }

    private void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
    }

    private void processFAQs() {
        WebElement faqSection = driver.findElement(By.xpath("//div[@class='w-full max-w-3xl mt-10']"));
        List<WebElement> questionElements = faqSection.findElements(By.xpath("//div[@class='p-3']"));

        questionElements.forEach(questionElement -> {
            WebElement questionButton = questionElement.findElement(By.cssSelector(".faq-caret"));
            Actions actions = new Actions(driver);
            actions.moveToElement(questionButton).click().perform();

            WebElement textElement = questionElement.findElement(By.xpath(".//p[contains(@class, 'text-dc-500')]"));
            System.out.println("Text: " + textElement.getText());
        });
    }

    private void contactUs() {

        driver.findElement(By.xpath("//a[normalize-space()='Kontakt oss']")).click();

        WebDriver newWindow = new ChromeDriver();
        newWindow.get("https://liberimap.com/contact");
        
        driver.findElement(By.xpath("//input[@placeholder='Navn']")).sendKeys("David Silva");
        driver.findElement(By.xpath("(//input[@id='email_address'])")).sendKeys("qaspark.117@gmail.com");
        driver.findElement(By.cssSelector("form[id='form'] textarea[placeholder='Din melding']")).sendKeys("Hello (=");
        
    }


    private void quit() {
        driver.quit();
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package Liberimap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LiberimapWithErrorPage {

    private static final Duration IMPLICIT_WAIT_DURATION = Duration.ofSeconds(5);
    private final WebDriver driver;
    private static final int WORD_SLIDER_WAIT_TIME = 4500;

    public LiberimapWithErrorPage() {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_DURATION);
    }

    public static void main(String[] args) throws InterruptedException {
        LiberimapWithErrorPage liberimap = new LiberimapWithErrorPage();
        liberimap.acceptCookies();
        liberimap.handleWordSlider();
        liberimap.scrollDown();
        liberimap.processFAQs();
        liberimap.invester();
        liberimap.query();
        liberimap.aboutus();
        liberimap.contactUs();
        liberimap.privacy();
        liberimap.english();
        liberimap.Linkedin();
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
            System.out.println("FAQ answers: " + textElement.getText());
        });
    }

    private void invester() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Invester her!']")).click();
        driver.findElement(By.id("email-input")).sendKeys("MrViking@email.com");
        driver.findElement(By.id("acceptance")).click();
        WebElement youTubeVideo = driver.findElement(
                By.xpath("(//div[@class='fade-down flex flex-col items-center mt-10 p-2 animate-fadeDown'])[1]"));
        assertTrue(youTubeVideo.isDisplayed());
        System.out.println("is displayed");
        Thread.sleep(2000);
    }

    private void query() throws InterruptedException {
        WebElement querySection = driver.findElement(By.xpath("(//div[@id='faq'])"));
        List<WebElement> questions = querySection.findElements(By.xpath("(//div[@class='faq-question-container'])"));

        questions.forEach(question -> {
            WebElement questionButton = question.findElement(By.cssSelector(".faq-caret"));
            Actions actions = new Actions(driver);
            actions.moveToElement(questionButton).click().perform();

            WebElement answerQuery = question.findElement(By.xpath(".//div[contains(@class, 'faq-answer')]//p[contains(@class, 'text-dc-500')]"));
            System.out.println("Invest answers: " + answerQuery.getText());
        });
    }

    private void aboutus() throws InterruptedException {
        driver.findElement(By.cssSelector("div[class='flex flex-row'] div:nth-child(1) a:nth-child(1)")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
        Thread.sleep(2000);
    }

    private void contactUs() throws InterruptedException {

        driver.findElement(By.xpath("//a[normalize-space()='Kontakt oss']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Navn']")).sendKeys("David Silva");
        driver.findElement(By.xpath("(//input[@id='email_address'])")).sendKeys("qaspark.117@gmail.com");
        driver.findElement(By.cssSelector("form[id='form'] textarea[placeholder='Din melding']")).sendKeys("Hello (=");
        Thread.sleep(2000);

    }

    private void privacy() throws InterruptedException{

        driver.findElement(By.linkText("Personvern")).click();

        WebElement privacySection = driver.findElement(By.xpath("(//div[@class='w-full max-w-3xl mt-10'])[1]"));
        List<WebElement> privacyQuestions = privacySection.findElements(By.xpath("(//div[@class='privacy-question-container'])"));

        privacyQuestions.forEach(question -> {
            WebElement questionButton = question.findElement(By.cssSelector(".privacy-caret"));
            Actions actions = new Actions(driver);
            actions.moveToElement(questionButton).click().perform();

            WebElement privacyAnswer = question.findElement(By.xpath(".//div[contains(@class, 'flex text-lg font-medium text-start')]"));
            System.out.println("Privacy answer: " + privacyAnswer.getText());
        });

    }

    private void english() throws InterruptedException {

        WebElement languageButton = driver.findElement(By.xpath(
                "((//button[@class='flex items-center gap-1 w-full lg:w-auto lg:px-3 py-2 text-dc-500 hover:text-gray-900'])[1])"));
        Actions actions = new Actions(driver);
        actions.moveToElement(languageButton).click().perform();

        Thread.sleep(500);
        driver.findElement(By.xpath("//a[normalize-space()='English']")).click();
        Thread.sleep(2000);
    }

    private void Linkedin() throws InterruptedException {

        WebElement linkedInButton = driver
                .findElement(By.xpath("//a[@href='https://www.linkedin.com/company/liberimap']"));
        linkedInButton.click();
        Thread.sleep(2000);
    }

    private void quit() {
        driver.quit();
    }

    private void sleep(int wordSliderWaitTime) {
        try {
            TimeUnit.MILLISECONDS.sleep(WORD_SLIDER_WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
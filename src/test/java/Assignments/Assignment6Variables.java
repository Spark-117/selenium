package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6Variables {
    
    
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://qaclickacademy.com/practice.php");
        //driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]/input")).click();

        String optionText = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

        Select abc = new Select(dropdown);

        abc.selectByVisibleText(optionText);
        
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(optionText);

        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

        String AlertText = driver.switchTo().alert().getText();

        if (AlertText.contains(optionText)) {

            System.out.println("Alert message successfully displayed");
        }
            else {

                System.out.println("Alert message not displayed");

            }
    }    
}

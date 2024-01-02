package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1Checkbox {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        driver.findElement(By.id("checkBoxOption1")).click();

        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); // Should Print True

        driver.findElement(By.id("checkBoxOption1")).click();

        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected()); // Should Print false

    }
}

// How to get the Count of number of check boxes present in the page

// driver.findElements(By.cssSelector("input[value='checkbox']")).size();
package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8AutoDropdown {

     public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement drop = driver.findElement(By.id("autocomplete"));

        drop.sendKeys("Por");

        Thread.sleep(2000);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            
        System.out.println(drop.getAttribute("value"));
        
        driver.close();
    } 
}
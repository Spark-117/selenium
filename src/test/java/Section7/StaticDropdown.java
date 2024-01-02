package Section7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
    public class StaticDropdown {

        public static void main(String[] args) throws InterruptedException{

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
            
            driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
            Thread.sleep(1000);
            System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
            driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
            System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());

            driver.findElements(By.cssSelector("input[type='checkbox']")).size();

        }
    }
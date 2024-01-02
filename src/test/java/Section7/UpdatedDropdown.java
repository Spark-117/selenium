package Section7;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException

    {

        // System.setProperty("webdriver.chrome.driver","./chromedriver87/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("#ctl00_mainContent_chk_friendsandfamily")).click();

        System.out.println("The type of passengers selected is - "
                + driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).getAttribute("value"));

        // OriginStation

        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

        driver.findElement(By.cssSelector("a[value='DEL']")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']"))
                .getAttribute("value"));

        // Destination

        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();

        driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"))
                .getAttribute("value"));

        Thread.sleep(3000);

        while (!driver.findElement(By.cssSelector("div[class='ui-datepicker-title']")).getText()
                .contains("January 2022"))

        {

            // driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

            driver.findElement(By.xpath(
                    "//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']"))
                    .click();

            System.out.println(
                    driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']"))
                            .getText());

        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));

        int count = dates.size();

        for (int i = 0; i < count; i++)

        {

            String txt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i)
                    .getText();

            if (txt.equalsIgnoreCase("18"))

            {

                driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).click();

                System.out.println(txt);

                break;

            }

        }

        driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();

        Thread.sleep(4000);

        // Selection of Adults

        for (int i = 0; i < 3; i++)

        {

            driver.findElement(By.xpath(".//*[@id='hrefIncAdt']")).click();

        }

        int j = 0;

        for (j = 0; j < 3; j++)

        {

            driver.findElement(By.xpath(".//*[@id='hrefIncChd']")).click();

        }

        if (j == 3)

        {

            driver.findElement(By.xpath(".//*[@id='hrefIncChd']")).click();

        }

        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).getText());

        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText());

        Select s = new Select(currency);

        s.selectByVisibleText("USD");

    }

}

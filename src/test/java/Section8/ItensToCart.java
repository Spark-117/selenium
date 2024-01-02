package Section8;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItensToCart {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
        addItems(driver, itemsNeeded);
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (WebElement product : products) {

            String[] name = product.getText().split("-");
            String formattedName = name[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                product.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])")).click();
                itemsNeeded = removeItemFromArray(itemsNeeded, formattedName);
            }
        }
    }

    public static String[] removeItemFromArray(String[] array, String item) {
        String[] newArray = new String[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(item)) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
}

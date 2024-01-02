package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7Rows {

    public static void main(String[] args) {
        
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage containing the table
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the table element (adjust the locator as per your HTML structure)
        WebElement table = driver.findElement(By.xpath("((//table[@id='product'])[1])"));

       // Print the number of rows and columns
        RowCount(table);
        ColumnCount(table);

        // Print the content of the second row
        SecondRowContent(table);

        // Close the browser
        driver.quit();
    }

    private static void RowCount(WebElement table) {
        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Number of Rows: " + rows.size());
    }

    private static void ColumnCount(WebElement table) {
        // Find all columns in the first row (assuming all rows have the same number of columns)
        List<WebElement> columns = table.findElements(By.xpath("//tr[1]/td"));
        System.out.println("Number of Columns: " + columns.size());
    }

    private static void SecondRowContent(WebElement table) {
        // Find all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Check if there is a 2nd row before trying to print
        if (rows.size() >= 2) {
            // Get the 2nd row
            WebElement secondRow = rows.get(1);

            // Find all columns in the 2nd row
            List<WebElement> columns = secondRow.findElements(By.tagName("td"));

            // Print the content of the 2nd row
            System.out.println("Content of the Second Row:");
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t");
            }
            System.out.println(); // Move to the next line
        } 
        
    }
}
    
/* A much easyer option
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class asda {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        driver.manage().window().maximize();

        List<WebElement> tablerows = driver.findElements(By.cssSelector("table[class='table-display'] tbody tr"));

        System.out.println("The number of rows present in the given table is: " + tablerows.size());

        List<WebElement> tablecol = driver.findElements(By.cssSelector("table[class='table-display'] tbody tr th"));

        System.out.println("The number of columns present in the given table is: " + tablecol.size());

        String dataentry = driver.findElement(By.cssSelector("table[class='table-display'] tbody tr:nth-child(3)"))
                .getText();

        System.out.println(dataentry);
    } */

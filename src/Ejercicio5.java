import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ejercicio5 {
    public  static void  main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get("https://demoqa.com/webtables");
            dr.manage().window().maximize();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Carlos");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Ramírez");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("carlos@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys("25");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary"))).sendKeys("2500000");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department"))).sendKeys("Sistemas");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox"))).sendKeys("Carlos");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            Boolean nombre = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"),"Carlos"));
           Boolean nombre2 = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"),"Ramírez"));
            if (nombre && nombre2){
                System.out.println("La prueba fue exitosa");
            }
            else {
                System.out.println("La prueba fue erronea");
            }




        }finally {
            dr.quit();
        }
    }
}

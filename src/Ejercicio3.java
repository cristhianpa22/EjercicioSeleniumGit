import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio3 {
    public  static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get(" https://www.selenium.dev/selenium/web/web-form.html");
            dr.manage().window();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id"))).sendKeys("Prueba ADSO");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password"))).sendKeys("Sena2026");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea"))).sendKeys("Automatización con Selenium");
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();
            Boolean mensaje = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"Received!"));
            System.out.println("mensaje:"+ mensaje);
            if (mensaje){
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

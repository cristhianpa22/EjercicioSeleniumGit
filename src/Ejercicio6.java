import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Ejercicio6 {
    public  static void  main(String[] args){
        WebDriver dr = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get(" https://www.selenium.dev/selenium/web/dynamic.html");
            dr.manage().window().maximize();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("adder"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
            input.sendKeys("prueba Selemiun ADSO");
            String mensaje = input.getDomProperty("value");
            if (mensaje.equals("prueba Selemiun ADSO")){
                System.out.println("La prueba fue exitosa valor texto:"+ mensaje);
            }else {
                System.out.println("La prueba fue erronea");
            }
            File screenshot = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_Ejercicio.png");
            FileHandler.copy(screenshot, destino);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            dr.quit();
        }
    }
}

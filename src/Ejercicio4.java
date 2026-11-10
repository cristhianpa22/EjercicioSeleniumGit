import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Ejercicio4 {
    public  static void  main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        Actions acciones = new Actions(dr);
        try {
            dr.get(" https://demoqa.com/buttons");
            dr.manage().window().maximize();

            WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
            acciones.doubleClick(boton).perform();
            String mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
            if (mensaje.equals("You have done a double click")){
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

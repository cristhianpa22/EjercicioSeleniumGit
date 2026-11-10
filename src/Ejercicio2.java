import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio2 {
    public static void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get("https://demoqa.com/radio-button");
            dr.manage().window().maximize();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesRadio")));
            WebElement impressive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("impressiveRadio")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noRadio")));
            impressive.click();
            System.out.println("el boton esta "+ (impressive.isEnabled() ? "selecionado" : "no selecionado"));
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"))).getText();
            System.out.println("mensaje:"+texto);
            if (texto.contains("Impressive")){
                System.out.println("La prueba fue exitosa");
            }else {
                System.out.println("La prueba fue erronea");
            }



        }finally {
            dr.quit();
        }
    }
}

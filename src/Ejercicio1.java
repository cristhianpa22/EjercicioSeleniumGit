import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio1 {
    public  static  void main(String[] args){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get("https://demoqa.com/text-box");
            dr.manage().window().maximize();
            WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            inputNombre.sendKeys("Laura Martínez");
            WebElement inputCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
            inputCorreo.sendKeys("laura@gmail.com");
            WebElement inputDireccion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress")));
            inputDireccion.sendKeys("Calle 25 # 10-20");
            WebElement inputDireccionPer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress")));
            inputDireccionPer.sendKeys("Carrera 15 # 30-40");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
            String name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).getText();
            String correo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).getText();
            System.out.println("nombre:"+ name);
            System.out.println("corre:"+ correo);
            if (name.contains("Laura Martínez") && correo.contains("laura@gmail.com")){
                System.out.println("La prueba fue exitosa");
            }else {
                System.out.println("La prueba fue erronea");
            }



        }finally {
            dr.quit();

        }

    }
}

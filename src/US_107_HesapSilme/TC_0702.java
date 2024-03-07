package US_107_HesapSilme;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TC_0702 extends BaseDriver {
    @Test
    public void TC_0702() {
        // Nagigate to website
        driver.get("https://www.akakce.com/");
        // Navigate to the login page
        driver.findElement(By.xpath("//a[text()='Giriş Yap']")).click();
        // Enter the credentials and click the "Giriş Yap" button
        driver.findElement(By.cssSelector("input[id='life']")).sendKeys("testnomads01@gmail.com");
        driver.findElement(By.cssSelector("input[id='lifp']")).sendKeys("Nomad07++");
        driver.findElement(By.xpath("//input[@id='lfb']")).click();
        // Navigate to the user profile and click the "Hesabımı Sil" button
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Hesabımı Sil")).click();
        // Enter a wrong password for account deletion
        driver.findElement(By.cssSelector("input[id='p']")).sendKeys("wrongpassword" + Keys.ENTER);
        // Check for the presence of the error message
        List<WebElement> hata = driver.findElements(By.xpath("//button[@onclick='Modal_v8.close()']"));
        if (!hata.isEmpty()) {
            System.out.println("Hesap silinemedi!");
        } else
            System.out.println("Hesap silindi!");

        BekleKapat();
    }
}
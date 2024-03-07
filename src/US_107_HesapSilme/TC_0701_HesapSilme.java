package US_107_HesapSilme;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TC_0701_HesapSilme extends BaseDriver {
    @Test
    public void TC_0701() {
        // Nagigate to website
        driver.get("https://www.akakce.com/");
        // Navigate to the login page
        driver.findElement(By.xpath("//a[text()='Giriş Yap']")).click();
        // Enter the credentials and click the "Giriş Yap" button
        driver.findElement(By.cssSelector("input[id='life']")).sendKeys("SeleniumProjectTeam@gmail.com");
        driver.findElement(By.cssSelector("input[id='lifp']")).sendKeys("Bugfighters1234!");
        driver.findElement(By.xpath("//input[@id='lfb']")).click();
        // Navigate to the user profile and click the "Hesabımı Sil" button
        driver.findElement(By.linkText("Test")).click();
        driver.findElement(By.linkText("Hesabımı Sil")).click();
        // Enter the password for account deletion confirmation
        driver.findElement(By.cssSelector("input[id='p']")).sendKeys("Bugfighters1234!" + Keys.ENTER);
        // Find the confirmation message and check if the account deletion is successful
        WebElement condition = driver.findElement(By.cssSelector("div[id='C4w'] i"));
        Assert.assertEquals("Hesap silinemedi!", "Hesabın silindi", condition.getText().substring(0, 15));

        BekleKapat();
    }
}
package US_104_OturumAcma_Login;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0402 extends BaseDriver {
    @Test
    public void LoginTest(){
        driver.get("https://www.akakce.com/");
        WebElement girisyap= driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        girisyap.click();

        WebElement eposta= driver.findElement(By.cssSelector("input[id='life']"));
        eposta.sendKeys("SeleniumProjectTeam@gmail.com");

        WebElement sifre= driver.findElement(By.cssSelector("input[id='lifp']"));
        sifre.sendKeys("Bugfighters1234!");

        WebElement loginbutton=driver.findElement(By.cssSelector("input[id='lfb']"));
        loginbutton.click();

        WebElement menu= driver.findElement(By.cssSelector("a[id='H_a_v8']"));
        wait.until(ExpectedConditions.visibilityOf(menu));

        Actions aksiyonDriver=new Actions(driver);
        Action aksiyon=aksiyonDriver.moveToElement(menu).build();// elementin üzerine gel
        aksiyon.perform(); // etki olustur(maus üzerinde)

        WebElement hesabim= driver.findElement(By.xpath("//a[text()='Hesabım']"));

        //1.Yöntem
        //Assert.assertTrue("Giris yapilamadi",hesabim.getText().equals("Hesabım"));

        //2.Yöntem
        hesabim.click();
        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/"));
        Assert.assertTrue("Giris yapilamadi",driver.getCurrentUrl().equals("https://www.akakce.com/akakcem/"));

        BekleKapat();
    }
    @Test
    public void EksikBilgiTest(){
        driver.get("https://www.akakce.com/");
        WebElement girisyap= driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        girisyap.click();

        WebElement eposta= driver.findElement(By.cssSelector("input[id='life']"));
        eposta.sendKeys("SeleniumProject@gmail.com");

        WebElement sifre= driver.findElement(By.cssSelector("input[id='lifp']"));
        sifre.sendKeys("1234");

        WebElement loginbutton=driver.findElement(By.cssSelector("input[id='lfb']"));
        loginbutton.click();

        WebElement hata= driver.findElement(By.xpath("//p[text()='Böyle bir kullanıcı yok.']"));

        wait.until(ExpectedConditions.visibilityOf(hata));
        Assert.assertTrue("Hatali sayfa girisi",hata.getText().equals("Böyle bir kullanıcı yok."));
        BekleKapat();
    }
    @Test
    public void NullDegerTest(){
        driver.get("https://www.akakce.com/");
        WebElement girisyap= driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        girisyap.click();

        WebElement loginbutton=driver.findElement(By.cssSelector("input[id='lfb']"));
        loginbutton.click();

        WebElement hatabutton= driver.findElement(By.xpath("//b[text()='Tamam']"));

        wait.until(ExpectedConditions.elementToBeClickable(hatabutton));
        Assert.assertTrue("Hatali sayfa yönlendirme",hatabutton.isDisplayed());
        BekleKapat();
    }
}

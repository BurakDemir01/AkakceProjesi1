package US_104_OturumAcma_Login;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OturumAcma_Login extends BaseDriver {
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

        //Assert.assertTrue("Giris yapilamadi",hesabim.getText().equals("Hesabım"));

        //2.Yöntem
        hesabim.click();
        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/"));
        Assert.assertTrue("Giris yapilamadi",driver.getCurrentUrl().equals("https://www.akakce.com/akakcem/"));

        BekleKapat();
    }
}

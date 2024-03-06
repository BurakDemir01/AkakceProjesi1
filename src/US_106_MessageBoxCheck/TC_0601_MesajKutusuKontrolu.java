package US_106_MessageBoxCheck;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0601_MesajKutusuKontrolu extends BaseDriver {

    @Test
    public void MessageBoxCheck_TC_0601() {
        driver.get("https://www.akakce.com/");
        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/"));
        Actions driverAksiyon = new Actions(driver);

        WebElement girisYap = driver.findElement(By.xpath("(//a[text()='Giriş Yap'])[1]"));
//        Action aksiyon1 = driverAksiyon.moveToElement(girisYap).click().build();
//        aksiyon1.perform();
        girisYap.click();

        WebElement eMail = driver.findElement(By.cssSelector("form[id='FrmLi'] input[type=email]"));
        Action aksiyon2 = driverAksiyon.moveToElement(eMail).click().
                sendKeys("SeleniumProjectTeam@gmail.com").build();

        aksiyon2.perform();

        WebElement sifre = driver.findElement(By.cssSelector("form[id='FrmLi'] input[id=lifp]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[id='FrmLi'] input[id=lifp]")));
//        Action aksiyon3 = driverAksiyon.moveToElement(sifre).click().sendKeys("Bugfighters1234!").build();
//        aksiyon3.perform();
        sifre.sendKeys("Bugfighters1234!");

        WebElement girisYapButton = driver.findElement(By.cssSelector("form[id='FrmLi'] input[id='lfb']"));
        girisYapButton.click();

        wait.until(ExpectedConditions.titleContains("Akakçe"));

        WebElement hesabim = driver.findElement(By.cssSelector("header[id='Marvin'] [title='Hesabım']"));

        Action aksyion4 = driverAksiyon.moveToElement(hesabim).build();
        wait.until(ExpectedConditions.visibilityOf(hesabim));
        aksyion4.perform();

        WebElement myProfile = driver.findElement(By.xpath("((//header[@id='Marvin']//div)[5]//i)[1]//a"));
        myProfile.click();

        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/"));

        WebElement mesajlarim = driver.findElement(By.xpath("((//div[@id='AP']//li)[1]//a)[2]"));
        mesajlarim.click();

        WebElement nonText = driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));

        wait.until(ExpectedConditions.urlToBe("https://www.akakce.com/akakcem/mesajlarim/"));

        Assert.assertTrue("Mesaj Kutusu Görünmüyor", nonText.getText().contains("Listelenecek mesaj bulunamadı."));


        BekleKapat();
    }
}

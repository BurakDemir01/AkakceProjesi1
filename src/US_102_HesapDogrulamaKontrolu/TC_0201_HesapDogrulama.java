package US_102_HesapDogrulamaKontrolu;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_0201_HesapDogrulama extends BaseDriver {
  @Test
    public void Test(){

      driver.get("https://www.akakce.com/");
      MyFunc.Bekle(2);

    WebElement giris= driver.findElement(By.xpath("//div[@id='H_rl_v8']//a[2]"));
    Actions aDriver=new Actions(driver);

    Action action=aDriver.moveToElement(giris).click().build();
    wait.until(ExpectedConditions.visibilityOf(giris));
    action.perform();

    WebElement ePost= driver.findElement(By.cssSelector("[id='life']"));
    ePost.sendKeys("SeleniumProjectTeam@gmail.com");
    MyFunc.Bekle(2);

    WebElement sifre= driver.findElement(By.cssSelector("[id='lifp']"));
    sifre.sendKeys("Bugfighters1234!");
    MyFunc.Bekle(2);

    WebElement girisbutton=driver.findElement(By.cssSelector("input[id='lfb']"));
    girisbutton.click();
    MyFunc.Bekle(2);

    WebElement isim=driver.findElement(By.xpath("//div[@id='HM_v8']//a"));

      if (isim.getText().equals("Selen"))
        System.out.println("Test basarili sonuc verdi");

    MyFunc.Bekle(2);

    BekleKapat();








    }
}

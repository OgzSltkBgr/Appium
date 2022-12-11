package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07_WebAppChrome {
    @Test
    public void test07() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60000);
        capabilities.setCapability("chromedriverExecutable","C:\\Users\\pc\\IdeaProjects\\Appium\\src\\driver\\chromedriver.exe");


        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext()+"<=====app acildigindaki tur");

        //Burda application un hangi turleri oldugunu gomek icin getcontextHandles kullaniyoruz
         Set<String> butunTurler=driver.getContextHandles();
         for (String tur:butunTurler
              ) {
             System.out.println("tur = " + tur);
             if(tur.contains("WEBVIEW_chrome")){
                 driver.context(tur);
             }
         }
        System.out.println(driver.getContext()+"<=====degisimden sonra tur");
          Thread.sleep(5000);

          MobileElement logo = driver.findElementByXPath("//*[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Ana sayfadayız");

        Thread.sleep(5000);

        MobileElement sigIn=driver.findElementByXPath("//*[@id='nav-progressive-greeting']");
        sigIn.click();
        Thread.sleep(3000);

        System.out.println("Sign ın sayfasindayiz");

    }
}

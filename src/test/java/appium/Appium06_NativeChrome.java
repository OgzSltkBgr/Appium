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

public class Appium06_NativeChrome {
    @Test
    public void test06() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability("noReset",true);

        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");

        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.get("https://www.amazon.com");

       // System.out.println(driver.getContext()+"<=====app acildigindaki tur");
       // //Burda application un hangi turleri oldugunu gomek icin getcontextHandles kullaniyoruz
       // Set<String> butunTurler=driver.getContextHandles();
       // for (String tur:butunTurler
       //      ) {
       //     System.out.println("tur = " + tur);
       //     if(tur.contains("WEBVIEW_chrome")){
       //         driver.context(tur);
       //     }
       // }
        //System.out.println(driver.getContext()+"<=====degisimden sonra tur");
        Thread.sleep(5000);

        MobileElement homeScreenLogo=driver.findElementByXPath("//android.view.View[@content-desc=\"Amazon\"]");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");

        //System.out.println(driver.getCurrentUrl()+"<======== url ");
        Thread.sleep(5000);

        MobileElement signInButton= driver.findElementByAccessibilityId("Sign in ›");
        signInButton.click();
        Thread.sleep(5000);

        MobileElement welcomeText =driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        //Assert.assertTrue(welcomeText.isDisplayed());

        System.out.println("Test bitti");
        Thread.sleep(5000);

        driver.closeApp();


    }
}

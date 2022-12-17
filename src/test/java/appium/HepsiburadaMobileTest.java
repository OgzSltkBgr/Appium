package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HepsiburadaMobileTest {
    @Test
    public void testHepsiburada() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability("appPackage","com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity","com.hepsiburada.ui.home.BottomNavigationActivity");
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(7000);
        MobileElement loginBox=  driver.findElementByClassName("android.widget.EditText");
        Thread.sleep(5000);
        loginBox.sendKeys("bugraoguzz1@gmail.com");
        Thread.sleep(2000);
        MobileElement girisYap=driver.findElementByClassName("android.widget.Button");
        girisYap.click();
        Thread.sleep(5000);
        loginBox.sendKeys("password");
        Thread.sleep(2000);
        girisYap.click();
        Thread.sleep(5000);
        MobileElement tamam=driver.findElementById("android:id/button1");
        tamam.click();
    }
}

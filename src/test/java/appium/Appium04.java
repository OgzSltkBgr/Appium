package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {
    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\pc\\IdeaProjects\\Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        System.out.println("app yuklendi");
        MobileElement homeScreenTitle = driver.findElementById("android:id/title");
        Thread.sleep(3000);
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");
    }
}

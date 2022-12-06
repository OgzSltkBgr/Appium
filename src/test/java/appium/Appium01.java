package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\pc\\IdeaProjects\\Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<MobileElement>driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(3000);
        MobileElement addButon=driver.findElementById("com.davemac327.gesture.tool:id/addButton");
        addButon.click();
        Thread.sleep(3000);
        MobileElement textButon=driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
        textButon.click();
        Thread.sleep(3000);
        textButon.sendKeys("deneme");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        driver.hideKeyboard();
        Thread.sleep(3000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();


    }
}

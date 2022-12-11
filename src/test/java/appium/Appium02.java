package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\pc\\IdeaProjects\\Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");// KOnsola adbs shell enter yapıp "dumpsys window | grep -E "mCurrentFocus" enter"
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        AndroidDriver<MobileElement>driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();
        Thread.sleep(3000);

        MobileElement okBUtton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
        Thread.sleep(3000);
        okBUtton.click();



    }
}

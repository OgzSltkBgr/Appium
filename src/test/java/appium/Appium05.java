package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {
    @Test
    public void test05() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Oguz");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\pc\\IdeaProjects\\Appium\\src\\Apps\\Calculator.apk");
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        //MobileElement ok=driver.findElementById("android:id/button1");
        MobileElement num1=driver.findElementById("com.hld.anzenbokusucal:id/number1_btn");
        MobileElement num2=driver.findElementById("com.hld.anzenbokusucal:id/number2_btn");
        MobileElement num3=driver.findElementById("com.hld.anzenbokusucal:id/number3_btn");
        MobileElement num4=driver.findElementById("com.hld.anzenbokusucal:id/number4_btn");
        MobileElement num5=driver.findElementById("com.hld.anzenbokusucal:id/number5_btn");
        MobileElement num6=driver.findElementById("com.hld.anzenbokusucal:id/number6_btn");
        MobileElement num7=driver.findElementById("com.hld.anzenbokusucal:id/number7_btn");
        MobileElement num8=driver.findElementById("com.hld.anzenbokusucal:id/number8_btn");
        MobileElement num9=driver.findElementById("com.hld.anzenbokusucal:id/number9_btn");
        MobileElement num0=driver.findElementById("com.hld.anzenbokusucal:id/number0_btn");

        MobileElement multiply=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.GridView/android.widget.FrameLayout[1]");
        MobileElement minus=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.GridView/android.widget.FrameLayout[2]");
        MobileElement plus=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.GridView/android.widget.FrameLayout[3]");

        MobileElement equals=driver.findElementById("com.hld.anzenbokusucal:id/number_equal_btn");


       // ok.click();
        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();


        Thread.sleep(3000);

        MobileElement preResult = driver.findElementById("com.hld.anzenbokusucal:id/text_out");

        String preResultText= preResult.getText();
        System.out.println("preResultText = " + preResultText);

        equals.click();
        Thread.sleep(3000);

        MobileElement result = driver.findElementById("com.hld.anzenbokusucal:id/editText");
        System.out.println("result = " + result.getText());

        Assert.assertEquals(result.getText(),preResultText);


    }
}

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Set;

public class AppTesting {
  public static final String USERNAME = System.getenv("BROWSERSTACK_USER");
  public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
    
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("build", "App Testing");
    caps.setCapability("name", "sample java");
    caps.setCapability("platformName", "android");
    caps.setCapability("device", "Google Nexus 6");
    caps.setCapability("realMobile", true);
    caps.setCapability("app", "https://browserstack-user-apps.s3.amazonaws.com/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988.apk?AWSAccessKeyId=AKIAJII2FX4REVVMGTAA&Expires=1473318772&Signature=ZZ5%2B2sluXyTy1LO77%2FJNPinPbH0%3D");

    AndroidDriver driver = new AndroidDriver(new URL(URL), caps);

    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

    MobileElement sampleLabel = (MobileElement) driver.findElementById("sampleLabel");
    System.out.println(sampleLabel.getText());

    Set<String> contexts = driver.getContextHandles();

    MobileElement num1 = (MobileElement) driver.findElementById("num1");
    MobileElement num2 = (MobileElement) driver.findElementById("num2");
    num1.sendKeys("12");
    num2.sendKeys("32");

    MobileElement add_btn = (MobileElement) driver.findElementById("addBtn");
    driver.tap(1, add_btn, 1000);

    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    System.out.println(sampleLabel.getText());

    driver.quit();
  }
}

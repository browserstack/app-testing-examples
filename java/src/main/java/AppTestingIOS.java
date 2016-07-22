import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.Set;

public class AppTestingIOS {
  public static final String USERNAME = System.getenv("BROWSERSTACK_USER");
  public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
    
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("build", "App Testing iOS");
    caps.setCapability("name", "sample java");
    caps.setCapability("platformName", "ios");
    caps.setCapability("device", "iPhone 6S");
    caps.setCapability("realMobile", true);
    caps.setCapability("app", System.getenv("IOS_APP_URL"));

    AndroidDriver driver = new AndroidDriver(new URL(URL), caps);

    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

    Set<String> contexts = driver.getContextHandles();

    MobileElement num1 = (MobileElement) driver.findElementById("IntegerA");
    MobileElement num2 = (MobileElement) driver.findElementById("IntegerB");
    num1.sendKeys("12");
    num2.sendKeys("32");

    MobileElement add_btn = (MobileElement) driver.findElementById("ComputeSumButton");
    driver.tap(1, add_btn, 1000);

    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    MobileElement sampleLabel = (MobileElement) driver.findElementById("Answer");
    System.out.println(sampleLabel.getText());

    driver.quit();
  }
}

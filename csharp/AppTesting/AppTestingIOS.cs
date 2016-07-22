using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Android;

namespace AppiumTest
{
  class AppTestingIOS
  {
    static void Main()
    {
      AndroidDriver<AndroidElement> driver;
      DesiredCapabilities capability = DesiredCapabilities.Android();
      capability.SetCapability("browserstack.user", Environment.GetEnvironmentVariable("BROWSERSTACK_USER"));
      capability.SetCapability("browserstack.key", Environment.GetEnvironmentVariable("BROWSERSTACK_ACCESS_KEY"));
      capability.SetCapability("build", "App Testing iOS");
      capability.SetCapability("name", "sample csharp");
      capability.SetCapability("browserstack.debug", true);
      capability.SetCapability("platform", "ios");
      capability.SetCapability("device", "iPhone 6S");
      capability.SetCapability("realMobile", true);
      capability.SetCapability("app", Environment.GetEnvironmentVariable("IOS_APP_URL"));

      driver = new AndroidDriver<AndroidElement>(
        new Uri("http://hub-cloud.browserstack.com/wd/hub/"), capability
      );

      ((ITakesScreenshot)driver).GetScreenshot();

      var contexts = driver.Contexts;

      AndroidElement num1 = driver.FindElementById("IntegerA");
      AndroidElement num2 = driver.FindElementById("IntegerB");
      num1.SendKeys("12");
      num2.SendKeys("32");

      AndroidElement add_btn = driver.FindElementById("ComputeSumButton");
      add_btn.Tap(1, 1000);

      ((ITakesScreenshot)driver).GetScreenshot();
      AndroidElement samplelabel = driver.FindElementById("Answer");
      Console.WriteLine(samplelabel.Text);

      driver.Quit();
    }
  }
}

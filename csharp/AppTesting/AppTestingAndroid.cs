using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Appium;
using OpenQA.Selenium.Appium.Android;

namespace AppiumTest
{
  class AppTestingAndroid
  {
    static void Main()
    {
      AndroidDriver<AndroidElement> driver;
      DesiredCapabilities capability = DesiredCapabilities.Android();
      capability.SetCapability("browserstack.user", Environment.GetEnvironmentVariable("BROWSERSTACK_USER"));
      capability.SetCapability("browserstack.key", Environment.GetEnvironmentVariable("BROWSERSTACK_ACCESS_KEY"));
      capability.SetCapability("build", "App Testing Android");
      capability.SetCapability("name", "sample csharp");
      capability.SetCapability("browserstack.debug", true);
      capability.SetCapability("platform", "android");
      capability.SetCapability("device", "Google Nexus 6");
      capability.SetCapability("realMobile", true);
      capability.SetCapability("app", Environment.GetEnvironmentVariable("ANDROID_APP_URL"));

      driver = new AndroidDriver<AndroidElement>(
        new Uri("http://hub-cloud.browserstack.com/wd/hub/"), capability
      );

      ((ITakesScreenshot)driver).GetScreenshot();

      AndroidElement samplelabel = driver.FindElementById("sampleLabel");
      Console.WriteLine(samplelabel.Text);

      var contexts = driver.Contexts;

      AndroidElement num1 = driver.FindElementById("num1");
      AndroidElement num2 = driver.FindElementById("num2");
      num1.SendKeys("12");
      num2.SendKeys("32");

      AndroidElement add_btn = driver.FindElementById("addBtn");
      add_btn.Tap(1, 1000);

      ((ITakesScreenshot)driver).GetScreenshot();
      Console.WriteLine(samplelabel.Text);

      driver.Quit();
    }
  }
}

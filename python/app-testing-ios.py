import os

from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction

desired_cap = { 
  'platformName': 'ios',
  'device': 'iPhone 6S',
  'realMobile': True,
  'app': os.environ['IOS_APP_URL'],
  'build': 'App Testing iOS',
  'name': 'sample python',
  'browserstack.debug': True
}

driver = webdriver.Remote(
  command_executor='http://'+os.environ['BROWSERSTACK_USER']+':'+os.environ['BROWSERSTACK_ACCESS_KEY']+'@hub.browserstack.com:80/wd/hub',
  desired_capabilities=desired_cap)


driver.get_screenshot_as_file("test.png")
context = driver.contexts

num1 = driver.find_element_by_id("IntegerB")
num2 = driver.find_element_by_id("IntegerB")
num1.send_keys("12")
num2.send_keys("32")
add_btn = driver.find_element_by_id("ComputeSumButton")

touch = TouchAction(driver)
touch.tap(add_btn).perform()

driver.get_screenshot_as_file("test.png")
sample_label = driver.find_element_by_id("Answer")
print(sample_label.text)

driver.quit()

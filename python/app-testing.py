import os

from appium import webdriver
from appium.webdriver.common.touch_action import TouchAction

desired_cap = { 
  'platformName': 'android',
  'device': 'Google Nexus 6',
  'realMobile': True,
  'app': 'https://browserstack-user-apps.s3.amazonaws.com/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988.apk?AWSAccessKeyId=AKIAJII2FX4REVVMGTAA&Expires=1473318772&Signature=ZZ5%2B2sluXyTy1LO77%2FJNPinPbH0%3D',
  'build': 'App Testing',
  'name': 'sample python',
  'browserstack.debug': True
}

driver = webdriver.Remote(
  command_executor='http://'+os.environ['BROWSERSTACK_USER']+':'+os.environ['BROWSERSTACK_ACCESS_KEY']+'@hub.browserstack.com:80/wd/hub',
  desired_capabilities=desired_cap)


driver.get_screenshot_as_file("test.png")
sample_label = driver.find_element_by_id("sampleLabel")
print(sample_label.text)

context = driver.contexts

num1 = driver.find_element_by_id("num1")
num2 = driver.find_element_by_id("num2")
num1.send_keys("12")
num2.send_keys("32")
add_btn = driver.find_element_by_id("addBtn")

touch = TouchAction(driver)
touch.tap(add_btn).perform()

driver.get_screenshot_as_file("test.png")
print(sample_label.text)

driver.quit()

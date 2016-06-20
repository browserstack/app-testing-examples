require 'rubygems'
require 'selenium-webdriver'
require 'appium_lib'

# Input capabilities
caps = Selenium::WebDriver::Remote::Capabilities.new
caps["browserstack.debug"] = "true"
caps["name"] = "sample ruby"
caps["build"] = "App Testing"
caps["platformName"] = "android"
caps["device"] = "Google Nexus 6"
caps["realMobile"] = true
caps["app"] = "https://github.com/browserstack/app-testing-examples/raw/master/app-debug.apk"

appium_driver = Appium::Driver.new({
  caps: JSON.parse(caps.to_json),
  appium_lib: {
    server_url: "http://#{ENV["BROWSERSTACK_USER"]}:#{ENV["BROWSERSTACK_ACCESS_KEY"]}@hub-cloud.browserstack.com/wd/hub"
  }
})

driver = appium_driver.start_driver

driver.save_screenshot "test.png"
sample_label = driver.find_element :id, "sampleLabel"
puts sample_label.text

context = appium_driver.available_contexts

num1 = driver.find_element :id, "num1"
num2 = driver.find_element :id, "num2"
num1.send_keys "12"
num2.send_keys "32"
add_btn = driver.find_element :id, "addBtn"

touch = Appium::TouchAction.new
touch.tap({:element => add_btn}).perform()

driver.save_screenshot "test.png"
puts sample_label.text

driver.quit

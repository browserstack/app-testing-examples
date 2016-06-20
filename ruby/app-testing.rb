require 'rubygems'
require 'selenium-webdriver'

# Input capabilities
caps = Selenium::WebDriver::Remote::Capabilities.new
caps["browserstack.debug"] = "true"
caps["name"] = "sample ruby"
caps["build"] = "App Testing"

driver = Selenium::WebDriver.for(:remote,
  :url => "http://#{ENV["BROWSERSTACK_USER"]}:#{ENV["BROWSERSTACK_ACCESS_KEY"]}@hub-cloud.browserstack.com/wd/hub",
  :desired_capabilities => caps)
driver.navigate.to "http://www.google.com"
element = driver.find_element(:name, 'q')
element.send_keys "BrowserStack"
element.submit
puts driver.title
driver.quit


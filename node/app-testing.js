var wd = require('wd');

// Input capabilities
var capabilities = {
  'platformName': 'android',
  'device': 'Google Nexus 6',
  'realMobile': true,
  'app': 'https://browserstack-user-apps.s3.amazonaws.com/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988/d01a65c98d976f89a8f76279aeb30e1f3a314dc5b3979c35d30b42f62ae7c988.apk?AWSAccessKeyId=AKIAJII2FX4REVVMGTAA&Expires=1473318772&Signature=ZZ5%2B2sluXyTy1LO77%2FJNPinPbH0%3D',
  'build': 'App Testing',
  'name': 'sample node js',
  'browserstack.debug': true,
  'browserstack.user' : process.env.BROWSERSTACK_USER,
  'browserstack.key' : process.env.BROWSERSTACK_ACCESS_KEY
}

var driver = wd.promiseChainRemote({
  host: 'hub-cloud.browserstack.com',
  port: 80,
  username: process.env.BROWSERSTACK_USER,
  password: process.env.BROWSERSTACK_ACCESS_KEY
});

driver
  .init(capabilities)
  .takeScreenshot().then(function(){})
  .elementById("sampleLabel")
  .text().then(function(t){
    console.log(t);
  })
  .contexts()
  .elementById("num1").sendKeys("12")
  .elementById("num2").sendKeys("32")
  .elementById("addBtn")
  .tap()
  .takeScreenshot()
  .elementById("sampleLabel")
  .text().then(function(t){
    console.log(t);
  })
  .quit()
  .done();

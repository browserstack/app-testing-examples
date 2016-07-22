var wd = require('wd');

// Input capabilities
var capabilities = {
  'platformName': 'android',
  'device': 'Google Nexus 6',
  'realMobile': true,
  'app': process.env.ANDROID_APP_URL,
  'build': 'App Testing Android',
  'name': 'sample node js',
  'browserstack.debug': true,
  'browserstack.user' : process.env.BROWSERSTACK_USER,
  'browserstack.key' : process.env.BROWSERSTACK_ACCESS_KEY
}

var driver = wd.promiseChainRemote({
  host: 'hub-cloud.browserstack.com',
  port: 80
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

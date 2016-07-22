var wd = require('wd');

// Input capabilities
var capabilities = {
  'platformName': 'ios',
  'device': 'iPhone 6S',
  'realMobile': true,
  'app': process.env.IOS_APP_URL,
  'build': 'App Testing iOS',
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
  .contexts()
  .elementById("IntegerA").sendKeys("12")
  .elementById("IntegerB").sendKeys("32")
  .elementById("ComputeSumButton")
  .tap()
  .takeScreenshot()
  .elementById("Answer")
  .text().then(function(t){
    console.log(t);
  })
  .quit()
  .done();

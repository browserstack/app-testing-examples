# app-testing-examples
App Testing examples for BrowserStack

## How to run
```
export BROWSERSTACK_USER=<browserstack user name>
export BROWSERSTACK_ACCESS_KEY=<browserstack access key>

export ANDROID_APP_URL=$(curl -u "$BROWSERSTACK_USER:$BROWSERSTACK_ACCESS_KEY" -X POST -F "file=@/path/to/repo/app-testing-examples/app-debug.apk" https://www.browserstack.com/app/beta/android/upload | grep -o 'bs://[^"]*')

export IOS_APP_URL=$(curl -u "$BROWSERSTACK_USER:$BROWSERSTACK_ACCESS_KEY" -X POST -F "file=@/path/to/repo/app-testing-examples/app-debug.ipa" https://www.browserstack.com/app/beta/ios/upload | grep -o 'bs://[^"]*')
```

### ruby
```
cd ruby
bundle install
bundle exec rake test
```

### python
```
cd python
python app-testing-android.py
python app-testing-ios.py
```

### node js
```
cd node
npm install
npm test
```

### java
```

cd java
mvn compile exec:java -Dexec.mainClass="AppTestingAndroid"
mvn compile exec:java -Dexec.mainClass="AppTestingIOS"
```

### csharp
```
Open solution in Visual Studio and run the project.
```

# app-testing-examples
App Testing examples for BrowserStack

## How to run
```
export BROWSERSTACK_USER=<browserstack user name>
export BROWSERSTACK_ACCESS_KEY=<browserstack access key>
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
python app-testing.py
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
mvn compile exec:java -Dexec.mainClass="AppTesting"
```
### csharp
```
Open solution in Visual Studio and run the project.
```

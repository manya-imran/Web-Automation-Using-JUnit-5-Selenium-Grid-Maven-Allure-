# Web-Automation Using JUnit5 Selenium-Grid Maven Allure Reporting

This is a continuation of the previous web automation project. This uses html allure reporting and grid configuration usin

For this assignment we're using Selenium powered web automation testing on a URL
```
https://www.saucedemo.com
```

To set up we need to understand the workflow of this assignment:
We have Automated 7 test cases using parellel exceution in Selenium Grid. We have also utilized both Chrome and Firefox (gecko) drivers. If you want to add more drivers to the Grid Session navigate to the \resourses folder and add your driver executable file.

First you need to set up Selenium Grid
- Add the ```selenium-server-4.25.0.jar``` file to your libraries.
- Create node configuration file and drivers in the project \resources folder. 
- Add the the driver nodes to the Selenium Grid.
- Here's what your node config file should look like.
  For Chrome ```chrome-node.json```:
  ```
    {
    "capabilities": [
      {
        "browserName": "chrome",
        "maxInstances": 8
      }
    ],
    "configuration": {
      "cleanUpCycle": 2000,
      "timeout": 30000,
      "maxSession": 8,
      "register": true,
      "registerCycle": 5000,
      "hub": "http://localhost:4444/grid/register",
      "nodeStatusCheckTimeout": 5000,
      "nodePolling": 5000,
      "role": "node",
      "unregisterIfStillDownAfter": 60000,
      "downPollingLimit": 2
    }
  }
For Firefox use ```firefox-node.json```:
```
  {
    "capabilities": [
      {
        "browserName": "firefox",
        "maxInstances": 8
      }
    ],
    "node": {
      "port": 5560
    },
    "configuration": {
      "cleanUpCycle": 2000,
      "timeout": 30000,
      "maxSession": 8,
      "register": true,
      "registerCycle": 5000,
      "hub": "http://localhost:4444/grid/register",
      "nodeStatusCheckTimeout": 5000,
      "nodePolling": 5000,
      "role": "node",
      "unregisterIfStillDownAfter": 60000,
      "downPollingLimit": 2
    }
  }

```
After adding the required files you need to start your Grid. Use the following command:
```
java -jar .\libs\selenium-server-<version>.jar hub
```
Then add the driver information using the created node config files using the command
```
java "-Dwebdriver.chrome.driver=D:path-to-chromedriver.exe" -jar "path-to-selenium-server-4.25.0.jar" node --config "path-to-node-config-file-chrome-node.json"
java "-Dwebdriver.gecko.driver=D:path-to-geckodriver.exe" -jar "path-to-selenium-server-4.25.0.jar" node --config "path-to-node-config-file-firefox-node.json -p=5556"
```
After that your environment is ready to execute tests.
To execute test you need to create a test environment having your Grid and tests. To do that go to the configuration and select 'Edit Configuration' add your Maven project and hit Run. Make sure your Selenium nodes are up and running. After running that your test case results will be stored in \target\allure-results folder.

This brings us to our next step reporting. We are using Allure reporting to generate high end grahs and accurate HTML reports. Intstall allure in your command line using:
```
npm install -g allure-commandline --save-dev
```
and create the report from the test results generated earlier stored in \target\allure-results folder. Use the following command to do that:
```
allure generate --single-file path-to\target\allure-results --clean -o path-to\target\allure-report
```

You can view the index.html file in the allure-report folder. That's it, this is how you automate and test the workflow of a website. Hope it helps.



generate report by allure generate --single-file D:\JetBrains\Projects\selenium-assign\target\allure-results --clean -o D:\JetBrains\Projects\selenium-assign\target\allure-report# Web-Automation-Using-JUnit-5-Selenium-Grid-Maven-Allure-

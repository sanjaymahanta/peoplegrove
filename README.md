
⚠️ Reason for Skipped Test Cases
Due to recent UI changes in the staging environment (https://basecopy5.staging.pg-test.com/v2/) and temporary server downtime during the last week, some automation test cases are currently skipped in the latest build.
These test scripts were written for the previous UI version and passed successfully in earlier executions.
A detailed video proof of successful test runs on the earlier UI version is included below.

🎥 Video Proof of Successful Execution (Old UI)
1.Automation on Docker vie eclipse IDE

Link -  https://www.loom.com/share/e8378eedeb7a43a689a080937784864c

2. Automation Remote Linux machine,AWS (Jenkins → LambdaTest)
Link - https://www.loom.com/share/bbcfeb617e4f4749a687967a4d804ddf


3.Automation on Docker vie eclipse IDE

Link -  https://www.loom.com/share/e8378eedeb7a43a689a080937784864c

4. Automation Remote Linux machine,AWS (Jenkins → LambdaTest)
Link - https://www.loom.com/share/bbcfeb617e4f4749a687967a4d804ddf

🧠 Additional Notes


The AWS Jenkins and LambdaTest setup demonstrates a real CI/CD pipeline running automation tests in a distributed environment.
The Docker setup shows local containerized test execution, which ensures environment consistency.


The frameworkbased on BDD-Cucumber,TestNG,Hybrid and  supports:
BDD-Cucumber,TestNG,Hybrid
Local execution (Windows / Linux)
Remote execution (LambdaTest / Docker Selenium Grid)
ExtentReports for reporting
Jenkins integration for CI/CD

✅ Next Steps

UI locators will be updated based on the new design to restore full test coverage.
Once updated, new Jenkins builds will reflect 100% pass rate again.


 Technology Stack


Java 21
Selenium 4.37
Cucumber + TestNG
Maven
Extent Reports
Docker
AWS Jenkins (Amazon Linux)
LambdaTest Cloud Grid





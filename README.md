1. Install JDK 12+;

2. Import as Maven project (preferably using IntelliJ IDEA);

3. Add config.properties in src/main/resources/config.properties:

```
browser=chrome
url=https://www.phptravels.net/
adminUrl=https://www.phptravels.net/admin/

username=user@phptravels.com
password=demouser

adminUsername=admin@phptravels.com
adminPassword=demoadmin
```

4. Tests can be run as it follows:

a. Individually, by running a specific feature file in src/test/features;

b. Executing a runner class that can be found in src/test/java/runner;

c. Via command line using mvn clean test -Dtest=runner.RunnerClassName

Example for running the full flow for booking a flight and asserting it was saved correctly in the Admin bookings:

```mvn clean test -Dtest=runner.FlightRunner```


Note: the project uses WebdriverManager and there is no need to manually add the driver to the project.

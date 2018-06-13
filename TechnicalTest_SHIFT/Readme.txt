1. Copy the drivers at the path "\lib\drivers" to your local folder and update the same in the values.properties file (keys 'ChromeDriverPath' and 'FirefoxDriverPath').
2. All necesary jar files to be included in the build path are present at the location "\lib\selenium".
3. Tests run fine with chrome; firefox to be tested further.
4. Test cases can be found in the file src.test.TestNGTestSuite.java. Run it as a TestNG file.
5. Tests are stable with Chrome. Firefix to be tested further.
6. Application URL : http://automationpractice.com/index.php?controller=authentication
7. values.properties file contains test data as well
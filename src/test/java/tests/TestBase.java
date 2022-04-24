package tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	static String DownloadPath= System.getProperty("user.dir")+"\\Downloads";
	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> ChromePrefs = new HashMap<String, Object>();
		ChromePrefs.put("profile.default.content_settings.popups", 0);
		ChromePrefs.put("download.default_directory", DownloadPath);
		options.setExperimentalOption("prefs", ChromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	public static FirefoxOptions firefoxOptions() {
	    String DownloadPath= System.getProperty("user.dir")+"\\Downloads";
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir",DownloadPath);
		return option;
	}
	@BeforeSuite
	@Parameters("browser")
	public void startdriver(@Optional("chrome")String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeOptions());
		}else if (browserName.equalsIgnoreCase("firefox") ) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver(firefoxOptions());
		}else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Faild!");
			System.out.println("Taking Screenshot.....");
			Helper.captureSceenshot(driver, result.getName());
		}
	}
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
}

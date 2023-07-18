package com.guru99Bank.miniproject.qa.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class Base {
	protected WebDriver driver;
	protected Properties configProperties, dataProperties;
	FileInputStream fileInputStream, dataFileInputStream;

	public Base() {
		loadConfiguration();
	}

	public void loadConfiguration() {
		configProperties = new Properties();
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\guru99bank\\miniproject\\qa\\configurations\\config.properties");
			configProperties.load(fileInputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		dataProperties = new Properties();
		try {
			dataFileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\guru99bank\\miniproject\\qa\\testdata\\testdata.properties");
			dataProperties.load(dataFileInputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@BeforeMethod
	public void initializeBrowserAndNavigateToURL() {
		String strBrowser = configProperties.getProperty("browser");
		switch (strBrowser.toLowerCase()) {
		case "chrome": {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser type unsupported");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		driver.get(getApplicationUrl());
	}

	public String getApplicationUrl() {
		String url = configProperties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the config.properties file.");
	}

	@AfterMethod
	public void closeBrowser() {
		try {
			fileInputStream.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		driver.quit();
	}

	public void capturePageScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(System.getProperty("user.dir") + "\\screenshots\\Screenshot_" + getTimeStamp() + ".png"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());
	}
}
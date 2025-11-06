package com.utility;


import java.io.IOException;
import java.util.Properties;





import java.io.FileInputStream;




import java.io.File;

import java.nio.file.Files;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.baseclass.DriverManager;

public class Util {

	 private static Properties properties = null;

	    // --- CONFIG PROPERTIES SECTION ---
	    private static void loadProperties(String fileName) {
	        if (properties == null) {
	            properties = new Properties();
	            try (FileInputStream fis = new FileInputStream("AppConfig/" + fileName + ".properties")) {
	                properties.load(fis);
	            } catch (IOException e) {
	                throw new RuntimeException("Unable to load property file: " + fileName, e);
	            }
	        }
	    }

	    public static String properties(String fileName, String key) {
	        loadProperties(fileName);
	        String value = properties.getProperty(key);
	        if (value == null) {
	            throw new RuntimeException("Property key '" + key + "' not found in " + fileName + ".properties");
	        }
	        return value.trim();
	    }

	    // --- SCREENSHOT SECTION ---
	    /**
	     * Takes a screenshot and returns it as byte[] for attaching to Cucumber reports.
	     */
	    public static byte[] takeScreenShot() {
	        WebDriver driver = DriverManager.webDriver.get();
	        if (driver == null) {
	            System.out.println("WebDriver not initialized, cannot take screenshot.");
	            return new byte[0];
	        }

	        try {
	            // Capture screenshot as bytes (for cucumber attach)
	            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        } catch (Exception e) {
	            System.out.println("Error capturing screenshot: " + e.getMessage());
	            return new byte[0];
	        }
	    }

	    /**
	     * (Optional) Save screenshot to a file for debugging.
	     */
	    public static String saveScreenshotToFile(String folderPath) {
	        WebDriver driver = DriverManager.webDriver.get();
	        if (driver == null) return null;

	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String fileName = "screenshot_" + new Date().getTime() + ".png";
	            File dest = new File(folderPath, fileName);
	            Files.copy(src.toPath(), dest.toPath());
	            return dest.getAbsolutePath();
	        } catch (IOException e) {
	            System.out.println("Error saving screenshot file: " + e.getMessage());
	            return null;
	        }
	    }
}

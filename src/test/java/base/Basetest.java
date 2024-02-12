package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
    public static WebDriver driver;
    public static Properties prop = new Properties(); 
    public static Properties loc = new Properties(); 
    public static Logger logger = LogManager.getLogger(Basetest.class);
    public static FileReader fr;
    public static FileReader fr1;
    
    @BeforeTest
    public void setUp() throws IOException {
        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir") + "//src//test//resources//configfiles//config.properties");
            prop.load(fr);
            fr1 = new FileReader(System.getProperty("user.dir") + "//src//test//resources//ConfigFiles//locators.properties");
            loc.load(fr1);
            
            System.setProperty("log4j.configurationFile", "//Users//aayan//selemiun workplace//baba//src//test//resources//configfiles//log4j2.xml");
            logger.info("*************************STARTED*************************");
            logger.info("Setting up test environment...");
        }
        
        if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "//Users//aayan//selemium utilities//chromedriver-mac-arm64//chromedriver");
            driver = new ChromeDriver();
            logger.info("WebDriver initialized.");
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        logger.info("Session terminated.");
        logger.info("WebDriver closed.");
        logger.info("*************************ENDED*************************");
     //   driver.quit();
    }
    
    public void LogClearer(String logFilePath) {
        try {
            File logFile = new File(logFilePath);
            if (!logFile.exists()) {
                logger.warn("Log file does not exist.");
                return;
            }
            PrintWriter writer = new PrintWriter(logFile);
            writer.close();
            logger.info("Log file cleared successfully.");
        } catch (IOException e) {
            logger.error("Error clearing log file: " + e.getMessage());
        }
    }
}
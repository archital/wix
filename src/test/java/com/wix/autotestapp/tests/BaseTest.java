package com.wix.autotestapp.tests;

import com.wix.autotestapp.core.PropertiesLoader;
import com.wix.autotestapp.data.Names;
import com.wix.autotestapp.pages.HerokuPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by archi on 5/9/2018.
 */
public class BaseTest {

    protected static WebDriver driver;
    protected HerokuPage herokuPage;
    protected static Names staticNames;

    @BeforeClass
    public static void setUp() throws ClassNotFoundException {
        String path = System.getProperty("user.dir");
        String OS = System.getProperty("os.name");
        if (OS.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", path + (PropertiesLoader.uploadPropertiesFile("config.properties").getProperty("driverpathwindows")));
        } else {
            System.setProperty("webdriver.chrome.driver", path + (PropertiesLoader.uploadPropertiesFile("config.properties").getProperty("driverpathlinux")));
        }
        System.setProperty("selenium.browser", "Chrome");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertiesLoader.uploadPropertiesFile("config.properties").getProperty("timeout")), TimeUnit.MILLISECONDS);
        driver.get("http://autotesttask.herokuapp.com/");
        staticNames = new Names();
    }

    @Before
    public void initHerokuPage(){
        this.herokuPage = new HerokuPage(driver);
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}

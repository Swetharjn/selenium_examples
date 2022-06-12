package com.seleniumtesting.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class PageBase {
    
    WebDriver driver;
    protected WebDriverWait wait;
    SoftAssert verify;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PageBase.class);
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        verify = new SoftAssert();
    }
    
    /**
     * Pauses execution for the given amount of time, expressed in seconds.
     *
     * @param seconds The amount of time to wait.
     */
    public void pause(int seconds) {
        try {
            log.info("Pause for " + seconds * 1000 + " seconds");
            Thread.sleep(seconds * 1000);
        }
        catch (Exception e) {
            
            throw new RuntimeException("Thread.sleep failed.");
            // Not ideal, but prevents us from having to add a throws declaration to our upstream methods.
        }
    }
    
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
}

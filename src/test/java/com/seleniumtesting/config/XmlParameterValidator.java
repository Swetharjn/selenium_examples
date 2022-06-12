package com.seleniumtesting.config;

import org.slf4j.LoggerFactory;

import java.util.Map;

public class XmlParameterValidator {
    
    private Map<String, String> xmlParameters;
    
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(XmlParameterValidator   .class);
    
    public XmlParameterValidator(Map<String, String> xmlParameters) {
        this.xmlParameters = xmlParameters;
    }
    
    /**
     * Ensures the `app-url` parameter has been provided.
     *
     * @return The application URL.
     */
    public String validateAppUrl() {
        if (xmlParameters.containsKey("appUrl")) {
            String url = xmlParameters.get("appUrl");
            log.info("Using Application URL [" + url + "].");
            
            return url;
        }
        else {
            String message = "Application URL parameter is required.";
            log.error(message);
            
            throw new IllegalArgumentException(message);
        }
    }
    /**
     * Reads and returns the option to run Chrome in headless mode, if one is provided, otherwise a default value is
     * set.
     *
     * @return The Headless option.
     */
    public boolean validateRunChromeHeadless() {
        if (xmlParameters.containsKey("runHeadlessChrome")) {
            boolean headless = Boolean.parseBoolean(xmlParameters.get("runHeadlessChrome"));
            log.info("Running Chrome in Headless Mode declared [{}].", headless);
            
            return headless;
        }
        else {
            log.info("No Headless mode declared, running Headless by default.");
            
            return true;
        }
    }
}

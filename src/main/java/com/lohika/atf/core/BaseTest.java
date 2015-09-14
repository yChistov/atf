package com.lohika.atf.core;

import static com.lohika.atf.core.DriverMaster.getDriver;
import static com.lohika.atf.core.Configuration.setGlobalEnvironment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "environment"})
    public void setUp(@Optional("firefox")String browser, @Optional("local")String environment){
        driver = getDriver(browser);
        setGlobalEnvironment(environment);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}


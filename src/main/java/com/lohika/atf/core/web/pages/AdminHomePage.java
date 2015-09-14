package com.lohika.atf.core.web.pages;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeoutException;

public class AdminHomePage extends WebPage<AdminHomePage> {


    private static final String PAGE_URL = BASE_URL;

    public AdminHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AdminHomePage load() {
        driver.get(PAGE_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return getUsersLink().isAvailable();
    }

    public LoginPage loadAsAnonymousUser() throws TimeoutException {
        load();
        return new LoginPage(driver).waitUntilAvailable();
    }

    private Link getUsersLink(){
        return new Link(driver,
                By.xpath("//*[@id='social_popup']/div/div"));
    }
}

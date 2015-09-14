package com.lohika.atf.core.web.pages;

import com.lohika.atf.core.web.WebPage;
import com.lohika.atf.core.web.elements.Button;
import com.lohika.atf.core.web.elements.Span;
import com.lohika.atf.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

public class LoginPage extends WebPage<LoginPage> {

    private static final String PAGE_URL = BASE_URL;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage load() {
        driver.get(PAGE_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        return  getSpanLogin().isAvailable() &&
                getUsernameInput().isAvailable() &&
                getPasswordInput().isAvailable() &&
                getLoginButton().isAvailable();
    }

    public AdminHomePage loginAs(String username, String password) throws TimeoutException {
        getSpanLogin().click();
        getUsernameInput().inputText(username);
        getPasswordInput().inputText(password);
        getLoginButton().click();
        return new AdminHomePage(driver).waitUntilAvailable();
    }

    private Span getSpanLogin(){
        return new Span(driver,
                By.xpath("//*[@id='header_user_menu_parent']/a"));
    }

    private TextInput getUsernameInput(){
        return new TextInput(driver, By.id("username"));
    }

    private TextInput getPasswordInput(){
        return new TextInput(driver, By.name("password"));
    }

    private Button getLoginButton(){
        return new Button(driver,
                By.xpath("//*[@id='user-popup-parent48613']//form/div[1]/div[3]/div[1]/div[2]/div/span/button"));
    }
}

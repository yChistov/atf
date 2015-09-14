package com.lohika.atf.core.web.elements;

import com.lohika.atf.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput extends WebComponent<TextInput>{

    public TextInput(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }

    public TextInput inputText(String text){
        getWebElement().sendKeys(text);
        return this;
    }
}

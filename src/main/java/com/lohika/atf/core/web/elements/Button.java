package com.lohika.atf.core.web.elements;

import com.lohika.atf.core.web.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends WebComponent<Button>{

    public Button(WebDriver driver, By findByMethod) {
        super(driver, findByMethod);
    }
}

package com.lohika.atf.tests;

import com.lohika.atf.core.BaseTest;
import com.lohika.atf.core.web.pages.AdminHomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class FirstTest extends BaseTest{

    @Test
    public void testMethod() throws TimeoutException {
        new AdminHomePage(driver)
                .loadAsAnonymousUser()
                .loginAs("misteriys@ukr.net", "ghjuhfvbcn");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
    }
}


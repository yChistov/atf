package com.lohika.atf.core.web;

import com.lohika.atf.core.Configuration;
import com.lohika.atf.core.Environment;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeoutException;

import static com.lohika.atf.core.Configuration.getConfig;

public abstract class WebPage<T extends WebPage<T>> extends Component<T>{

    private static final Configuration CONFIG = getConfig();
    private static final Environment ENVIRONMENT = CONFIG.getEnvironmentSettings();
    protected static final String BASE_URL = ENVIRONMENT.scheme + "://"
            + ENVIRONMENT.host;

    public WebPage(WebDriver driver){
        super(driver);
    }

    public abstract T load();

    public T loadAndWaitUntilAvailable() throws TimeoutException {
        load();
        return waitUntilAvailable();
    }
}

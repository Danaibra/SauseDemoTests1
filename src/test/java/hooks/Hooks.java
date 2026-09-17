package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));;
}

    @After
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
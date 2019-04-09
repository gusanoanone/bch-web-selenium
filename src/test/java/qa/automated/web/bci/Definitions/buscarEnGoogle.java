package qa.automated.web.bci.Definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.en.Then;

public class buscarEnGoogle {

    public static WebDriver browser;
    
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
    }

    @After
    public void tearDown(){
        browser.quit();
    }
    
    @Given("^Estoy en la pagina \"([^\"]*)\"$")
    public void estoy_en_la_pagina_something(String url) throws Throwable {
        browser.get(url);
    }

    @When("^busco \"([^\"]*)\"$")
    public void busco_something(String qText) throws Throwable {
        browser.findElement(By.name("q")).sendKeys(qText);
        Thread.sleep(1000);
        browser.findElement(By.id("tsf")).submit();
        Thread.sleep(1000);
    }

    @Then("^aparece \"([^\"]*)\"$")
    public void aparece_something(String resultado) throws Throwable {
        Thread.sleep(1000);
        assertTrue(browser.getTitle().contains(resultado));
        Thread.sleep(1000);
    }

}
package stepdef;


import commons.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MyStepdefs {
    public CommonLib commonLib;


    @Before
    public void setup() {
        commonLib = new CommonLib(MyDriver.getMyDriver());
    }

    @When("I see {string} page")
    public void seePage(String page) throws IOException, ParseException
    {
        commonLib.seePage(page);
    }

    @When("I go to url:{string}")
    public void navigateURL(String url)
    {
        commonLib.ıGoToUrl(url);
    }

    @When("I send key to {string} element text:{string}")
    public void sendKey(String element, String text)
    {
        commonLib.sendKeys(element, text);
    }

    @When("I click to {string} element")
    public void clickElement(String element) {
        commonLib.clickElement(element);
    }

    @When("I wait until element to be clickable and click to {string} element ")
    public void clickElementWaitUntilClickable(String element) {
        commonLib.clickElementWaitUntilClickable(element);
    }

    @When("I wait {string} element ")
    public void waitElement(String element) {
        commonLib.waitElement(element);
    }

    @When("^I click (enter|tab) element:(.*)$")
    public void clickKeyboard(String key, String element) {
        commonLib.clickKeyboard(element, key);
    }

    @When("I wait {string} element and check visibility")
    public void waitElementAndCheckVisibility(String element) {
        commonLib.waitElementAndCheckVisibility(element);
    }

    @When("I sleep for {int} seconds")
    public void sleep(int sec) throws InterruptedException {
        commonLib.sleep(sec);
    }


}

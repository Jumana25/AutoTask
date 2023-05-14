package CucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.JawwyHome;

public class Steps {
    private SHAFT.GUI.WebDriver driver;
    JawwyHome jawwyHome = new JawwyHome(driver);

    /**
     * Requires the following setting in the cucumber.properties file to run
     * cucumber.glue=CucumberSteps
     */
    @Given("I Open the target browser")
    public void i_open_the_target_browser() {
        this.driver = new SHAFT.GUI.WebDriver();
    }

    @And("Navigate to URL {string}")
    public void navigateToURL(String url) {
        driver.browser().navigateToURL(url);
    }

    @When("I Click the element located by xpath {string}")
    public void iClickTheElementLocatedByXpath(String locator) {
        driver.element().click(By.xpath(locator));
    }

    @Then("I should see country popup closed")
    public void iShouldSeeCountryPopupClosed() {
//        driver.assertThat().element(By.xpath("//*[@id='links_group']/li[7]/a")).text().contains("VAT Registration Certificate")
//                .withCustomReportMessage("Check that result stats is not empty").perform();
        new JawwyHome(driver).verifyCountryPopupClosed();
    }

    @And("Switch current language")
    public void switchCurrentLanguage() {
        new JawwyHome(driver).switchLanguage();
    }

    @When("I choose country {string}")
    public void iChooseCountry(String countryName) {
        new JawwyHome(driver).selectCountyByName(countryName);
    }

    @And("Close country popup")
    public void closeCountryPopup() {
        new JawwyHome(driver).closeCountryPopup();
        new JawwyHome(driver).verifyCountryPopupClosed();
    }

    @When("I set country {string}")
    public void iSetCountry(String countryName) {
//        jawwyHome.openCountryPopup();
//        jawwyHome.selectCountyByName(countryName);
//        jawwyHome.closeCountryPopup();
//        jawwyHome.verifyCountryPopupClosed();
        new JawwyHome(driver).openCountryPopup();
        new JawwyHome(driver).selectCountyByName(countryName);
//        new JawwyHome(driver).closeCountryPopup();
        new JawwyHome(driver).verifyCountryPopupClosed();
    }

    @Then("I should see correct currency displayed {string}")
    public void iShouldSeeCorrectCurrencyDisplayed(String expectedCurrency) {
        new JawwyHome(driver).verifyDisplayedCurrency(expectedCurrency);
    }

    @Then("I should see correct price displayed {string} for lite plan")
    public void iShouldSeeCorrectPriceDisplayedForLitePlan(String expectedPrice) {
        new JawwyHome(driver).verfiyDisplayedPrice_Lite(expectedPrice);
    }

    @Then("I should see correct price displayed {string} for classic plan")
    public void iShouldSeeCorrectPriceDisplayedForClassicPlan(String expectedPrice) {
        new JawwyHome(driver).verfiyDisplayedPrice_Classic(expectedPrice);
    }

    @Then("I should see correct price displayed {string} for premium plan")
    public void iShouldSeeCorrectPriceDisplayedForPremiumPlan(String expectedPrice) {
        new JawwyHome(driver).verfiyDisplayedPrice_Premium(expectedPrice);
    }
}

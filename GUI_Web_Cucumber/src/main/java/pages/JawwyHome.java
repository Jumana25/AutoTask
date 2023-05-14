package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class JawwyHome {
    private SHAFT.GUI.WebDriver driver;
    public JawwyHome(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //***********************************Element By locators//***********************************

    By language_Btn = By.id("translation-btn");
    By countryPopupOpen_Btn = By.xpath("//div[@class='country-current']");
    By countryPopupClose_Btn = By.xpath("//*[@id='country-poppup-close']");
    By trialCostPrice_Lbl = By.xpath("//*[@class='trial-cost']");
    By lightPlanPrice_Lbl = By.xpath("//*[@id='currency-lite']/b");
    By classicPlanPrice_Lbl = By.xpath("//*[@id='currency-classic']/b");
    By premiumPlanPrice_Lbl = By.xpath("//*[@id='currency-premium']/b");

    //***********************************Element Actions***********************************

    public void switchLanguage() {
        driver.element().click(language_Btn);
    }

    public void openCountryPopup() {
        driver.element().click(countryPopupOpen_Btn);
    }

    public void selectCountyByName(String countryName){
        String countryAbv = null;
        switch (countryName){
            case "Egypt": countryAbv = "eg";
            break;
            case "UAE": countryAbv = "ae";
            break;
            case "Tunisia": countryAbv = "tn";
            break;
            default: countryAbv = "eg";
        }
        driver.element().click(By.id(countryAbv));
    }

    public void closeCountryPopup() {
        driver.element().click(countryPopupClose_Btn);
    }

    //***********************************Valdations***********************************

    public void verifyCountryPopupClosed(){
        driver.verifyThat().element(countryPopupClose_Btn).isHidden();
    }

    public void verifyDisplayedCurrency(String expectedCurrency){
        driver.assertThat().element(trialCostPrice_Lbl).text().contains(expectedCurrency)
                .withCustomReportMessage("Verify displayed currency").perform();
    }

    public void verfiyDisplayedPrice_Lite(String expectedPrice){
        driver.assertThat().element(lightPlanPrice_Lbl).text().contains(expectedPrice)
                .withCustomReportMessage("Verify displayed price").perform();
    }

    public void verfiyDisplayedPrice_Classic(String expectedPrice){
        driver.assertThat().element(classicPlanPrice_Lbl).text().contains(expectedPrice)
                .withCustomReportMessage("Verify displayed price").perform();
    }

    public void verfiyDisplayedPrice_Premium(String expectedPrice){
        driver.assertThat().element(premiumPlanPrice_Lbl).text().contains(expectedPrice)
                .withCustomReportMessage("Verify displayed price").perform();
    }
}

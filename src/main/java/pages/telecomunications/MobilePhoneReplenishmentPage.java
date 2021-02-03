package pages.telecomunications;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MobilePhoneReplenishmentPage extends BasePage {
    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By buttonSubmitToTheCart = By.xpath("//button[@data-qa-node='submit']");
    private final By inputCardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputDCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputDCardCVV = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By paymentDetails = By.xpath("//span[@data-qa-node='details']");

    public MobilePhoneReplenishmentPage(WebDriver driver) {
        super(driver);
    }

    public void goToURL(String url) {
        driver.get(url);
    }

    /**
     * Choose a card from the wallet
     */
    @Step(value = "Выбор карты")
    public MobilePhoneReplenishmentPage selectCardFromWallet() {
        driver.findElement(buttonWallet).click();
        return this;
    }

    /**
     * Enter phone number excluding country code
     *
     * @param number phone number
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number) {
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }

    /**
     * Enter amount payment
     *
     * @param amount money amount
     */
    public MobilePhoneReplenishmentPage enterAmount(String amount) {
        driver.findElement(inputAmount).sendKeys(amount);
        return this;
    }

    /**
     *
     */
    public MobilePhoneReplenishmentPage enterCardFrom(String card) {
        driver.findElement(inputCardFrom).sendKeys(card);
        return this;
    }

    /**
     *
     */
    public MobilePhoneReplenishmentPage enterCardExpDate(String expDate) {
        driver.findElement(inputDCardExpDate).sendKeys(expDate);
        return this;
    }

    /**
     *
     */
    public MobilePhoneReplenishmentPage enterCVV(String cvv) {
        driver.findElement(inputDCardCVV).sendKeys(cvv);
        return this;
    }

    /**
     *
     */
    public MobilePhoneReplenishmentPage submitToTheCard() {
        driver.findElement(buttonSubmitToTheCart).click();
        return this;
    }

    /**
     * @param text
     */
    public MobilePhoneReplenishmentPage scheckPaymentDetailsIsPresentInTheCart(String text) {
        waitElementIsVisible(driver.findElement(paymentDetails));
        WebElement details = driver.findElement(paymentDetails);
        Assertions.assertEquals(text, details.getText());
        return this;
    }

}

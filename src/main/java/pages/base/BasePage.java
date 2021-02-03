package pages.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariables.EXPLICITY_WAIT;

public class BasePage {
    public final By authWidgetBy = By.xpath("//iframe[@src='https://login-widget.privat24.ua/']");
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * The method for navigating to a specific URL
     */
    @Step(value = "Переход по ссылке {url}")
    public void goToURL(String url) {
        driver.get(url);
    }

    /**
     * Wait for visibility element in DOM model
     **/
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Check is Auth frame is visible
     */
    @Step(value = "Проверка отображения виджета авторизации")
    public void isAuthWidgetPresent() {
        WebElement authWidget = driver.findElement(authWidgetBy);
        waitElementIsVisible(authWidget);
    }
}

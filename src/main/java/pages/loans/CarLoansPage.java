package pages.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarLoansPage {
    private final By tabAgreements = By.xpath("//div[contains(text(),'Agreements')]");
    WebDriver driver;

    public CarLoansPage(WebDriver driver) {
        this.driver = driver;
    }

    public CarLoansPage selectAgreementsTab() {
        driver.findElement(tabAgreements).click();
        return this;
    }
}

package tests.loans.positive;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.CAR_LOANS_URL;

public class CarLoansPositiveTest extends BaseTest {
    @Epic(value = "УКОЗ")
    @Feature(value = "Проекты классификации")
    @Story(value = "Создание проекта")


    @Test
    public void selectAgreementsTabIeInPublicSession() {
        basePage.goToURL(CAR_LOANS_URL);
        carLoansPage.selectAgreementsTab();
        basePage.isAuthWidgetPresent();
    }
}

package tests.telecomunications.positive;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.MobileReplenishmentTestData.*;
import static constants.Constant.Urls.MOBILE_PAYMENT_URL;

public class MobilePhoneReplenishmentPositiveTest extends BaseTest {

    @Epic(value = "УКОЗ")
    @Feature(value = "Реестр объектов")
    @DisplayName("Пользовватель доджен видеть")
    @Link(name = "QA213", type = "task")
    @Story(value = "Создание ОЗ")

    @Test
    public void checkIsRedirectToAuth() {
        basePage.goToURL(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.selectCardFromWallet();
        basePage.isAuthWidgetPresent();
    }

    @Epic(value = "УИИБ")
    @Feature(value = "ППроекты требований")
    @Story(value = "Создание проекта")
    @Test
    public void checkMinimumReplenishmentAmount() {
        basePage.goToURL(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage
                .enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
                .enterAmount("1")
                .enterCardFrom(MOBILE_PAYMENT_CARD)
                .enterCardExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
                .enterCVV(MOBILE_PAYMENT_CARD_CVV)
                .submitToTheCard()
                .scheckPaymentDetailsIsPresentInTheCart("Mobile payment. Phone number +380686969712");
    }
}

package ru.netology.test;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.ru.netology.page.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class MoneyTransferTest {
    private SelenideElement cardFirst=$("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement cardSecond=$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    @BeforeEach
    void setUppAll() {
      open("http://localhost:9999");
    }

    @Test
    void transferFromCardOneToCardTwo () {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode= DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.selectReplenishCard("first");
        dashboardPage.replenishAmount("5000");
        dashboardPage.selectReplenishCard("second");
        dashboardPage.replenishAmount("10000");
        $(cardFirst).shouldHave(text("баланс: 5000"));
    }
}

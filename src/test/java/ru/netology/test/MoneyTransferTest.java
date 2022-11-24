package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.ru.netology.page.DashboardPage;
import ru.netology.ru.netology.page.LoginPage;
import ru.netology.ru.netology.page.ReplenishPage;


import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {

    @BeforeEach
    void setUppAll() {
        open("http://localhost:9999");
    }

    @Test
    void successfulTransferTest() throws Exception {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceBeforeTransfer = new DashboardPage().getCardBalance("first");
        var replenishPage = dashboardPage.selectReplenishCard("first");
        val amount = new ReplenishPage().getAmount("500");
        var replenishAmount = replenishPage.validAmount("amount");

        val actual = new DashboardPage().getCardBalance("first");

        double expected = Double.parseDouble(amount) + balanceBeforeTransfer;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void successfulDebitingTest() throws Exception {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceBeforeTransfer = new DashboardPage().getCardBalance("second");
        var replenishPage = dashboardPage.selectReplenishCard("first");
        val amount = new ReplenishPage().getAmount("5000");
        var replenishAmount = replenishPage.validAmount("amount");

        val actual1 = new DashboardPage().getCardBalance("second");

        double expected1 = balanceBeforeTransfer - Double.parseDouble(amount);

        Assertions.assertEquals(actual1, expected1);
        Assertions.assertTrue (actual1 >=0);
    }
}

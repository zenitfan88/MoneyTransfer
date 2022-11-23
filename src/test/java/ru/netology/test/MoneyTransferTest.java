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
    void transferFromCardOneToCardTwo() throws Exception {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceBeforeTransfer = new DashboardPage().getCardBalance("second");
        var replenishPage = dashboardPage.selectReplenishCard("second");
        val amount = new ReplenishPage().getAmount(50000);
        var replenishAmount = replenishPage.validAmount(amount);

//        var replenishPage1 = dashboardPage.selectReplenishCard("first");
////        val amount1 = new ReplenishPage().getAmount(500);
//        var replenishAmount1 = replenishPage.validAmount(amount);
        val balanceAfterTransfer = new DashboardPage().getCardBalance("second");
        int expected = amount + balanceBeforeTransfer;
        int actual = balanceAfterTransfer;
        Assertions.assertEquals(actual, expected);

    }
}

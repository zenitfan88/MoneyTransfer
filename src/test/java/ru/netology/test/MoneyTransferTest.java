package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.ReplenishPage;


import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {

    @BeforeEach
    void setUppAll() {
        open("http://localhost:9999");
    }

    @Test
    void TransferTest() throws Exception {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        val balanceFirstCardBeforeTransfer = new DashboardPage().getCardBalance("first");
        val balanceSecondCardBeforeTransfer = new DashboardPage().getCardBalance("second");

        var replenishCard = DataHelper.getReplenishCard("second");
        var selectReplenishCard = dashboardPage.selectReplenishCard(replenishCard);
        val amount = new ReplenishPage().getAmount("5000");
        var validAmount = ReplenishPage.numberCard(replenishCard);

        val actualBalanceCardTransferredTo = new DashboardPage().getCardBalance("first");
        val actualBalanceCardTransferredFrom = new DashboardPage().getCardBalance("second");

        double expectedBalanceCardTransferredTo = balanceFirstCardBeforeTransfer - Double.parseDouble(amount);
        double expectedBalanceCardTransferredFrom = balanceSecondCardBeforeTransfer + Double.parseDouble(amount);
        Assertions.assertEquals(actualBalanceCardTransferredTo, expectedBalanceCardTransferredTo);
        Assertions.assertEquals(actualBalanceCardTransferredFrom, expectedBalanceCardTransferredFrom);
        Assertions.assertTrue(expectedBalanceCardTransferredFrom >= 0);
    }
}

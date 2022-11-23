package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.ru.netology.page.DashboardPage;
import ru.netology.ru.netology.page.LoginPage;
import ru.netology.ru.netology.page.ReplenishPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MoneyTransferTest {

    @BeforeEach
    void setUppAll() {
        open("http://localhost:9999");
    }

    @Test
    void transferFromCardOneToCardTwo() throws Exception {
        var loginPage = new LoginPage();
//        var amount = DataHelper.getAmount(5000);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var replenishPage = dashboardPage.selectReplenishCard("first");
        var replenishAmount = replenishPage.validAmount(5000);
        val amount = new ReplenishPage().validAmount(5000);
//        dashboardPage.selectReplenishCard("first");
//        dashboardPage.replenishAmount("5000");

//        val balanceFirst1 = new DashboardPage().getCardBalance("second");
//        dashboardPage.selectReplenishCard("second");
//        dashboardPage.replenishAmount("5000");
        val balanceFirst = new DashboardPage().getCardBalance("second");
//        var weqwqwr1=dashboardPage.validAmount(new DataHelper.Amount("5000"));
//        val amount = DataHelper.getAmount(5000);
//        int itogo = val amount;
//        int itogo = Integer.parseInt(String.valueOf(amount)) + balanceFirst;
        System.out.println(replenishPage.validAmount(amount));
        System.out.println(amount);
        System.out.println(balanceFirst);
//        $(cardFirst).shouldHave(text("баланс: " + itogo));
    }
}

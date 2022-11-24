package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishPage {
    private static SelenideElement amountField = $("[data-test-id='amount'] input");
    private static SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public String getAmount(String amount) {
        amountField.setValue(amount);
        return amount;
    }

    public DashboardPage validAmount(String amount) {
        transferButton.click();
        return new DashboardPage();
    }

}

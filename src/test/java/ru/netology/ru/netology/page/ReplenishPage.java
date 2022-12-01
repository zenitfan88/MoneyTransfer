package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;


public class ReplenishPage {
    private static SelenideElement amountField = $("[data-test-id='amount'] input");
    private static SelenideElement fromField = $("[data-test-id='from'] input");
    private static SelenideElement transferButton = $("[data-test-id='action-transfer']");


    public String getAmount(String amount) {
        amountField.setValue(amount);
        return amount;
    }

    public static DashboardPage numberCard(DataHelper.ReplenishCard card) {
        fromField.setValue(card.getNumberCard());
        transferButton.click();
        return new DashboardPage();
    }
}

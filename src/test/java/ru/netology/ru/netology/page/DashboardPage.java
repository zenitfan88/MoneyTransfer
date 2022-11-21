package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement replenishFirstСardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement replenishSecondСardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private String numberFirstCard = "5559000000000001";
    private String numberSecondCard = "5559000000000002";


    public void selectReplenishCard(String card) {
        if (card == "first") {
            replenishFirstСardButton.click();
            fromField.setValue(numberSecondCard);
        }

        if (card == "second") {
            replenishSecondСardButton.click();
            fromField.setValue(numberFirstCard);
        } else {
            System.out.println("Такой какрты не существует");
        }
    }

    public void replenishAmount(String amount) {
        amountField.setValue(amount);
        transferButton.click();
    }
}


package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement cardFirst = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement cardSecond = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private SelenideElement replenishFirstСardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-" +
            "206f6b1f56c0'] button");
    private SelenideElement replenishSecondСardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-" +
            "09f7a039391d'] button");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private String numberFirstCard = "5559000000000001";
    private String numberSecondCard = "5559000000000002";
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
    }


    public double getCardBalance(String card) throws Exception {
        if (card == "first") {
            val text = cardFirst.text();
            return extractBalance(text);
        }
        if (card == "second") {
            val text = cardSecond.text();
            return extractBalance(text);
        }
        throw new Exception("Такой какрты не существует");
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public ReplenishPage selectReplenishCard(String card) {
        if (card == "first") {
            replenishFirstСardButton.click();
            fromField.setValue(numberSecondCard);
        }

        if (card == "second") {
            replenishSecondСardButton.click();
            fromField.setValue(numberFirstCard);
        }
        return new ReplenishPage();
    }
}


package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static ru.netology.data.DataHelper.replenishСardButton;

public class DashboardPage {
    private SelenideElement cardFirst = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement cardSecond = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
    }

    public double getCardBalance(String card) throws Exception {
        if (card.equals("first")) {
            val text = cardFirst.text();
            return extractBalance(text);
        }
        if (card.equals("second")) {
            val text = cardSecond.text();
            return extractBalance(text);
        }
        throw new Exception("Выбранной карты не существует");
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public ReplenishPage selectReplenishCard(DataHelper.ReplenishCard card) {
        replenishСardButton.click();
        return new ReplenishPage();
    }
}


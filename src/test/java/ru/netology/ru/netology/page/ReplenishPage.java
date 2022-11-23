package ru.netology.ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishPage {
    private static SelenideElement amountField = $("[data-test-id='amount'] input");
    private static SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public int getAmount(int amount) {
        amountField.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        amountField.setValue(String.valueOf(amount));
        return amount;
    }

    public DashboardPage validAmount(int amount) {
        transferButton.click();
        return new DashboardPage();
    }

}

package ru.netology.data;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$;

public class DataHelper {
    public static SelenideElement replenishСardButton;

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class ReplenishCard {
        public String card;
        SelenideElement replenishСardButton;
        public String numberCard;
    }

    public static ReplenishCard getReplenishCard(String card) throws Exception {
        if (card.equals("first")) {
            replenishСardButton = $("[data-test-id='92df3f1c-a033-48e6-8390-" +
                    "206f6b1f56c0'] button");
            String numberCard = "5559000000000002";
            return new ReplenishCard(card, replenishСardButton, numberCard);
        }
        if (card.equals("second")) {
            replenishСardButton = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-" +
                    "09f7a039391d'] button");
            String numberCard = "5559000000000001";
            return new ReplenishCard(card, replenishСardButton, numberCard);
        }
        throw new Exception("Такой карты не существует");
    }
}

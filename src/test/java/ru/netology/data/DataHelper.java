package ru.netology.data;

import lombok.Value;


public class DataHelper {

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
        public String cardId;
        public String numberCard;
    }

    public static ReplenishCard getReplenishCard(String card) throws Exception {
        if (card.equals("first")) {
            String cardId = "92df3f1c-a033-48e6-8390-206f6b1f56c0";
            String numberCard = "5559000000000002";
            return new ReplenishCard(card, cardId, numberCard);
        }
        if (card.equals("second")) {
            String cardId = "0f3f5c2a-249e-4c3d-8287-09f7a039391d";
            String numberCard = "5559000000000001";
            return new ReplenishCard(card, cardId, numberCard);
        }
        throw new Exception("Такой карты не существует");
    }
}

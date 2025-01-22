package org.example.order_crud.domain.enumeration;

public enum OrderStatus {

    PENDING("PENDING"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED");

    private String text;

    OrderStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static OrderStatus fromString(String text) {
        for (OrderStatus os : OrderStatus.values()) {
            if (os.text.equalsIgnoreCase(text)) {
                return os;
            }
        }
        return null;
    }

    public static String fromEnum(OrderStatus orderStatus) {
        if (orderStatus != null) {
            return orderStatus.getText();
        }
        return null;
    }
}

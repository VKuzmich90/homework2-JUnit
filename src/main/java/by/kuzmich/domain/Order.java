package by.kuzmich.domain;

import java.time.LocalDate;

public class Order {

    private final String id;

    private final String userId;

    private OrderStatus status;

    private OrderItem[] items;

    private String deliveryAdress;

    private LocalDate date;

    public Order(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderItem[] getItems() {
        return items;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setItems(OrderItem[] items) {
        this.items = items;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public void setDate() {
        this.date = date;
    }
}

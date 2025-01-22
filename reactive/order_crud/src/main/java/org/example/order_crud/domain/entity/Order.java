package org.example.order_crud.domain.entity;


import org.example.order_crud.domain.enumeration.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "orders")
public class Order {

    @Id
    private long id;

    private String theName;

    private double totalAmount;

    private String status;

    private LocalDateTime theDate;

    public Order(String theName, double totalAmount, String status, LocalDateTime theDate) {
        this.theName = theName;
        this.totalAmount = totalAmount;
        this.status = status;
        this.theDate = theDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return theName;
    }

    public void setName(String name) {
        this.theName = name;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(OrderStatus orderStatus) {
        this.status = OrderStatus.fromEnum(orderStatus);
    }

    public LocalDateTime getTheDate() {
        return theDate;
    }

    public void setTheDate(LocalDateTime theDate) {
        this.theDate = theDate;
    }
}

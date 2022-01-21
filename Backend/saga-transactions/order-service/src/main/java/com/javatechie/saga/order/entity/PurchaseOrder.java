package com.javatechie.saga.order.entity;

import com.javatechie.saga.commons.event.OrderStatusEnum;
import com.javatechie.saga.commons.event.PaymentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PURCHASE_ORDER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;
}

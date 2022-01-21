package com.javatechie.saga.order.config;

import com.javatechie.saga.commons.dto.OrderRequestDto;
import com.javatechie.saga.commons.event.OrderStatusEnum;
import com.javatechie.saga.commons.event.PaymentStatusEnum;
import com.javatechie.saga.order.entity.PurchaseOrder;
import com.javatechie.saga.order.repository.OrderRepository;
import com.javatechie.saga.order.service.OrderStatusPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@Configuration
public class   OrderStatusUpdateHandler {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusPublisher orderStatusPublisher;

    @Transactional
    public void updateOrder(int id, Consumer<PurchaseOrder> consumer) {
        orderRepository.findById(id).ifPresent(consumer.andThen(this::updateOrder));
    }

    private void updateOrder(PurchaseOrder purchaseOrder) {
        boolean isPaymentComplete = PaymentStatusEnum.PAYMENT_COMPLETED.equals(purchaseOrder.getPaymentStatusEnum());
        OrderStatusEnum orderStatusEnum = isPaymentComplete ? OrderStatusEnum.ORDER_COMPLETED : OrderStatusEnum.ORDER_CANCELLED;
        purchaseOrder.setOrderStatusEnum(orderStatusEnum);

        if (!isPaymentComplete) {
            orderStatusPublisher.publishOrderEvent(convertEntityToDto(purchaseOrder), orderStatusEnum);
        }
    }

    public OrderRequestDto convertEntityToDto(PurchaseOrder purchaseOrder) {
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderId(purchaseOrder.getId());
        orderRequestDto.setUserId(purchaseOrder.getUserId());
        orderRequestDto.setAmount(purchaseOrder.getPrice());
        orderRequestDto.setProductId(purchaseOrder.getProductId());
        return orderRequestDto;
    }
}

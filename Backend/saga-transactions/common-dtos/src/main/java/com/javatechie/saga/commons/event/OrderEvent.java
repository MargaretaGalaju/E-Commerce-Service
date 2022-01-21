package com.javatechie.saga.commons.event;

import com.javatechie.saga.commons.dto.OrderRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@Data
public class OrderEvent implements Event{

    private UUID eventId=UUID.randomUUID();
    private Date eventDate=new Date();
    private OrderRequestDto orderRequestDto;
    private OrderStatusEnum orderStatusEnum;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatusEnum orderStatusEnum) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatusEnum = orderStatusEnum;
    }
}

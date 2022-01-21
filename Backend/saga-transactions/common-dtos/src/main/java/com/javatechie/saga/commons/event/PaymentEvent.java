package com.javatechie.saga.commons.event;

import com.javatechie.saga.commons.dto.PaymentRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@Data
public class PaymentEvent implements Event{

    private UUID eventId=UUID.randomUUID();
    private Date eventDate=new Date();
    private PaymentRequestDto paymentRequestDto;
    private PaymentStatusEnum paymentStatusEnum;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }

    public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatusEnum paymentStatusEnum) {
        this.paymentRequestDto = paymentRequestDto;
        this.paymentStatusEnum = paymentStatusEnum;
    }
}

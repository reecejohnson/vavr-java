package vavr.resource.http.mapper;

import vavr.entity.Order;
import vavr.entity.OrderResponse;

public class OrderToCreateOrderResponseMapper {

    public OrderResponse map(Order order) {
        return OrderResponse.builder()
                .amount(order.getAmount())
                .name(order.getName())
                .build();
    }

}


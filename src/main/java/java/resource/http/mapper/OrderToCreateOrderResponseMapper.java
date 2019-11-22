package java.resource.http.mapper;

import java.entity.Order;
import java.entity.OrderResponse;

public class OrderToCreateOrderResponseMapper {

    public OrderResponse map(Order order) {
        return OrderResponse.builder()
                .amount(order.getAmount())
                .name(order.getName())
                .build();
    }

}


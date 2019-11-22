package vavr.usecase.mapper;

import vavr.entity.Order;
import vavr.entity.OrderRequest;

public class OrderRequestToOrderMapper {

    public Order map(OrderRequest orderRequest) {
        return Order.builder()
                .amount(orderRequest.getAmount())
                .name(orderRequest.getName())
                .build();
    }

}

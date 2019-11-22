package java.usecase.mapper;

import java.entity.Order;
import java.entity.OrderRequest;

public class OrderRequestToOrderMapper {

    public Order map(OrderRequest orderRequest) {
        return Order.builder()
                .amount(orderRequest.getAmount())
                .name(orderRequest.getName())
                .build();
    }

}

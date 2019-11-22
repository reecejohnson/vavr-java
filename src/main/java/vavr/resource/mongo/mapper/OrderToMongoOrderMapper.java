package vavr.resource.mongo.mapper;

import vavr.entity.Order;
import vavr.resource.mongo.model.MongoOrder;

public class OrderToMongoOrderMapper {
    public MongoOrder map(Order order) {
        return MongoOrder.builder()
                .amount(order.getAmount())
                .name(order.getName())
                .build();
    }
}

package java.resource.mongo.mapper;

import java.entity.Order;
import java.resource.mongo.model.MongoOrder;

public class OrderToMongoOrderMapper {
    public MongoOrder map(Order order) {
        return MongoOrder.builder()
                .amount(order.getAmount())
                .name(order.getName())
                .build();
    }
}

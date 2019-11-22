package java.resource.mongo;

import java.entity.Order;
import java.resource.mongo.model.MongoOrder;

public class Repository {
    public Order create(MongoOrder mongoOrder) {
        return Order.builder()
                    .amount(mongoOrder.getAmount())
                    .name("Order")
                    .build();
    }
}

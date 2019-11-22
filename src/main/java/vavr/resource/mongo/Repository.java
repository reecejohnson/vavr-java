package vavr.resource.mongo;

import io.vavr.control.Try;
import vavr.entity.Order;
import vavr.resource.mongo.model.MongoOrder;

public class Repository {
    public Try<Order> create(MongoOrder mongoOrder) {
        return Try.success(Order.builder()
                    .amount(mongoOrder.getAmount())
                    .name("Order")
                    .build());
    }
}

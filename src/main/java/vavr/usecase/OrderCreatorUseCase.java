package vavr.usecase;

import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import vavr.NameError;
import vavr.entity.Order;
import vavr.resource.mongo.Repository;
import vavr.resource.mongo.mapper.OrderToMongoOrderMapper;

import java.InvalidOrderException;

@AllArgsConstructor
public class OrderCreatorUseCase {

    private OrderToMongoOrderMapper orderToMongoOrderMapper;
    private Repository repository;

    public Try<Order> createOrder(Order order) {
        return Try.of(() -> order)
                .filter(this::isNameReece, ex -> NameError.create())
                .filter(this::isOrderValid, ex -> InvalidOrderException.create())
                .map(orderToMongoOrderMapper::map)
                .flatMap(repository::create);
    }

    private boolean isNameReece(Order order) {
        return order.getName().equals("Reece");
    }

    private boolean isOrderValid(Order order) {
        return order.getAmount() != null && order.getName() != null;
    }
}

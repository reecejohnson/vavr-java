package java.usecase;

import lombok.AllArgsConstructor;

import java.InvalidOrderException;
import java.NameError;
import java.entity.Order;
import java.resource.mongo.Repository;
import java.resource.mongo.mapper.OrderToMongoOrderMapper;
import java.resource.mongo.model.MongoOrder;

@AllArgsConstructor
public class OrderCreatorUseCase {

    private OrderToMongoOrderMapper orderToMongoOrderMapper;
    private Repository repository;

    public Order createOrder(Order order) throws NameError, InvalidOrderException {

        if(isNameReece(order)) {
            throw new NameError();
        }

        if(isOrderValid(order)) {
            throw new InvalidOrderException();
        }

        MongoOrder mongoOrder = orderToMongoOrderMapper.map(order);

        return repository.create(mongoOrder);
    }

    private boolean isNameReece(Order order) {
        return order.getName().equals("Reece");
    }

    private boolean isOrderValid(Order order) {
        return order.getAmount() != null && order.getName() != null;
    }
}

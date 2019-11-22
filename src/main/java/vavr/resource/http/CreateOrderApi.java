package vavr.resource.http;

import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import vavr.NameError;
import vavr.Response;
import vavr.ResponseFactory;
import vavr.entity.OrderRequest;
import vavr.resource.http.mapper.OrderToCreateOrderResponseMapper;
import vavr.usecase.OrderCreatorUseCase;
import vavr.usecase.mapper.OrderRequestToOrderMapper;

import java.InvalidOrderException;

@AllArgsConstructor
public class CreateOrderApi {

    private OrderCreatorUseCase orderCreatorUseCase;
    private OrderRequestToOrderMapper orderRequestToOrderMapper;
    private OrderToCreateOrderResponseMapper orderToCreateOrderResponseMapper;
    private ResponseFactory responseFactory;

    public Response createOrder(OrderRequest orderRequest) {
        return Try.success(orderRequestToOrderMapper.map(orderRequest))
                .flatMap(orderCreatorUseCase::createOrder)
                .map(orderToCreateOrderResponseMapper::map)
                .map(responseFactory::createSuccessResponse)
                .recover(NameError.class, ex -> responseFactory.createServerError(ex))
                .recover(InvalidOrderException.class, ex -> responseFactory.createUnprocessableEntityError(ex))
                .get();
    }

}

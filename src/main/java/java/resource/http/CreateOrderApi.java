package java.resource.http;

import lombok.AllArgsConstructor;

import java.InvalidOrderException;
import java.NameError;
import java.Response;
import java.ResponseFactory;
import java.entity.Order;
import java.entity.OrderRequest;
import java.entity.OrderResponse;
import java.resource.http.mapper.OrderToCreateOrderResponseMapper;
import java.usecase.OrderCreatorUseCase;
import java.usecase.mapper.OrderRequestToOrderMapper;

@AllArgsConstructor
public class CreateOrderApi {

    private OrderCreatorUseCase orderCreatorUseCase;
    private OrderRequestToOrderMapper orderRequestToOrderMapper;
    private OrderToCreateOrderResponseMapper orderToCreateOrderResponseMapper;
    private ResponseFactory responseFactory;

    public Response createOrder(OrderRequest orderRequest) {
        try {
            Order order = orderRequestToOrderMapper.map(orderRequest);
            Order createdOrder = orderCreatorUseCase.createOrder(order);
            OrderResponse orderResponse = orderToCreateOrderResponseMapper.map(createdOrder);
            return responseFactory.createSuccessResponse(orderResponse);
        } catch (NameError ex) {
            return responseFactory.createServerError(ex);
        } catch (InvalidOrderException ex) {
            return responseFactory.createUnprocessableEntityError(ex);
        }
    }

}

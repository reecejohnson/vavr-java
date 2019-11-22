package vavr.resource.http.model;

import lombok.Builder;

@Builder
public class CreateOrderRequest {
    private final String name;
    private final Integer amount;
}

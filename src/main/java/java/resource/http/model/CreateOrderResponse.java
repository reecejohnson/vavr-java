package java.resource.http.model;

import lombok.Builder;

@Builder
public class CreateOrderResponse {
    private final String name;
    private final Integer amount;
}

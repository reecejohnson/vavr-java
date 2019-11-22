package java.entity;

import lombok.Builder;

@Builder(toBuilder = true)
public class OrderResponse {
    private final String name;
    private final Integer amount;
}

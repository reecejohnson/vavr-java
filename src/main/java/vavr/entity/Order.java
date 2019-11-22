package vavr.entity;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Order {
    private final String name;
    private final Integer amount;
}

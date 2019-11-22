package vavr.resource.mongo.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class MongoOrder {
    private final String name;
    private final Integer amount;
}

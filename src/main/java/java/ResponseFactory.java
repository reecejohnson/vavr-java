package java;

import java.entity.OrderResponse;

public class ResponseFactory {

    public Response createSuccessResponse(OrderResponse orderResponse) {
        return new Response(200);
    }

    public Response createUnprocessableEntityError(Exception ex) {
        return new Response(422);
    }

    public Response createServerError(Exception e) {
        return new Response(500);
    }
}

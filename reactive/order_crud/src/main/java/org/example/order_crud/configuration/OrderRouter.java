package org.example.order_crud.configuration;

import org.example.order_crud.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderRouter {

    private static final String API_ORDER_ROOT = "api/v1/order";

    @Bean
    public RouterFunction<ServerResponse> orderRoutes(OrderHandler orderHandler){
        return route(GET(API_ORDER_ROOT), orderHandler::getAllOrders)
                .andRoute(GET(API_ORDER_ROOT + "/search"), orderHandler::getAllOrdersByStatus)
                .andRoute(POST(API_ORDER_ROOT), orderHandler::saveAOrder)
                .andRoute(GET(API_ORDER_ROOT + "/{id}"), orderHandler::getOrderById)
                .andRoute(PUT(API_ORDER_ROOT + "/{id}"), orderHandler::updateAnOrder)
                .andRoute(DELETE(API_ORDER_ROOT + "/{id}"), orderHandler::deleteAnOrder)
                .andRoute(GET(API_ORDER_ROOT + "/paged"),orderHandler::getPaginatedOrders);
    }
}
